<%-- 
    Document   : checkApplications
    Created on : 15-Apr-2021, 10:12:03 am
    Author     : jyoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Application Status</title>
    </head>
    <body>
                
        <c:choose>
            <c:when test="${empty ApplicationList}">
                <c:out value="No Applications found!"/>
            </c:when> 
            <c:otherwise>
            <table>
                <tr>
                    <th> Job Title: </th> 
                    <th> Company: </th>
                    <th> Location: </th>
                    <th> Application Date: </th>
                    <th> Application Status: </th>
                    <th> Remarks: </th>
                </tr>  
                <c:forEach var="app" items="${ApplicationList}">
                <tr>
                    <th> ${app.jobId.jobTitle}</th> 
                    <th> ${app.jobId.company}</th>
                    <th> ${app.jobId.location}</th>
                    <th> ${app.applicationDate}</th>
                    <th> ${app.status}</th>
                    <th> ${app.remarks}</th>
                    
                    <c:if test="${app.status ne 'Withdrew'}">
                    <th>
                    <c:set var= "curr_app" value="${app.applicationId}" scope="request"/>
            
                        <form action="withdrawApplication.htm" method="GET">
                            <input type="hidden" name="appid" value= "${curr_app}" />
                            <input type="Submit" value= "Withdraw!"/>
                        </form></th> 
                    </c:if>
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
