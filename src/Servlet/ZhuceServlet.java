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

/**
 * Servlet implementation class ZhuceServlet
 */
@WebServlet("/ZhuceServlet")
public class ZhuceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZhuceServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("charset=utf-8");
		List list=new ArrayList();
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		String message=request.getParameter("message");
		list.add(phone);
		list.add(message);
		list.add(password);
		int b=PandaunUtil.KongPanduan(list);//b=-1有空值，b=20则说明没有空值
			if(b==20) {
				int b1=PandaunUtil.ShoujigeshiPanduan(phone);//b1=-3则格式不对，b=22则格式正确
				b=b1;
				if(b==22) {
					int b2=PandaunUtil.ShoujiExist(phone);//b2=-4说明号码未存在，b2=23说明号码已注册
					b=b2;
					 if(b==-4) {//注册成功,将数据插入数据库zhuce
						 System.out.println(11111);
						 IntoUtil.Insertzcb(phone, message, password);
					 }
				}
			}
		request.setAttribute("b", b);
		request.getRequestDispatcher("/ap.jsp").forward(request, response);
	}

}
