package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.webservice.CalculatorStub;
import com.app.webservice.CalculatorStub.Cal_A;
import com.app.webservice.CalculatorStub.Cal_AResponse;

import Metier.data;
import dao.DaoFactory;
import dao.datadao;

/**
 * Servlet implementation class annuite
 */
public class annuite extends HttpServlet {
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
		this.getServletContext().getRequestDispatcher("/WEB-INF/annuite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double duree=Double.parseDouble(request.getParameter("duree"));
		double taux=Double.parseDouble(request.getParameter("taux"));
		double capitale=Double.parseDouble(request.getParameter("capitale"));
		double annuite=0;
		if(request.getRequestURI().equalsIgnoreCase("/CalculatorClient/annuite"))
		{
			CalculatorStub stub=new CalculatorStub();
			Cal_A cal_a=new Cal_A();
			cal_a.setCap(capitale);
			cal_a.setDuree(duree);
			cal_a.setTaux(taux);
			Cal_AResponse res=stub.cal_A(cal_a);
			annuite=res.get_return();
			request.setAttribute("duree", duree);
			request.setAttribute("capitale", capitale);
			request.setAttribute("taux", taux);
			request.setAttribute("annuite", annuite);
			this.getServletContext().getRequestDispatcher("/WEB-INF/annuite.jsp").forward(request, response);
		}
		if(request.getRequestURI().equalsIgnoreCase("/CalculatorClient/annuite/add"))
		{
			annuite=Double.parseDouble(request.getParameter("annuite"));
			dataDao.ajouter(new data(0, duree, taux, capitale, annuite));
			response.sendRedirect("../content");
		}
		
		

		
		
	}

}
