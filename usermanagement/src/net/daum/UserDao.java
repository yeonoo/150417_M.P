package net.daum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	public User get(String id) throws ClassNotFoundException, SQLException {
		// 사용자는 어디에 저장되어 있는 걸까?
		// DB를 사용해야지
		// 어떤 DB?
		// Mysql을 사용하자!
		
		// 개략적인 순서는 다음과 같이!
		
		// Connection을 맺고
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://117.17.102.143/Spring?characterEncoding=utf-8", "root", "Starter");
		
		// 쿼리를 만들고
		PreparedStatement preparedStatement = connection.prepareStatement(
				"select * from userinfo where id = ?");
		preparedStatement.setString(1, id);
		
		// 실행시키고
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		
		// 결과를 User에 잘 매핑하고
		User user = new User();
		user.setId(resultSet.getString("id"));
		user.setName(resultSet.getString("name"));
		user.setPassword(resultSet.getString("password"));
		
		// 자원을 해지하기
		resultSet.close();
		preparedStatement.close();
		connection.close();
		
		return user;
	}
}