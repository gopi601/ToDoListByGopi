package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialArray;
import javax.sql.rowset.serial.SerialBlob;

import dto.javabeanuser;

public class Dao 
{
  public static Connection getConnection() throws ClassNotFoundException, SQLException {
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist?user=root&password=root");
	  return conn;
	  }
  public static int saveUser(javabeanuser user) throws SQLException, ClassNotFoundException
  {
	  Connection con=getConnection();
	  PreparedStatement pst=con.prepareStatement("insert into user values(?,?,?,?,?,?)");
	  pst.setInt(1, user.getUserid());
	  pst.setString(2, user.getUsername());
	  pst.setString(3, user.getUseremail());
	  pst.setLong(4, user.getUsercontact());
	  pst.setString(5, user.getUserpassword());
      Blob imageBlob=new SerialBlob(user.getUserimage());
      pst.setBlob(6, imageBlob);
      int res=pst.executeUpdate();
      return res;
  
  }
  public javabeanuser findByEmail(String email) throws SQLException, ClassNotFoundException
  {
	  Connection con=getConnection();
	  PreparedStatement pst=con.prepareStatement("select * from user where useremail=?");
	  pst.setString(1, email);
	  ResultSet rst=pst.executeQuery();
	  if(rst.next())
	  {
		  javabeanuser user=new javabeanuser();
		  user.setUserid(rst.getInt(1));
		  user.setUsername(rst.getString(2));
		  user.setUseremail(rst.getString(3));
		  user.setUsercontact(rst.getLong(4));
		  user.setUserpassword(rst.getString(5));
		  Blob imageblob=rst.getBlob(6);
		  byte[] img=imageblob.getBytes(1, (int)imageblob.length());
		  user.setUserimage(img);
		  return user;
		  
		  
	  }
	  else
	  {
		  return null;
	  }
	  
	  
  }
}
