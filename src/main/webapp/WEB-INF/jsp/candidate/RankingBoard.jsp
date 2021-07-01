<%-- 
    Document   : RankingBoard
    Created on : 29-Apr-2021, 5:04:51 pm
    Author     : jyoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ranking Board</title>
    </head>
    <body>
        <h1>Top Companies</h1>
        
        <c:choose>
            <c:when test="${empty RatingRanks}">
                <c:out value="Insufficient data"/>
            </c:when> 
            <c:otherwise>
            <table>
                <tr>
                     
                    <th> Company</th>
                    <th> Average Rating </th>
                </tr>  
                <c:forEach var="gr" items="${RatingRanks}">
                <tr>
                    <th border = 1> ${gr.company}</th> 
                    <th border = 1> ${gr.avgOARating}</th>
                </tr>
                </c:forEach>
            </table>
            </c:otherwise>
        </c:choose>
        
        <form action="/TechWorldHustle/candidate/CandidateHome.htm" method="GET">
            <input type="Submit" value= "Go to Homepage!"/>
        </form>  
        <br>
        <br>
        <form action="/TechWorldHustle/logout.htm" method="GET">
            <input type="Submit" value= "Logout"/>
        </form>
        
    </body>
</html>
