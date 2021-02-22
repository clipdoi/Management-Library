package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import entities.Librarian;
import helpers.BCrypt;

public class LibrarianModel {
	public boolean create(Librarian librarian) {
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(
					"insert into tb_account(username, password, name, question, answer, created_date) values(?,?,?,?,?,?)");
			
			preparedStatement.setString(1, librarian.getUsername());
			preparedStatement.setString(2, BCrypt.hashpw(librarian.getPassword(), BCrypt.gensalt()));
			preparedStatement.setString(3, librarian.getName());
			preparedStatement.setString(4, librarian.getSec_q());
			preparedStatement.setString(5, librarian.getAnswer());
			preparedStatement.setDate(6, new java.sql.Date(librarian.getCreated().getTime()));
			
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public Librarian search(String username) {
		Librarian librarian = new Librarian();
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("select * from tb_account where username = ?");
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				librarian.setId(resultSet.getInt("id"));
				librarian.setUsername(resultSet.getString("username"));
				librarian.setName(resultSet.getString("name"));
				librarian.setSec_q(resultSet.getString("question"));
				librarian.setAnswer(resultSet.getString("answer"));
				librarian.setPassword(resultSet.getString("password"));
			}
		} catch (Exception e) {
			librarian = null;
			System.out.println(e.getMessage());
		}
		return librarian;
	}
	
	public boolean update(Librarian l) {
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(
				"update tb_account set username = ?, password = ?, name = ?, question = ?, answer = ? where id = ?");
			preparedStatement.setString(1, l.getUsername());
			preparedStatement.setString(2, BCrypt.hashpw(l.getPassword(), BCrypt.gensalt()));
			preparedStatement.setString(3, l.getName());
			preparedStatement.setString(4, l.getSec_q());
			preparedStatement.setString(5, l.getAnswer());
			preparedStatement.setInt(6, l.getId());
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
