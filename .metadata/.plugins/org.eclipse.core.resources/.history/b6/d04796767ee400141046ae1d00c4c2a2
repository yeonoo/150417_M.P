package net.daum;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.jdbc.Statement;

public class UserDao {
	private JdbcContext jdbcContext;
	public UserDao() {
		
	}
	
	public User get(String id) throws SQLException {
		StatementStrategy statementStrategy = new GetUserStatementStrategy(id);
		return jdbcContext.jdbcContextWithStatementStrategyForQuery(statementStrategy);
	}


	public void add(User user) throws SQLException {
		StatementStrategy statementStrategy = new AddUserStatementStrategy(user);
		jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
	}

	public void delete(String id) throws SQLException {
		StatementStrategy statementStrategy = new DeleteUserStatementStrategy(id);
		jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
	}

	public void setJdbcContext(JdbcContext jdbcContext) {
		this.jdbcContext = jdbcContext;
	}
}