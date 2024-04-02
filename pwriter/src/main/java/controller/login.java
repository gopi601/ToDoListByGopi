package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.javabeanuser;
@WebServlet("/logined")
public class login extends HttpServlet
{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	Dao dao=new Dao();
	try {
		javabeanuser user=dao.findByEmail(email);
		if(user!=null)
		{
			if(user.getUserpassword().equals(password))
			{
//				resp.getWriter().print("hello");
				req.getSession().setAttribute("userr", user);
				resp.sendRedirect("homee.jsp");
			}
			else
			{
				req.getRequestDispatcher("logined.jsp").include(req, resp);
			}
		}
		else
		{
			req.getRequestDispatcher("logined.jsp").include(req, resp);
		}
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	

}
}
