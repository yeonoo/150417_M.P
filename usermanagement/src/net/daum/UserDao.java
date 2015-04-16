package net.daum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	public User get(String id) throws ClassNotFoundException, SQLException {
		// ����ڴ� ��� ����Ǿ� �ִ� �ɱ�?
		// DB�� ����ؾ���
		// � DB?
		// Mysql�� �������!
		
		// �������� ������ ������ ����!
		
		// Connection�� �ΰ�
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://117.17.102.143/Spring?characterEncoding=utf-8", "root", "Starter");
		
		// ������ �����
		PreparedStatement preparedStatement = connection.prepareStatement(
				"select * from userinfo where id = ?");
		preparedStatement.setString(1, id);
		
		// �����Ű��
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		
		// ����� User�� �� �����ϰ�
		User user = new User();
		user.setId(resultSet.getString("id"));
		user.setName(resultSet.getString("name"));
		user.setPassword(resultSet.getString("password"));
		
		// �ڿ��� �����ϱ�
		resultSet.close();
		preparedStatement.close();
		connection.close();
		
		return user;
	}
}