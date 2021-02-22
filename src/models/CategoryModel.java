package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Category;

public class CategoryModel {

	public List<Category> readCate() {
		List<Category> cates = new ArrayList<Category>();
		try {
			PreparedStatement statement = ConnectDB.getConnection().prepareStatement("select * from tb_book_cat");
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				Category cate = new Category();
				cate.setId(set.getInt("id"));
				cate.setName(set.getString("category"));
				cates.add(cate);

			}
		} catch (Exception e) {
			cates = null;
			System.err.println("No Cate found! " + e.getMessage());
		}
		return cates;
	}
	public Category findCate(String id) {
		Category cates = null;
		try {
			PreparedStatement statement = ConnectDB.getConnection().prepareStatement("select * from tb_book_cat where id = ?");
			statement.setString(1, id);
			ResultSet set = statement.executeQuery();
			if (set.next()) {
				cates = new Category();
				cates.setId(set.getInt("id"));
				cates.setName(set.getString("category"));
				
			}
		} catch (Exception e) {
			cates = null;
			System.err.println("No Id Cate found! " + e.getMessage());
		}
		return cates;
	}
	
	public boolean insert(Category cate) {
		try {
			PreparedStatement statement = ConnectDB.getConnection().prepareStatement("insert into tb_book_cat(category) value (?)");
		statement.setString(1, cate.getName());
		return statement.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println("Cannot insert Category: " + e.getMessage());
			return false;
		}
	}
	public boolean update(Category cate) {
		try {
			PreparedStatement statement = ConnectDB.getConnection().prepareStatement("update tb_book_cat set category = ? where id = ?");
			statement.setString(1, cate.getName());
			statement.setInt(2, cate.getId());
			return statement.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println("Cannot update Category: " + e.getMessage());
			return false;
		}
	}
	public boolean drop(String cate) {
		try {
			PreparedStatement statement = ConnectDB.getConnection().prepareStatement("delete from tb_book_cat where id = ?");
			statement.setString(1, cate);
			return statement.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println("Cannot drop Category: " + e.getMessage());
			return false;
		}
	}

}
