<%-- 
    Document   : displayJobs
    Created on : 11-Apr-2021, 7:16:13 pm
    Author     : jyoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jobs</title>
    </head>
    <body>
        <h1>WalkIn Drives!</h1>
        
        <c:choose>
            <c:when test="${empty WalkInDrivePosted}">
                <c:out value="No drives available!"/>
            </c:when> 
            <c:otherwise>
            <table>
                <tr>
                    
                    <th> Company</th>
                    <th> Date</th>
                    <th> Location</th>
                    <th> Venue</th>
                </tr>  
                <c:forEach var="w" items="${WalkInDrivePosted}">
                <tr>
                    <th> ${w.company}</th>
                    <th> ${w.driveDate}</th>
                    <th> ${w.baseLocation}</th>
                    <th> ${w.venue}</th>  
                </tr>
                </c:forEach>
            </table>
            </c:otherwise>
        </c:choose>
        
        <p> Too many results ? </p>
           <a href="<c:url value="/candidate/advancedJobSearchParameters.htm" />" > Try Advanced Search!</a> 
        
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
