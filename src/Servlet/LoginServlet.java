package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.IntoUtil;
import util.PandaunUtil;
import util.SouUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List list=new ArrayList();	
		String phone=request.getParameter("phone");			
		String password=request.getParameter("password");
		list.add(phone);
		list.add(password);
		int b=PandaunUtil.KongPanduan(list);//bΪ-1��˵���п�ֵ��b=20��˵��û�п�ֵ
			if(b==20) {
				int b1=PandaunUtil.ShenfenYZ(phone, password);//b1=-5˵��ʧ��,b=24˵��ƥ��ɹ�
				b=b1;
					if(b==24) {
						System.out.println(phone);
						String message=SouUtil.getMage(phone);
						System.out.println(message);
						IntoUtil.InsertLogji(message);
					}
			}
			else b=-6;//���ص�¼������趨ֵ
			request.setAttribute("b",b);
			request.getRequestDispatcher("/ap.jsp").forward(request, response);
		
				
	}

}
