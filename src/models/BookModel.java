package models;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Book;
import entities.Category;
import entities.Employee;
import entities.ReturnStatus;

public class BookModel {

	public boolean insert(Book book) {
		try {
			PreparedStatement statement = ConnectDB.getConnection().prepareStatement(
					"insert into tb_book_detail (call_number, title, author, photo, status, rental_price, id_cat, isbn) value (?,?,?,?,?,?,?,?)");
			statement.setString(1, book.getCallnumber());
			statement.setString(2, book.getTitle());
			statement.setString(3, book.getAuthor());
			statement.setBytes(4, book.getPhoto());
			statement.setBoolean(5, book.isStatus());
			statement.setDouble(6, book.getRentprice());
			statement.setInt(7, book.getC().getId());
			statement.setString(8, book.getIsbn());

			return statement.executeUpdate() > 0;
		} catch (Exception e) {
			System.err.println("Cannot Insert book: " + e.getMessage());
			return false;
		}
	}

	public boolean update(Book book) {
		try {
			PreparedStatement statement = ConnectDB.getConnection().prepareStatement(
					"update tb_book_detail d , tb_book_cat c set title = ?, author = ?, photo = ?, status = ?, rental_price = ?, d.id_cat = ? where d.id_cat = c.id and d.call_number = ?");
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setDouble(5, book.getRentprice());
			statement.setBoolean(4, book.isStatus());
			statement.setInt(6, book.getC().getId());
			statement.setBytes(3, book.getPhoto());
			statement.setString(7, book.getCallnumber());
			return statement.executeUpdate() > 0;
		} catch (Exception e) {
			System.err.println("Cannot Update book: " + e.getMessage());
			return false;
		}
	}

	public boolean drop(String call) {
		try {
			PreparedStatement statement = ConnectDB.getConnection()
					.prepareStatement("delete from tb_book_detail where call_number = ?");
			statement.setString(1, call);
			return statement.executeUpdate() > 0;
		} catch (Exception e) {
			System.err.println("Cannot drop book: " + e.getMessage());
			return false;
		}
	}

	public List<Book> read() {
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement statement = ConnectDB.getConnection().prepareStatement(
					"select call_number , title, author, status, rental_price, isbn, photo, category, c.id from tb_book_detail d, tb_book_cat c where d.id_cat = c.id ");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setCallnumber(resultSet.getString("call_number"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setStatus(resultSet.getBoolean("status"));
				book.setRentprice(resultSet.getDouble("rental_price"));
				Category cat = new Category();
				cat.setId(resultSet.getInt("id"));
				cat.setName(resultSet.getString("category"));
				book.setC(cat);
				book.setIsbn(resultSet.getString("isbn"));
				book.setPhoto(resultSet.getBytes("photo"));
				books.add(book);
			}
		} catch (Exception e) {
			books = null;
			System.err.println("No book found! " + e.getMessage());
		}
		return books;
	}

	public List<Book> searchCallNumber(String keyword, int limit) {
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement statement = ConnectDB.getConnection().prepareStatement(
					"select * from tb_book_detail where call_number like ? order by call_number limit ?");
			statement.setString(1, "%" + keyword + "%");
			statement.setInt(2, limit);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				Book book = new Book();
				book.setCallnumber(set.getString("call_number"));
				book.setTitle(set.getString("title"));
				book.setAuthor(set.getString("author"));
				book.setStatus(set.getBoolean("status"));
				book.setRentprice(set.getDouble("rental_price"));
				Category c = new Category();
				c.setId(set.getInt("id"));
				c.setName(set.getString("category"));
				book.setC(c);
				book.setIsbn(set.getString("isbn"));
				book.setPhoto(set.getBytes("photo"));
				books.add(book);

			}
		} catch (Exception e) {
			books = null;
			System.err.println("Can't run search! " + e.getMessage());
		}
		return books;
	}

	public List<Book> searchISBN(String keyword, int limit) {
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement statement = ConnectDB.getConnection()
					.prepareStatement("select * from tb_book_detail where isbn = ? order by isbn limit ?");
			statement.setString(1, "%" + keyword + "%");
			statement.setInt(2, limit);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				Book book = new Book();
				book.setCallnumber(set.getString("call_number"));
				book.setTitle(set.getString("title"));
				book.setAuthor(set.getString("author"));
				book.setStatus(set.getBoolean("status"));
				book.setRentprice(set.getDouble("rental_price"));
				Category c = new Category();
				c.setId(set.getInt("id"));
				c.setName(set.getString("category"));
				book.setC(c);
				book.setIsbn(set.getString("isbn"));
				book.setPhoto(set.getBytes("photo"));
				books.add(book);
			}
		} catch (Exception e) {
			books = null;
			System.err.println("Can't run search! " + e.getMessage());
		}
		return books;
	}

	public List<Book> searchAuthor(String keyword, int limit) {
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement statement = ConnectDB.getConnection()
					.prepareStatement("select * from tb_book_detail where author like ? order by author limit ?");
			statement.setString(1, "%" + keyword + "%");
			statement.setInt(2, limit);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setCallnumber(resultSet.getString("call_number"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setStatus(resultSet.getBoolean("status"));
				book.setRentprice(resultSet.getDouble("rental_price"));
				Category c = new Category();
				c.setId(resultSet.getInt("id"));
				c.setName(resultSet.getString("category"));
				book.setC(c);
				book.setIsbn(resultSet.getString("isbn"));
				book.setPhoto(resultSet.getBytes("photo"));
				books.add(book);

			}
		} catch (Exception e) {
			books = null;
			System.err.println("Can't run search! " + e.getMessage());
		}
		return books;
	}

	public List<Book> searchTitle(String keyword, int limit) {
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement statement = ConnectDB.getConnection()
					.prepareStatement("select * from tb_book_detail where title like ? order by title limit ?");
			statement.setString(1, "%" + keyword + "%");
			statement.setInt(2, limit);

			ResultSet set = statement.executeQuery();
			while (set.next()) {
				Book book = new Book();
				book.setCallnumber(set.getString("call_number"));
				book.setTitle(set.getString("title"));
				book.setAuthor(set.getString("author"));
				book.setStatus(set.getBoolean("status"));
				book.setRentprice(set.getDouble("rental_price"));
				Category c = new Category();
				c.setId(set.getInt("id"));
				c.setName(set.getString("category"));
				book.setC(c);
				book.setIsbn(set.getString("isbn"));
				book.setPhoto(set.getBytes("photo"));
				books.add(book);

			}
		} catch (Exception e) {
			books = null;
			System.err.println("Can't run search! " + e.getMessage());
		}
		return books;
	}

	public Book find(String id) {
		Book book = null;
		try {
			PreparedStatement statement = ConnectDB.getConnection()
					.prepareStatement("select * from tb_book_detail d ,tb_book_cat c where c.id=d.id_cat and call_number = ?");
			statement.setString(1, id);
			ResultSet set = statement.executeQuery();
			if (set.next()) {
				book = new Book();
				book.setCallnumber(set.getString("call_number"));
				book.setTitle(set.getString("title"));
				book.setAuthor(set.getString("author"));
				book.setStatus(set.getBoolean("status"));
				book.setRentprice(set.getDouble("rental_price"));
				Category c = new Category();
				c.setId(set.getInt("id"));
				c.setName(set.getString("category"));
				book.setC(c);
				book.setIsbn(set.getString("isbn"));
				book.setPhoto(set.getBytes("photo"));
			}
		} catch (Exception e) {
			book = null;
			System.err.println("Can't find Call number! " + e.getMessage());
		}
		return book;
	}
	
	public boolean update(Book book, ReturnStatus re) {
		try {
			PreparedStatement statement = ConnectDB.getConnection().prepareStatement(
					"update tb_book_detail d, tb_return_book r set d.status = ? where d.isbn = r.isbn_return and r.isbn_return = ?");
			statement.setBoolean(1, book.isStatus());
			statement.setString(2, re.getIsbn_book());
			return statement.executeUpdate() > 0;
		} catch (Exception e) {
			System.err.println("Cannot Update book: " + e.getMessage());
			return false;
		}
	}
}
