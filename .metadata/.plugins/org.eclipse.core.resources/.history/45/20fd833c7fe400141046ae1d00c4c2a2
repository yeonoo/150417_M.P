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
	
	public User get(final String id) throws SQLException {
		return jdbcContext.jdbcContextWithStatementStrategyForQuery(new StatementStrategy() {
			@Override
			public PreparedStatement makeStatement(Connection connection)
					throws SQLException {
				PreparedStatement preparedStatement;
				preparedStatement = connection.prepareStatement("select * from userinfo where id = ?");
				preparedStatement.setString(1, id);
				return preparedStatement;
			}
		});
	}

	public void add(final User user) throws SQLException {
		jdbcContext.jdbcContextWithStatementStrategyForUpdate(new StatementStrategy() {			
			@Override
			public PreparedStatement makeStatement(Connection connection)
					throws SQLException {
				PreparedStatement preparedStatement;
				preparedStatement = connection.prepareStatement("insert into userinfo(id, name, password) values(?, ?, ?)");
				preparedStatement.setString(1, user.getId());
				preparedStatement.setString(2, user.getName());
				preparedStatement.setString(3, user.getPassword());
				return preparedStatement;
			}
		});
	}

	public void delete(final String id) throws SQLException {
		jdbcContext.jdbcContextWithStatementStrategyForUpdate(new StatementStrategy() {			
			@Override
			public PreparedStatement makeStatement(Connection connection)
					throws SQLException {
				PreparedStatement preparedStatement;
				preparedStatement = connection.prepareStatement("delete from userinfo where id = ?");
				preparedStatement.setString(1, id);
				return preparedStatement; 
			}
		});
	}

	public void setJdbcContext(JdbcContext jdbcContext) {
		this.jdbcContext = jdbcContext;
	}
}