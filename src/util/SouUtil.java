package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import db.DatalianjieUtil;
import prjo.Fabu;

public class SouUtil {

	public static String getMage(String phone) {
		String message=null;
		Connection conn=DatalianjieUtil.getConnection();
		String sql="select message from zhuce where phone=?";
		try {
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, phone);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				message=rs.getString("message");
				
			}
			//System.out.println(message);
			conn.close();
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return message;
	}
	public static String getNewest() {
		String message=null;
		Connection conn=DatalianjieUtil.getConnection();
		String sql="select message from loginame order by id desc";
		try {
			PreparedStatement st=conn.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				message=rs.getString("message");
				break;
			}
			conn.close();
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return message;
	}
	
	public static String getNewtZhuti() {
		String zhuti=null;
		Connection conn=DatalianjieUtil.getConnection();
		String sql="select zhuti from xinxi_fabu order by id desc";
		try {
			PreparedStatement st=conn.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				zhuti=rs.getString("zhuti");
				break;
			}
			conn.close();
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return zhuti;
	}
	public static List<Fabu> getAllneirong(String zhuti) {
		List<Fabu> list=new ArrayList<Fabu>();
		Connection conn=DatalianjieUtil.getConnection();
		String sql="select neirong from jieguo_diaocha where zhuti=?";
		try {
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, zhuti);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				Fabu fa=new Fabu();
				fa.setNeirong(rs.getString("neirong"));
				list.add(fa);
				
			}
			conn.close();
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public static List<Fabu> getAllzhuti() {
		List <Fabu>list=new ArrayList<Fabu>();
		Connection conn=DatalianjieUtil.getConnection();
		String sql="select zhuti from xinxi_fabu order by id desc";
		try {
			PreparedStatement st=conn.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				Fabu fa=new Fabu();
				fa.setZhuti(rs.getString("zhuti"));
				list.add(fa);
				
			}
			conn.close();
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static int  get1count(String yi,String neirong ,String zhuti) {
		int i=0;
		String sql=null;
		Connection conn=DatalianjieUtil.getConnection();
		if(yi.equals("manyiHao")) {
			sql="select manyiHao from jieguo_diaocha where neirong=? and zhuti=? ";
			}
		if(yi.equals("manyiBijiao")) {
			sql="select manyiBijiao from jieguo_diaocha where neirong=? and zhuti=? ";
			}
		if(yi.equals("manyiJiben")) {
			sql="select manyiJiben from jieguo_diaocha where neirong=? and zhuti=? ";
			}
		if(yi.equals("manyiBu")) {
			sql="select manyiBu from jieguo_diaocha where neirong=? and zhuti=? ";
			}
		if(yi.equals("manyiHenbu")) {
			sql="select manyiHenbu from jieguo_diaocha where neirong=? and zhuti=? ";
			}
		
		try {
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, neirong);
			st.setString(2, zhuti);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				i=rs.getInt(yi.toString());
				
			}
			conn.close();
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static int  getallcount(String zhuti) {
		int i=0;
		Connection conn=DatalianjieUtil.getConnection();
		String sql="select diaochaNumber from jieguo_diaocha where zhuti=?";
		try {
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, zhuti);
			
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				i=rs.getInt("diaochaNumber");
				
			}
			conn.close();
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static double getManyidu(String zhuti,String neirong,String type) {
		double b=-1111;
		Connection conn=DatalianjieUtil.getConnection();
		String sql="select manyiHao from jieguo_diaocha where neirong=? and zhuti=?";
		String sql1="select manyiBijiao from jieguo_diaocha where neirong=? and zhuti=?";
		String sql2="select manyiJiben from jieguo_diaocha where neirong=? and zhuti=?";
		String sql3="select manyiBu from jieguo_diaocha where neirong=? and zhuti=?";
		String sql4="select manyiHenbu from jieguo_diaocha where neirong=? and zhuti=?";
		PreparedStatement st=null;
		try {if(type.equals("manyiHao")) {
			st=conn.prepareStatement(sql);
			}
		if(type.equals("manyiBijiao")) {
			st=conn.prepareStatement(sql1);
			}
		if(type.equals("manyiJiben")) {
			st=conn.prepareStatement(sql2);
			}
		if(type.equals("manyiBu")) {
			st=conn.prepareStatement(sql3);
			}
		if(type.equals("manyiHenbu")) {
			st=conn.prepareStatement(sql4);
			}
			st.setString(1, neirong);
			st.setString(2, zhuti);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				if(type.equals("manyiHao"))
				b=rs.getDouble("manyiHao");
				if(type.equals("manyiBijiao"))
					b=rs.getDouble("manyiBijiao");
				if(type.equals("manyiJiben"))
					b=rs.getDouble("manyiJiben");
				if(type.equals("manyiBu"))
					b=rs.getDouble("manyiBu");
				if(type.equals("manyiHenbu"))
					b=rs.getDouble("manyiHenbu");
			}
			conn.close();
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}
	public static double getZongtou(String zhuti) {
		double b=0;
		Connection conn=DatalianjieUtil.getConnection();
		String  sql="select diaochaNumber from jieguo_diaocha where zhuti=?";
		try {
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, zhuti);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				b=rs.getInt("diaochaNumber");
				break;
			}
			conn.close();
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}
	public static List<Fabu> getManyiType() {
		List<Fabu> list=new ArrayList<Fabu>();
		String a="manyiHao";
		String b="manyiBijiao";
		String c="manyiJiben";
		String d="manyiBu";
		String e="manyiHenbu";
		Fabu fa1=new Fabu();
		fa1.setType(a);
		Fabu fa2=new Fabu();
		fa2.setType(b);
		Fabu fa3=new Fabu();
		fa3.setType(c);
		Fabu fa4=new Fabu();
		fa4.setType(d);
		Fabu fa5=new Fabu();
		fa5.setType(e);
		list.add(fa1);
		list.add(fa2);
		list.add(fa3);
		list.add(fa4);
		list.add(fa5);
		System.out.println(list.get(1).getType());
		System.out.println(list.size());
		return list;
	}
}
