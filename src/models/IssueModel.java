package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Book;
import entities.Employee;
import entities.IssueStatus;

public class IssueModel {

	public List<IssueStatus> findAll() {
		List<IssueStatus> is = null;
		try {
			 is = new ArrayList<IssueStatus>();
			 PreparedStatement preparedStatement = ConnectDB.getConnection()
					 .prepareStatement("select book_name , due_date, isbn_book, issue_date, user_issue, name from tb_issue_book i, tb_user_detail u where i.user_issue = u.id");
			 ResultSet result = preparedStatement.executeQuery();
			 while(result.next()) {
				 IssueStatus i = new IssueStatus();
				 i.setUser_issue(result.getInt("user_issue"));
				 i.setName(result.getString("name"));
				 i.setBook_name(result.getString("book_name"));
				 i.setIsbn_book(result.getString("isbn_book"));
				 i.setIssue_date(result.getDate("issue_date"));
				 i.setDue_date(result.getDate("due_date"));
				 is.add(i);
			 }
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return is;
	}
	public boolean createIssue(IssueStatus status) {
		try {
			PreparedStatement statement = ConnectDB.getConnection().prepareStatement(
					"insert into tb_issue_book (user_issue,due_date,book_name,issue_date,isbn_book) value(?,?,?,?,?)");
			statement.setInt(1, status.getUser_issue());
			statement.setDate(2, new java.sql.Date(status.getDue_date().getTime()));
			statement.setString(3, status.getBook_name());
			statement.setDate(4, new java.sql.Date(new Date().getTime()));
			statement.setString(5, status.getIsbn_book());
			return statement.executeUpdate() > 0;
		} catch (Exception e) {
			System.err.println("Can't create Issue bill: " + e.getMessage());
			return false;
		}

	}
	public List<IssueStatus> read() {
		List<IssueStatus> issueStatus = new ArrayList<IssueStatus>();
		try {
			PreparedStatement statement = ConnectDB.getConnection().prepareStatement(
					"select book_name ,due_date, id_issue,isbn_book, issue_date, user_issue , name from tb_issue_book i, tb_user_detail u where i.user_issue = u.id");
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				IssueStatus status = new IssueStatus();
				Employee e = new Employee();
				status.setBook_name(set.getString("book_name"));
				status.setDue_date(set.getDate("due_date"));
				status.setId_issue(set.getInt("id_issue"));
				status.setIsbn_book(set.getString("isbn_book"));
				status.setIssue_date(set.getDate("issue_date"));
				status.setUser_issue(set.getInt("user_issue"));
				e.setName(set.getString("name"));
				issueStatus.add(status);
			}
		} catch (Exception e) {
			issueStatus = null;
			System.err.println("No Issue found! " + e.getMessage());
		}
		return issueStatus;
	}
	public IssueStatus findIssueId(String id) {
		IssueStatus status = null;
		try {
			PreparedStatement statement = ConnectDB.getConnection().prepareStatement(
					"select * from tb_issue_book i,tb_user_detail d where i.user_issue=d.id isbn_book = ?");
			statement.setString(1, id);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				status = new IssueStatus();
				status.setBook_name(set.getString("book_name"));
				status.setDue_date(set.getDate("due_date"));
				status.setId_issue(set.getInt("id_issue"));
				status.setIsbn_book(set.getString("isbn_book"));
				status.setIssue_date(set.getDate("issue_date"));
				status.setUser_issue(set.getInt("user_issue"));
				status.setName(set.getString("name"));
			}
		} catch (Exception e) {
			status = null;
			System.err.println("No Id Issue found! " + e.getMessage());
		}
		return status;
	}
	
}
