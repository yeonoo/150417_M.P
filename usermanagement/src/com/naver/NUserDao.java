package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.daum.UserDao;

public class NUserDao extends UserDao {
	@Override
	public Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://117.17.102.143/Spring?characterEncoding=utf-8", "root", "Starter");
		return connection;
	}
}