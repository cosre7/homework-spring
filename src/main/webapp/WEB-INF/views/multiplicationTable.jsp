<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html> 
<html lang="ko">
<head>
	<title>Home</title>
</head>
<body>
<c:set var="startRowNumber" value="${multiplication.startRowNumber }"/>
<c:set var="endRowNumber" value="${multiplication.endRowNumber }"/>
<c:set var="startColumnNumber" value="${startColumnNumber }"/>
<c:set var="endColumnNumber" value="${multiplication.endColumnNumber }"/>
<c:set var="table" value="${table}"/>
<%
	int startRowNumber = (int) pageContext.getAttribute("startRowNumber");
	int endRowNumber = (int) pageContext.getAttribute("endRowNumber");
	int startColumnNumber = (int) pageContext.getAttribute("startColumnNumber");
	int endColumnNumber = (int) pageContext.getAttribute("endColumnNumber");
	String[][] table = (String[][]) pageContext.getAttribute(("table"));
	
	out.write("<table border = 1>");
	out.write("<tr>");
	for (int k = startRowNumber; k <= endRowNumber; k++) {
	    for (int i = startRowNumber; i <= k; i++) {
	    	out.write("<td>");
	        for (int j = startColumnNumber; j <= endColumnNumber; j++) {
	            String color = (i % 2 == 1) ? "<font color=blue>" : "<font color=orange>"; 
				out.write(color + table[i][j] + "<br/>");
	        }
	        out.write("</td>");
	    }
	    out.write("</tr>");
	}
	out.write("</table>");
%>
</body>
</html>
