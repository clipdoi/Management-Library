package entities;

import java.util.Date;

public class ReturnStatus {
	private int id_return, user_return;
	private String name_book;
	private String isbn_book;
	private Date return_date;
	private double fees;
	
	public int getId_return() {
		return id_return;
	}
	public void setId_return(int id_return) {
		this.id_return = id_return;
	}
	public int getUser_return() {
		return user_return;
	}
	public void setUser_return(int user_return) {
		this.user_return = user_return;
	}
	public String getName_book() {
		return name_book;
	}
	public void setName_book(String name_book) {
		this.name_book = name_book;
	}
	public String getIsbn_book() {
		return isbn_book;
	}
	public void setIsbn_book(String isbn_book) {
		this.isbn_book = isbn_book;
	}
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	
	
}
