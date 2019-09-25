package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prjo.Fabu;
import util.SouUtil;

/**
 * Servlet implementation class JiaoServlet
 */
@WebServlet("/JiaoServlet")
public class JiaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JiaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String yi=null;
		String zhuti=request.getParameter("zhuti");
		int shu=SouUtil.getallcount(zhuti);
		System.out.println(shu);
		shu++;
		System.out.println(shu);
		UpdateUtil.UpdateCount(zhuti,shu);
		List<Fabu> list=SouUtil.getAllneirong(zhuti);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getNeirong());
			int j=Integer.parseInt(request.getParameter(list.get(i).getNeirong()));
			if(j==1) {
				yi="manyiHao";
				int shu1=SouUtil.get1count(yi, list.get(i).getNeirong(), zhuti);
				shu1++;
				UpdateUtil.UpdateCount(zhuti, list.get(i).getNeirong(), yi, shu1);
				
			}
			if(j==2) {
				yi="manyiBijiao";
				int shu1=SouUtil.get1count(yi, list.get(i).getNeirong(), zhuti);
				shu1++;
						UpdateUtil.UpdateCount(zhuti, list.get(i).getNeirong(), yi, shu1);
			}
			if(j==3) {
				yi="manyiJiben";
				int shu1=SouUtil.get1count(yi, list.get(i).getNeirong(), zhuti);
				shu1++;
				UpdateUtil.UpdateCount(zhuti, list.get(i).getNeirong(), yi, shu1);
			}
			if(j==4) {
				yi="manyiBu";
				int shu1=SouUtil.get1count(yi, list.get(i).getNeirong(), zhuti);
				shu1++;
				UpdateUtil.UpdateCount(zhuti, list.get(i).getNeirong(), yi, shu1);
				
			}
			if(j==5) {
				yi="manyiHenbu";
				int shu1=SouUtil.get1count(yi, list.get(i).getNeirong(), zhuti);
				shu1++;
				UpdateUtil.UpdateCount(zhuti, list.get(i).getNeirong(), yi, shu1);
			}
		}
		request.getRequestDispatcher("/success1.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
