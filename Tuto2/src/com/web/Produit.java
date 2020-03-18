package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProduitDao;

/**
 * Servlet implementation class Produit
 */
@WebServlet({ "/Produit", "/index2" })
public class Produit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProduitDao pm;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Produit() {
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
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		out.print("<h1>Product Management</h1>");
		
		out.print("<form action='serve1' method='post'> <table>");
		out.print("<tr><td>Designation:</td><td><input type='text' name='desg'/></td></tr>");
		out.print("<tr><td>Prix:</td><td><input type='text' name='prix'/></td></tr>");
		out.print("<tr><td>Quantité:</td><td><input type='number' name='qte'/></td></tr>");
		out.print("<tr><td>Description:</td><td><input type='text' name='desc'/></td></tr>");
		out.print("<tr><td><input type='submit' value='Ajouter' name='add'/><td/><td><input type='reset' value='Annuler' name='add'/></td></tr>");
		out.print("</table><form>");
		out.print("<hr/>");
		
		
		
		List<com.model.Produit> ps = pm.allproduit();
		out.print("<table width='80%' bgcolor='gold' biorder='2px'>");
		out.print("<thead><tr><th>ID</th><th>Designation</th><th>Prix</th><th>Quantite</th><th>Description</th></tr></thead>");
		out.print("<tbody>");
		for (com.model.Produit p : ps) {
			out.print("<tr>");
			out.print("<td>"+p.getId()+"</td>");
			out.print("<td>"+p.getDesignation()+"</td>");
			out.print("<td>"+p.getPrix()+"</td>");
			out.print("<td>"+p.getQuantite()+"</td>");
			out.print("<td>"+p.getDescrition()+"</td>");
			
			out.print("<td><a href='serve1?id="+p.getId()+"'>delete</a></td>");
			out.print("<td><a href=''>update</a></td>");
			out.print("</tr>");
		}
		out.print("</tbody>");
		out.print("</table");
	}

}
