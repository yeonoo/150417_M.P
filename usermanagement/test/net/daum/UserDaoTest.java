package net.daum;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class UserDaoTest {
	@Test
	public void get() throws ClassNotFoundException, SQLException {
		UserDao userDao = new UserDao();
		String id = "1046339528";
		User user = userDao.get(id);
		assertEquals("1046339528", user.getId());
		assertEquals("����ȣ", user.getName());
		assertEquals("111", user.getPassword());
	}
}