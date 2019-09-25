package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DatalianjieUtil;

public class IntoUtil {

	public static void Insertzcb(String phone,String message,String password) {//��Ϣ����ע������
		Connection conn=DatalianjieUtil.getConnection();
		String sql="insert into zhuce(message,password,phone) values(?,?,?)";
		try {
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, message);
			st.setString(2, password);
			st.setString(3, phone);
			st.executeUpdate();
			System.out.println(message+password+phone);
			conn.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public static void InsertLogji(String message) {//��Ϣ�����¼�����
		Connection conn=DatalianjieUtil.getConnection();
		String sql="insert into loginame(message) values(?) ";
		try {
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, message);
			st.executeUpdate();
			System.out.println(message);
			conn.close();
			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void InsertXin_fa(String zhuti,String name) {//��Ϣ���뷢����Ϣ�����
		Connection conn=DatalianjieUtil.getConnection();
		String sql="insert into xinxi_fabu(zhuti,fabuzhe) values(?,?)";
		try {
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, zhuti);
			st.setString(2, name);
			st.executeUpdate();
			conn.close();
			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void IsertDiaocha(String zhuti,String neirong) {
		Connection conn=DatalianjieUtil.getConnection();
		String sql="insert into jieguo_diaocha(zhuti,neirong) values(?,?)";
		try {
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, zhuti);
			st.setString(2, neirong);
			st.executeUpdate();
			conn.close();
			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
