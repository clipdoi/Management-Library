package models;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConnectDB {
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dtb", "root", "");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			System.err.println(e.getMessage());
			connection = null;
		}
		return connection;
	}
	
}
