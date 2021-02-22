package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import entities.History;
import entities.Librarian;

public class HistoryModel {
	public List<History> findAll() {
		List<History> hs = null;
		try {
			 hs = new ArrayList<History>();
			 PreparedStatement preparedStatement = ConnectDB.getConnection()
					 .prepareStatement("select user_issue, due_date, book_name, issue_date, i.isbn_book, return_date, fees, name  from tb_issue_book i, tb_return_book r,tb_user_detail d where i.user_issue=r.user_return and d.id = i.user_issue and i.isbn_book = r.isbn_return");
			 ResultSet result = preparedStatement.executeQuery();
			 while(result.next()) {
				 History h = new History();
				 h.setBook_name(result.getString("book_name"));
				 h.setName_user(result.getString("name"));
				 h.setDue_date(result.getDate("due_date"));
				 h.setFees(result.getDouble("fees"));
				 h.setIsbn(result.getString("isbn_book"));
				 h.setIssue_date(result.getDate("issue_date"));
				 h.setReturn_date(result.getDate("return_date"));
				 h.setUser_issue(result.getInt("user_issue"));
				 hs.add(h);
			 }
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return hs;
	}
	
	public List<History> searchDate(Date date) {
		List<History> hs = null;
		try {
			hs = new ArrayList<History>();
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("select user_issue, due_date, book_name, issue_date, i.isbn_book, return_date, fees, name  from tb_issue_book i, tb_return_book r,tb_user_detail d where i.user_issue=r.user_return and and d.id = i.user_issue and i.isbn_book=r.isbn_return and return_date = ?");
			preparedStatement.setDate(1, new java.sql.Date(date.getTime()));
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()) {
				History h = new History();
				 h.setName_user(result.getString("name"));
				 h.setBook_name(result.getString("book_name"));
				 h.setDue_date(result.getDate("due_date"));
				 h.setFees(result.getDouble("fees"));
				 h.setIsbn(result.getString("isbn_book"));
				 h.setIssue_date(result.getDate("issue_date"));
				 h.setReturn_date(result.getDate("return_date"));
				 h.setUser_issue(result.getInt("user_issue"));
				 hs.add(h);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			hs = null;
		}
		return hs;
	}
}
