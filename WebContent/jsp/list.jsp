<%@ page import="project2.model.*"%> 
<%@ page import="java.util.ArrayList"%> 
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
<%  ArrayList<Automobile> list = (ArrayList<Automobile>)request.getAttribute("list");
request.getSession().setAttribute("list",list);
int index=0;%>
<h1>Select Model</h1>
   <FORM METHOD="GET" onsubmit = "sbFunc();" action="./getModel">
   <TABLE BORDER="1" CELLPADDING="3" CELLSPACING="1">
    
    <TR>
    <TH>Models: </TH>
    <TH>
    <select  name="model" id="item">
    
    <c:forEach items="${list}" var="auto" varStatus="loop">
    	
        <option value="${loop.index}" >${auto.model}</option>
        
    </c:forEach>
    
    </select>
    </TH>
    </TR>
    
     
    
    
   
    </TABLE>
    <input type="submit" >
    </FORM>

    
    
    
  
</body>
</html>