package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Employee;

public class EmployeeModel {
	public boolean create(Employee e1) {
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("insert into tb_user_detail (id, name, address , phone, department) values (?,?,?,?,?)");
			preparedStatement.setInt(1, e1.getId());
			preparedStatement.setString(2, e1.getName());
			preparedStatement.setString(3, e1.getAddress());
			preparedStatement.setString(4, e1.getPhone());
			preparedStatement.setString(5, e1.getDepartment());
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<Employee> findAll() {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("select * from tb_user_detail");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setAddress(resultSet.getString("address"));
				employee.setDepartment(resultSet.getString("department"));
				employee.setPhone(resultSet.getString("phone"));
				employees.add(employee);
			}
		} catch (Exception e) {
			employees = null;
		}
		return employees;
	}

	public Employee find(int id) {
		Employee employee = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("select * from tb_user_detail where id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setPhone(resultSet.getString("phone"));
				employee.setDepartment(resultSet.getString("department"));
				employee.setAddress(resultSet.getString("address"));
			}
		} catch (Exception e) {
			employee = null;
			System.out.println("Can't find user id: " + e.getMessage());
		}
		return employee;
	}

	public boolean update(Employee employee, int id) {
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(
					"update tb_user_detail set id = ?, name = ?,  address = ?, phone = ?, department = ? where id = ?");
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setString(3, employee.getAddress());
			preparedStatement.setString(4, employee.getPhone());
			preparedStatement.setString(5, employee.getDepartment());
			preparedStatement.setInt(6, id);
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean delete(int id) {
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("delete from tb_user_detail where id = ?");
			preparedStatement.setInt(1, id);
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Employee> search(String keyword) {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("select * from tb_user_detail where name like ?");
			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setAddress(resultSet.getString("address"));
				employee.setPhone(resultSet.getString("phone"));
				employee.setDepartment(resultSet.getString("department"));
				
				employees.add(employee);
			}
		} catch (Exception e) {
			employees = null;
		}
		return employees;
	}

}
