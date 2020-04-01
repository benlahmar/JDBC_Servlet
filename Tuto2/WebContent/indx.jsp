<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%!
    String message="";
    String etat="";
    int cpt=0;
    %>
    
    <%
    if(request.getAttribute("msg")!=null)
    {
    	cpt=Integer.parseInt(request.getAttribute("cpt").toString());
    	message=request.getAttribute("msg").toString()+" <br/>"+ cpt+" ieme tetative";
    	if(cpt>3)
    		etat="disabled";
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> Authentification</h2>
<form action="Serve2" method="post"> 
<input type="text" name="log">
<br/>
<br/>
<input type="password" name="pass">
<br/>
<br/>
<input type="submit" value="connect"  <%=etat %>>
</form>
<%=message %>
</body>
</html>