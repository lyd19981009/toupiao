package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import db.DatalianjieUtil;

public class PandaunUtil {

	public  static int KongPanduan(List list) {//空值判断，通用
		int b=-1;
		boolean a=true;
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).toString().equals("")) {
				a=false;
				
			}
			
		}
		if(a) {
			b=20;
		}
		
		return b;//b为-1则说明有空值，b=20则说明没有空值
	}
	
	public static int ShoujigeshiPanduan(String phone) {//手机格式判断，通用
		int b=-3;
		int k=0;
		if(phone.length()==11) {
		for(int i=0;i<phone.length();i++) {
			for(int j=0;j<=9;j++) {
				String j1=j+"";
				if(phone.substring(i, i+1).equals(j1)) {
					k++;//一个数字正确
					
				}
			}
		}//循环完成则k的长度为数字个数
		if(k==11) {
			b=22;//说明电话号码格式正确
		}
	}
		return b;//b=-3则格式不对，b=22则格式正确
		
		
	}
	
public static int ShoujiExist(String phone) {//注册判断专用
		
		int b=-4;
		boolean a=false;
		Connection conn=DatalianjieUtil.getConnection();
		String sql1="select phone from zhuce";
			try {
				PreparedStatement st=conn.prepareStatement(sql1);
				ResultSet rs=st.executeQuery();
				while(rs.next()) {
					if(phone.equals(rs.getString("phone"))) {
						a=true;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		if(a) {
			b=23;//说明号码已经注册了
		}
		return b;//b=-4说明号码未存在，b=23说明号码已注册
		
	}
public static int ShenfenYZ(String phone,String password) {//身份验证
	int b=-5;
	Connection conn=DatalianjieUtil.getConnection();
	String sql="select phone,password from zhuce ";
	try {
		PreparedStatement st=conn.prepareStatement(sql);
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			if(phone.equals(rs.getString("phone"))&&password.equals(rs.getString("password"))) {
				b=24;//b=24说明匹配成功
			}
		}
		conn.close();
		st.close();
		rs.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	return b;//b=-5说明失败,b=24说明匹配成功
	
}


}