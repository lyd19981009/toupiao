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
		int b=PandaunUtil.KongPanduan(list);//b=-1�п�ֵ��b=20��˵��û�п�ֵ
			if(b==20) {
				int b1=PandaunUtil.ShoujigeshiPanduan(phone);//b1=-3���ʽ���ԣ�b=22���ʽ��ȷ
				b=b1;
				if(b==22) {
					int b2=PandaunUtil.ShoujiExist(phone);//b2=-4˵������δ���ڣ�b2=23˵��������ע��
					b=b2;
					 if(b==-4) {//ע��ɹ�,�����ݲ������ݿ�zhuce
						 System.out.println(11111);
						 IntoUtil.Insertzcb(phone, message, password);
					 }
				}
			}
		request.setAttribute("b", b);
		request.getRequestDispatcher("/ap.jsp").forward(request, response);
	}

}
