package com.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.User;

/**
 * Servlet implementation class Serve2
 */
@WebServlet("/Serve2")
public class Serve2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDao em;
	int cpt=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Serve2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		em=new UserDao();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String log=request.getParameter("log");
		String pass=request.getParameter("pass");
		User u = em.authentification(log, pass);
		if(u!=null)
		{
			HttpSession ses = request.getSession(true);
			ses.setAttribute("user", u);
			response.sendRedirect("Produit");
		}else
		{
			cpt++;
			request.setAttribute("msg", "Login ou password incorrect");
			request.setAttribute("cpt", cpt);
			RequestDispatcher dispatcher = request.getRequestDispatcher("indx.jsp");
			dispatcher.forward(request, response);
	//		response.sendRedirect("indx.jsp");
			
		}
	}

}
