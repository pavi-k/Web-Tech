<%@page contentType="text/html" language="java" import="java.sql.*"%>
<html>
<head>
<title>Online Exam Server</title>
<style type="text/css">
   body{background-color:yellow;font-family:courier;color:blue}
</style>
</head>
<body>
<h2 style="text-align:center">ONLINE EXAMINATION</h2>
<p>
<a href="ExamClient.jsp">Back To Main Page</a>
</p>
<hr/>
<%
String str1=request.getParameter("ans1");
String str2=request.getParameter("ans2");
String str3=request.getParameter("ans3");
String str4=request.getParameter("ans4");
String str5=request.getParameter("ans5");
String str6=request.getParameter("ans6");    
int mark=0;
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/examDS","root","root");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from examTab");
int i=1;
while(rs.next())
{
 if(i==1)
 {
  String dbans1=rs.getString(1);
  if(str1.equals(dbans1))
  {
   mark=mark+5;
  }
 }
 if(i==2)
 {
  String dbans2=rs.getString(1);
  if(str2.equals(dbans2))
  {
   mark=mark+5;
  }
 }
 if(i==3)
 {
  String dbans3=rs.getString(1);
  if(str3.equals(dbans3))
  {
   mark=mark+5;
  }
 }
 if(i==4)
 {
  String dbans4=rs.getString(1);
  if(str4.equals(dbans4))
  {
   mark=mark+5;
  }
 }
 if(i==5)
 {
  String dbans5=rs.getString(1);
  if(str5.equals(dbans5))
  {
   mark=mark+5;
  }
 }  
 if(i==6)
 {
  String dbans6=rs.getString(1);
  if(str6.equals(dbans6))
  {
   mark=mark+5;
  }
 }    
 i++;
}
if(mark>=15)
{
 out.println("<h4>Your Mark Is : "+mark+"</h4>");
 out.println("<h3>Congratulations....! You Are Eligible For The Next Round...</h3>");
}
else
{
 out.println("<h4>Your Mark is : "+mark+"</h4>");
 out.println("<h3>Sorry....!! You Are Not Eligible For  The Next Round...</h3>");
} 
%>
</form>
</body>
</html>