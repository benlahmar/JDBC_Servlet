package com.web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProduitDao;

/**
 * Servlet implementation class serve1
 */
@WebServlet("/serve1")
public class serve1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ProduitDao pm;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serve1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		pm=new ProduitDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id= Integer.parseInt(request.getParameter("id"));
		pm.deleteproduit(id);
		response.sendRedirect("Produit");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String desg=request.getParameter("desg");
		String desc=request.getParameter("desc");
		int qte= Integer.parseInt(request.getParameter("qte"));
		double prix =Double.parseDouble(request.getParameter("prix"));
		
		pm.addProduit(desg, prix, qte, desc);
		response.sendRedirect("Produit");
	}

}
