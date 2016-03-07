package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Metier.data;
import dao.DaoFactory;
import dao.datadao;

/**
 * Servlet implementation class content
 */
public class content extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private datadao dataDao;
       
@Override
public void init() throws ServletException {
	// TODO Auto-generated method stub
	DaoFactory daofactory=DaoFactory.getInsatnce();
	this.dataDao=new datadao(daofactory);
}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List nb= dataDao.lister();
		
		request.setAttribute("datas", nb);
		this.getServletContext().getRequestDispatcher("/WEB-INF/content.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
