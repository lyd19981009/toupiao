package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import db.DatalianjieUtil;

public class PandaunUtil {

	public  static int KongPanduan(List list) {//��ֵ�жϣ�ͨ��
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
		
		return b;//bΪ-1��˵���п�ֵ��b=20��˵��û�п�ֵ
	}
	
	public static int ShoujigeshiPanduan(String phone) {//�ֻ���ʽ�жϣ�ͨ��
		int b=-3;
		int k=0;
		if(phone.length()==11) {
		for(int i=0;i<phone.length();i++) {
			for(int j=0;j<=9;j++) {
				String j1=j+"";
				if(phone.substring(i, i+1).equals(j1)) {
					k++;//һ��������ȷ
					
				}
			}
		}//ѭ�������k�ĳ���Ϊ���ָ���
		if(k==11) {
			b=22;//˵���绰�����ʽ��ȷ
		}
	}
		return b;//b=-3���ʽ���ԣ�b=22���ʽ��ȷ
		
		
	}
	
public static int ShoujiExist(String phone) {//ע���ж�ר��
		
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
			b=23;//˵�������Ѿ�ע����
		}
		return b;//b=-4˵������δ���ڣ�b=23˵��������ע��
		
	}
public static int ShenfenYZ(String phone,String password) {//�����֤
	int b=-5;
	Connection conn=DatalianjieUtil.getConnection();
	String sql="select phone,password from zhuce ";
	try {
		PreparedStatement st=conn.prepareStatement(sql);
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			if(phone.equals(rs.getString("phone"))&&password.equals(rs.getString("password"))) {
				b=24;//b=24˵��ƥ��ɹ�
			}
		}
		conn.close();
		st.close();
		rs.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	return b;//b=-5˵��ʧ��,b=24˵��ƥ��ɹ�
	
}


}