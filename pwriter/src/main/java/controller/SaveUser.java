package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.Dao;
import dto.javabeanuser;
@WebServlet("/saveuser")
@MultipartConfig(maxFileSize=10*1024*1024)
public class SaveUser extends HttpServlet
{
  @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	long contact=Long.parseLong(req.getParameter("contact"));
	String password=req.getParameter("password");
	Part imagepart=req.getPart("image");
	byte[] imagebytes=imagepart.getInputStream().readAllBytes();
	
	javabeanuser user= new javabeanuser(id,name,email,contact,password,imagebytes);
	Dao dao=new Dao();
	try {
		int res=dao.saveUser(user);
		if(res>0)
		{
//			resp.getWriter().print("login success");
			resp.sendRedirect("logined.jsp");
		}
		else
		{
			resp.getWriter().print("login failed");
		}
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	
	
}
}
