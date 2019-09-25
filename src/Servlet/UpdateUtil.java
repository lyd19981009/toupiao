package Servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DatalianjieUtil;
import prjo.Fabu;

public class UpdateUtil {

	public static void UpdateCount(String zhuti,int shu) {
		Connection conn=DatalianjieUtil.getConnection();
		String sql="update jieguo_diaocha set diaochaNumber=? where zhuti=?";
		try {
			PreparedStatement st=conn.prepareStatement(sql);
			st.setInt(1, shu);
			st.setString(2, zhuti);
			st.executeUpdate();
			conn.close();
			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void UpdateCount(String zhuti,String neirong,String yi,int shu) {
		Connection conn=DatalianjieUtil.getConnection();
		String sql=null;
		if(yi.equals("manyiHao")) {
			sql="update jieguo_diaocha set manyiHao=?  where zhuti=? and neirong=? ";
			}
		if(yi.equals("manyiBijiao")) {
			sql="update jieguo_diaocha set manyiBijiao=?  where zhuti=? and neirong=? ";
		}
		if(yi.equals("manyiJiben")) {
			sql="update jieguo_diaocha set manyiJiben=?  where zhuti=? and neirong=? ";
		}
		if(yi.equals("manyiBu")) {
			sql="update jieguo_diaocha set manyiBu=?  where zhuti=? and neirong=? ";
		}
		if(yi.equals("manyiHenbu")) {
			sql="update jieguo_diaocha set manyiHenbu=?  where zhuti=? and neirong=? ";
		}
		try {
			PreparedStatement st=conn.prepareStatement(sql);
			st.setInt(1, shu);
			st.setString(2, zhuti);
			st.setString(3, neirong);
			st.executeUpdate();
			conn.close();
			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
