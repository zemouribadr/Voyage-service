package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
	private String url;
	private String user;
	private String password;
	 
	
	 DaoFactory(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}
	public static DaoFactory getInsatnce()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DaoFactory instance=new DaoFactory("jdbc:mysql://localhost/voyage", "root", "");
		return instance;
	}
	public Connection getConnexion() throws SQLException
	{
		return DriverManager.getConnection(url, user, password);
	}
	public VoyageInterfaceDao getDataDao()
	{
		return new VoyageDao(this);
	}
	public VoyageDao getVoyageDao(){
		return new VoyageDao(this);
	}
}
