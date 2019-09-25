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
import util.SouUtil;

/**
 * Servlet implementation class JieguoServlet1
 */
@WebServlet("/JieguoServlet1")
public class JieguoServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JieguoServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Fabu> alist=new ArrayList<Fabu>();
		request.setCharacterEncoding("utf-8");
		String zhuti=request.getParameter("zhuti");
		List<Fabu> list =SouUtil.getAllneirong(zhuti);
		List<Fabu> list1=SouUtil.getManyiType();
		double a=SouUtil.getZongtou(zhuti);
		for(int i=0;i<list.size();i++) {
			Fabu fa=new Fabu();
			fa.setNeirong(list.get(i).getNeirong());
			for(int j=0;j<list1.size();j++) {
				System.out.println(list1.get(1).getType());
				if(list1.get(j).getType().equals("manyiHao"))
				fa.setManyiHao(SouUtil.getManyidu(zhuti, list.get(i).getNeirong(), list1.get(0).getType())/a*100);
				if(list1.get(j).getType().equals("manyiBijiao"))
					fa.setManyiBijiao(SouUtil.getManyidu(zhuti, list.get(i).getNeirong(), list1.get(1).getType())/a*100);
				if(list1.get(j).getType().equals("manyiJiben"))
					fa.setManyiJiben(SouUtil.getManyidu(zhuti, list.get(i).getNeirong(), list1.get(2).getType())/a*100);
				if(list1.get(j).getType().equals("manyiBu"))
					fa.setManyiBu(SouUtil.getManyidu(zhuti, list.get(i).getNeirong(), list1.get(3).getType())/a*100);
				if(list1.get(j).getType().equals("manyiHenbu"))
					fa.setManyiHenbu(SouUtil.getManyidu(zhuti, list.get(i).getNeirong(), list1.get(4).getType())/a*100);
				
			}
			alist.add(fa);
			
		}
		request.setAttribute("alist", alist);
		request.setAttribute("a", a);
		request.setAttribute("zhuti", zhuti);
		request.getRequestDispatcher("/Jieguo1.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
