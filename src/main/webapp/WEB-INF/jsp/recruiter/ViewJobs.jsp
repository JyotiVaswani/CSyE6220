<%-- 
    Document   : ViewJobs
    Created on : 11-Apr-2021, 12:36:29 pm
    Author     : jyoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Jobs</title>
    </head>
    <body>
        <h1> You have posted below Jobs:</h1>
         <c:choose>
            <c:when test="${empty JobPosted}">
                <c:out value="No Jobs found!"/>
            </c:when> 
            <c:otherwise>  
            <table>
            
            <tr>
            <th> Job Title</th> 
            <th> Company</th>
            <th> Start Date</th>
            <th> Location</th>
            <th> Salary</th>
            <th> Skills Required</th>
           
           </tr>  
            <c:forEach var="j" items="${JobPosted}">
            <tr>
            <th> ${j.jobTitle}</th> 
            <th> ${j.company}</th>
            <th> ${j.startDate}</th>
            <th> ${j.location}</th>
            <th> ${j.salaryOffered}</th>
            <th> ${j.primary_skills}</th>
            <c:set var= "curr_job" value="${j.jobId}" scope="request"/>
            <th> <form action="JobApplications.htm" method="GET">
                    <input type="hidden" name="jid" value= "${curr_job}" />
                    <input type="Submit" value= "Show Applications!"/>
                 </form> </th>
             </tr>
            </c:forEach>
            </table>
            </c:otherwise>
        </c:choose>
        
                
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
