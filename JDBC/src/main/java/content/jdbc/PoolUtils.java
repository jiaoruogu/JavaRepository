package content.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class PoolUtils {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	private static BasicDataSource ds;
	private static int initialSize;
	private static int maxActive;
	static{
		ds=new BasicDataSource();
		Properties cfg=new Properties();
		try {
			InputStream in=PoolUtils.class.getClassLoader()
						.getResourceAsStream("db.properties");
			cfg.load(in);
			driver=cfg.getProperty("jdbc.driver");
			url=cfg.getProperty("jdbc.url");
			username=cfg.getProperty("jdbc.username");
			password=cfg.getProperty("jdbc.password");
			initialSize=Integer.parseInt(
					cfg.getProperty("jdbc.initialSize"));
			maxActive=Integer.parseInt(
					cfg.getProperty("jdbc.maxActive"));
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
			ds.setInitialSize(initialSize);
			ds.setMaxActive(maxActive);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		try{
			Connection conn=ds.getConnection();
			return conn;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
