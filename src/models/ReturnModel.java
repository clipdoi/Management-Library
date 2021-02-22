package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.IssueStatus;
import entities.Librarian;
import entities.ReturnStatus;
import helpers.BCrypt;

public class ReturnModel {
	public List<ReturnStatus> findAll() {
		List<ReturnStatus> rs = null;
		try {
			 rs = new ArrayList<ReturnStatus>();
			 PreparedStatement preparedStatement = ConnectDB.getConnection()
					 .prepareStatement("select * from tb_return_book");
			 ResultSet result = preparedStatement.executeQuery();
			 while(result.next()) {
				 ReturnStatus r = new ReturnStatus();
				 r.setUser_return(result.getInt("user_return"));
				 r.setName_book(result.getString("name_book"));
				 r.setIsbn_book(result.getString("isbn_return"));
				 r.setReturn_date(result.getDate("return_date"));
				 r.setFees(result.getDouble("fees"));
				 rs.add(r);
			 }
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return rs;
	}
	public boolean create(ReturnStatus r) {
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(
					"insert into tb_return_book(user_return, name_book, isbn_return, return_date, fees) values(?,?,?,?,?)");
			
			preparedStatement.setInt(1, r.getUser_return());
			preparedStatement.setString(2, r.getName_book());
			preparedStatement.setString(3, r.getIsbn_book());
			preparedStatement.setDate(4, new java.sql.Date(r.getReturn_date().getTime()));
			preparedStatement.setDouble(5, r.getFees());
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public IssueStatus search(int id,String isbn) {
		IssueStatus i = new IssueStatus();
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("select * from tb_issue_book where user_issue = ? and isbn_book = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, isbn);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				i.setId_issue(resultSet.getInt("id_issue"));
				i.setUser_issue(resultSet.getInt("user_issue"));
				i.setBook_name(resultSet.getString("book_name"));
				i.setDue_date(resultSet.getDate("due_date"));
				i.setIssue_date(resultSet.getDate("issue_date"));
				i.setIsbn_book(resultSet.getString("isbn_book"));
			}
		} catch (Exception e) {
			i = null;
			System.out.println(e.getMessage());
		}
		return i;
	}
}
