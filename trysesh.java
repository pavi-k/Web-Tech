import java.net.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class trysesh extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		res.setContentType("ext/html");
		PrintWriter out=res.getWriter();
		HttpSession sesh=req.getSession(true);
		Integer ac=new Integer(0);
        if(sesh.isNew()){
        	out.println("Welcome New Comer");
        }
else{
	out.println("Hi old man");
	if((Integer)sesh.getValue("ac")!=0)
	{
		out.println("Count"+sesh.getValue("ac"));
	}
	}
	ac=(Integer)sesh.getValue("ac");
	ac=ac+1;
	sesh.putValue("ac",ac);

}
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
	doGet(req,res);
}
}

