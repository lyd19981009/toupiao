package db;
/**
 * �۵��������ṩһ����̬��������ȡ���ݿ�����
 * @author 13303
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatalianjieUtil {

	/**
	 * ��̬����GetConnection
	 * ���ӱ������ݿ�
	 * ����������ӣ��������Ӷ���
	 * ��������쳣������null
	 * @return
	 */
	public static Connection getConnection() {
		//�������������Ƿ����ʹ��
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
