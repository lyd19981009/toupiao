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
 * Servlet implementation class FabuServlet
 */
@WebServlet("/FabuServlet")
public class FabuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FabuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
			request.setCharacterEncoding("utf-8");
			List list=new ArrayList<>();
			String zhuti=SouUtil.getNewtZhuti();
			request.setAttribute("zhuti", zhuti);
			request.getRequestDispatcher("/Fabu.jsp").forward(request, response);
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("utf-8");
		List list=new ArrayList<>();
		String zhuti=request.getParameter("zhuti");
		list.add(zhuti);
		int b=PandaunUtil.KongPanduan(list);//b为-1则说明有空值，b=20则说明没有空值
		if(b==20) {
		String name=SouUtil.getNewest();
		IntoUtil.InsertXin_fa(zhuti, name);
		request.setAttribute("zhuti", zhuti);
		request.getRequestDispatcher("/Fabu.jsp").forward(request, response);
		}else {
			b=-7;
			request.setAttribute("b", b);
			request.getRequestDispatcher("/ap.jsp").forward(request, response);
		
	}
	}
}
