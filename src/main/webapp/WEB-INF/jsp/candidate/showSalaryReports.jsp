<%-- 
    Document   : showSalaryReports
    Created on : 27-Apr-2021, 2:16:55 pm
    Author     : jyoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salary Reports</title>
    </head>
    <body>
        <h1>Salary Reports!</h1>
        
        <c:choose>
            <c:when test="${empty SalaryReports}">
                <c:out value="No Salary Reports found!"/>
            </c:when> 
            <c:otherwise>
            <table>
                <tr>
                    <th>Job Title</th> 
                    <th>Company</th>                    
                    <th>Location</th>
                    <th>Employment Type</th>
                    <th>Base pay</th> 
                    <th>Cash Bonus</th>
                    <th>Stock Bonus</th>
                    <th>Profit Sharing</th>
                    <th>Sales Commission</th>
                </tr>  
                <c:forEach var="sr" items="${SalaryReports}">
                    <tr>
                        <th>${sr.jobTitle}</th>
                        <th>${sr.company}</th>
                        <th>${sr.location}</th>
                        <th>${sr.employmentType}</th>
                        <th>${sr.basePay}</th>
                        <th>${sr.cashBonus}</th>
                        <th>${sr.stockBonus}</th>
                        <th>${sr.profitSharing}</th>
                        <th>${sr.salesCommission}</th>
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
