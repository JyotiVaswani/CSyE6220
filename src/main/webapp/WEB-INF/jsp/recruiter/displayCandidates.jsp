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
        <h1>Active Candidates</h1>
        
        <c:choose>
            <c:when test="${empty CandidateList}">
                <c:out value="No Candidates found!"/>
            </c:when> 
            <c:otherwise>
            <table>
                <tr>
                    <th> Name </th> 
                    <th> Contact </th>
                    <th> Job Title </th>
                    <th> Location</th>
                    <th> Employment Type Preference</th>
                    <th> Key Skills</th>
                </tr>  
                <c:forEach var="c" items="${CandidateList}">
                <tr>
                    <th> ${c.firstName} ${c.lastName}</th> 
                    <th> ${c.contact}</th>
                    <th> ${c.current_JobTitle}</th>
                    <th> ${c.current_location}</th>
                    <th> ${c.employmentTypePreference}</th>
                    <th> ${c.primary_skills}</th>
                </tr>
                </c:forEach>
            </table>
            </c:otherwise>
        </c:choose>
        
        <p> Too many results ? </p>
           
        
        <form action="/TechWorldHustle/recruiter/advancedCandidateSearchParameters.htm" method="GET">
            <input type="Submit" value= "Try Advanced Search!"/>
        </form> 
                   
        <form action="/TechWorldHustle/recruiter/RecruiterHome.htm" method="GET">
            <input type="Submit" value= "Go to Homepage!"/>
        </form>  
        <br>
        <br>
        <form action="/TechWorldHustle/logout.htm" method="GET">
            <input type="Submit" value= "Logout"/>
        </form>
        
        
    </body>
</html>
