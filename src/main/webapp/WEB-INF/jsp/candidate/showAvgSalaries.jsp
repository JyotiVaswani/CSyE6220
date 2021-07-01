<%-- 
    Document   : showSalaries
    Created on : 27-Apr-2021, 12:40:29 pm
    Author     : jyoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Salaries</title>
    </head>
    <body>
        <h1>Average Salary</h1>
        
        <c:choose>
            <c:when test="${empty AvgSalary}">
                <c:out value="No Salary Reports found!"/>
            </c:when> 
            <c:otherwise>
            <table>
                <tr>
                    <th>Job Title</th> 
                    <th>Company</th>
                    <th>Location</th>
                    <th>Minimum Salary</th>
                    <th>Average Salary</th> 
                    <th>Maximum Salary</th>
                </tr>  
                <tr>
                    <th>${AvgSalary.jobTitle}</th>
                    <th>${AvgSalary.company}</th>
                    <th>${AvgSalary.location}</th>
                    <th>${AvgSalary.min_basePay}</th>
                    <th>${AvgSalary.avg_basePay}</th>
                    <th>${AvgSalary.max_basePay}</th>
                </tr>    
            </table>
                 <form action="showMarketValueSalaries.htm" method="POST">
                    <c:set var="jT" value="${AvgSalary.jobTitle}" scope="request"/>
                    <c:set var="c" value="${AvgSalary.company}" scope="request"/>
                    <c:set var="l" value="${AvgSalary.location}" scope="request"/>
                               <input type="hidden" name="jobTitle" value= "${jT}" /> <br>
                               <input type="hidden" name="company" value= "${c}" /> <br>
                               <input type="hidden" name="location" value= "${l}" /> <br>
                             <input type="Submit" value= "Show Salary Reports"/></th>
                 </form>
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
