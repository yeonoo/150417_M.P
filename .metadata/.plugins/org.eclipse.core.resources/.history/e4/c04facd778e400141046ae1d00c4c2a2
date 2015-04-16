package net.daum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class UserDao {
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public UserDao() {
		
	}
	
	public User get(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user;
		try {
			connection = dataSource.getConnection();
			
			preparedStatement = connection.prepareStatement(
					"select * from userinfo where id = ?");
			preparedStatement.setString(1, id);
			
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			user = new User();
			user.setId(resultSet.getString("id"));
			user.setName(resultSet.getString("name"));
			user.setPassword(resultSet.getString("password"));
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			if (preparedStatement != null)
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			if (connection != null)
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}		
		return user;
	}

	public void add(User user) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			
			preparedStatement = connection.prepareStatement(
					"insert into userinfo(id, name, password) values(?, ?, ?)");
			preparedStatement.setString(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getPassword ());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (preparedStatement != null)
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			if (connection != null)
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
}