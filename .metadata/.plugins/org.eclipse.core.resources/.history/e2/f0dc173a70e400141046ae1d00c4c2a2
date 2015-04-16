package net.daum;

public class DaoFactory {
	public UserDao getUserDao() {
		return new UserDao(getConnectionMaker());
	}

	private DConnectionMaker getConnectionMaker() {
		return new DConnectionMaker();
	}
}