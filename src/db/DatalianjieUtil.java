package db;
/**
 * 累的作用是提供一个静态方法，获取数据库连接
 * @author 13303
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatalianjieUtil {

	/**
	 * 静态方法GetConnection
	 * 连接本机数据库
	 * 如果正常连接，返回连接对象
	 * 如果出现异常，返回null
	 * @return
	 */
	public static Connection getConnection() {
		//查找驱动程序是否可以使用
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/toupiao", "root", "ab133ab");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
