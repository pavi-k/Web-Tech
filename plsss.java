import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class plsss extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String name=request.getParameter("name");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trial","root","root");
			PreparedStatement pst=con.prepareStatement("insert into try values(?,?,?)");
			pst.setString(1,name);
			pst.setString(2,mobile);
			pst.setString(3,email);
			int i=pst.executeUpdate();
			out.println("He!!");
			if(i!=0)
			{
				out.println("Inserted");
			}
			else
			{
				out.println("Error");

			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
		out.println("<!doctype html><html><body><p>Name:"+name+"</p><p>mobile:"+mobile+"</p><p>mail:"+email+"</p></body></html>");
         out.println("Hello!!!");
	}
}

