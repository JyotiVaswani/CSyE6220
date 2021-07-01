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
        <h1>Open Jobs!</h1>
        
        <c:choose>
            <c:when test="${empty JobList}">
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
                <c:forEach var="j" items="${JobList}">
                <tr>
                    <th> ${j.jobTitle}</th> 
                    <th> ${j.company}</th>
                    <th> ${j.startDate}</th>
                    <th> ${j.location}</th>
                    <th> ${j.salaryOffered}</th>
                    <th> ${j.primary_skills}</th>
                   
                    <c:set var= "curr_job" value="${j.jobId}" scope="request"/>
                    <c:set var= "job_rec" value="${j.recId.userId}" scope="request"/>
                    <th> <form action="ApplyJob.htm" method="GET">
                        <input type="hidden" name="jid" value= "${curr_job}" />
                        <input type="hidden" name="rid" value= "${job_rec}" />
                        <input type="Submit" value= "Apply Now!"/>
                        </form> 
                    </th>
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
