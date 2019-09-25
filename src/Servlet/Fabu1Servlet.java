package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prjo.Fabu;
import util.IntoUtil;
import util.PandaunUtil;
import util.SouUtil;

/**
 * Servlet implementation class Fabu1Servlet
 */
@WebServlet("/Fabu1Servlet")
public class Fabu1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fabu1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String neirong=request.getParameter("neirong");
		String zhuti=SouUtil.getNewtZhuti();
		List list=new ArrayList<>();
		list.add(neirong);
		int b=PandaunUtil.KongPanduan(list);
		if(b==20) {
			IntoUtil.IsertDiaocha(zhuti, neirong);
			request.setAttribute("zhuti", zhuti);
			request.setAttribute("neirong", neirong);
			request.getRequestDispatcher("/Fabu1.jsp").forward(request, response);
			
		}else {b=-8;
			request.setAttribute("b", b);
			request.getRequestDispatcher("/ap.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String neirong=request.getParameter("neirong");
		String zhuti=SouUtil.getNewtZhuti();
		IntoUtil.IsertDiaocha(zhuti, neirong);
		List <Fabu>list=SouUtil.getAllneirong(zhuti);
		request.setAttribute("list", list);
		request.setAttribute("zhuti", zhuti);
		request.getRequestDispatcher("/Fabu2.jsp").forward(request, response);
		
	}

}
