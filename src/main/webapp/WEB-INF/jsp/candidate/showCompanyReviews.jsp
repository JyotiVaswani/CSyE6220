<%-- 
    Document   : showCompanyRating
    Created on : 25-Apr-2021, 10:41:02 am
    Author     : jyoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Company Reviews and Rating</title>
    </head>
    <body>
        <h1>Company Review and Rating</h1>
        
        <c:choose>
            <c:when test="${empty CompanyReviews}">
                <c:out value="No Reviews and Ratings found!"/>
            </c:when> 
            <c:otherwise>
            <table>
                <tr>
                    <th>Date</th>
                    <th>Overall Rating</th>
                    <th>Pros</th> 
                    <th>Cons</th>
                    <th>Employment Status</th>
                    
                </tr>  
                <c:forEach var="cmpr" items="${CompanyReviews}">
                    <tr>
                        <th>${cmpr.reviewDate}</th>
                        <th>${cmpr.rating.overallRating} <br>
                            <form action="showDetailedCompanyRating.htm" method="POST">
                                <c:set var="rId" value="${cmpr.reviewId}" scope="request"/>
                                <input type="hidden" name="rId" value= "${rId}" />
                             <input type="Submit" value= "Show All Ratings"/></th>
                            </form>     
                        <th> ${cmpr.pros}</th> 
                        <th> ${cmpr.cons}</th>
                        <th>${cmpr.employmentStatus}</th>
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
