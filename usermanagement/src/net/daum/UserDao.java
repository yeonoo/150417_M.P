package net.daum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	public User get(String id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://117.17.102.143/Spring?characterEncoding=utf-8", "root", "Starter");
		
		PreparedStatement preparedStatement = connection.prepareStatement(
				"select * from userinfo where id = ?");
		preparedStatement.setString(1, id);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		
		User user = new User();
		user.setId(resultSet.getString("id"));
		user.setName(resultSet.getString("name"));
		user.setPassword(resultSet.getString("password"));
		
		resultSet.close();
		preparedStatement.close();
		connection.close();
		
		return user;
	}

	public void add(User user) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://117.17.102.143/Spring?characterEncoding=utf-8", "root", "Starter");
		
		PreparedStatement preparedStatement = connection.prepareStatement(
				"insert into userinfo(id, name, password) values(?, ?, ?)");
		preparedStatement.setString(1, user.getId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setString(3, user.getPassword ());
		
		preparedStatement.executeUpdate();
		
		preparedStatement.close();
		connection.close();
	}
}