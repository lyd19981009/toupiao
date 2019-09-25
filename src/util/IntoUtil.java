package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DatalianjieUtil;

public class IntoUtil {

	public static void Insertzcb(String phone,String message,String password) {//信息插入注册表操作
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
	public static void InsertLogji(String message) {//信息插入登录表操作
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
	public static void InsertXin_fa(String zhuti,String name) {//信息插入发布信息表操作
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
