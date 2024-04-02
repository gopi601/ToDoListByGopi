package test1;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/pw2")
public class pb2 extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String name=(String) req.getAttribute("key1");
		String email=(String) req.getAttribute("key2");
		res.getWriter().print(name);
		res.getWriter().println(email);
		
		
	}

}
