package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.webservice.CalculatorStub;
import com.app.webservice.CalculatorStub.Cal_A;
import com.app.webservice.CalculatorStub.Cal_AResponse;
import com.app.webservice.CalculatorStub.Cal_D;
import com.app.webservice.CalculatorStub.Cal_DResponse;

import Metier.data;
import dao.DaoFactory;
import dao.datadao;

/**
 * Servlet implementation class duree
 */
public class duree extends HttpServlet {
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
		this.getServletContext().getRequestDispatcher("/WEB-INF/duree.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double annuite=Double.parseDouble(request.getParameter("annuite"));
		double taux=Double.parseDouble(request.getParameter("taux"));
		double capitale=Double.parseDouble(request.getParameter("capitale"));
		double duree=120;
		if(request.getRequestURI().equalsIgnoreCase("/CalculatorClient/duree"))
		{
			CalculatorStub stub=new CalculatorStub();
			Cal_D cal_d=new Cal_D();
			cal_d.setAnn(annuite);
			cal_d.setCap(capitale);
			cal_d.setTaux(taux);
			Cal_DResponse res=stub.cal_D(cal_d);
			duree=res.get_return();
			request.setAttribute("duree", duree);
			request.setAttribute("capitale", capitale);
			request.setAttribute("taux", taux);
			request.setAttribute("annuite", annuite);
			this.getServletContext().getRequestDispatcher("/WEB-INF/duree.jsp").forward(request, response);
		}
		if(request.getRequestURI().equalsIgnoreCase("/CalculatorClient/duree/add"))
		{
			duree=Double.parseDouble(request.getParameter("duree"));
			dataDao.ajouter(new data(0, duree, taux, capitale, annuite));
			response.sendRedirect("../content");
		}
		
		

		
		
	}

}
