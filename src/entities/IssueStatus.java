package entities;

import java.util.Date;

public class IssueStatus {

	private int id_issue, user_issue;
	private Date due_date, issue_date;
	private String book_name, isbn_book,name;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId_issue() {
		return id_issue;
	}

	public void setId_issue(int id_issue) {
		this.id_issue = id_issue;
	}

	public int getUser_issue() {
		return user_issue;
	}

	public void setUser_issue(int user_issue) {
		this.user_issue = user_issue;
	}

	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	public Date getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(Date issue_date) {
		this.issue_date = issue_date;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getIsbn_book() {
		return isbn_book;
	}

	public void setIsbn_book(String isbn_book) {
		this.isbn_book = isbn_book;
	}

}
