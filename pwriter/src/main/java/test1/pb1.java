package test1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/pw")
public class pb1 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	PrintWriter pw=res.getWriter();
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	if(name!=null && email!=null)
	{
		req.setAttribute("key1", name);
		req.setAttribute("key2", email);
	}
	else
	{
		res.getWriter().print("enter the details");
	}
   req.getRequestDispatcher("pw2").include(req, res);
	}

}
