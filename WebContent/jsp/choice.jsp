<%@ page import="project2.model.*"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="../js/mysource.jsp" %> 

<body>

<h1>Select Choice</h1>
   <FORM METHOD="GET" ACTION="./showChoice">
   <TABLE BORDER="1" CELLPADDING="3" CELLSPACING="1">
    <TR>
        <TH>OptionName</TH>
        <TH>Choice</TH>
        
    </TR>
     
    <%=((Automobile)request.getAttribute("auto")).toHTML()%>
    
    </TABLE>
    <input type="submit" >
    </FORM>

    
    
    
  
</body>
</html>