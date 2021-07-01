<%-- 
    Document   : ViewApplications
    Created on : 14-Apr-2021, 4:36:28 pm
    Author     : jyoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Applications Received</title>
    </head>
    <body>
                <c:choose>
            <c:when test="${empty ApplicationsReceived}">
                <c:out value="No Applications found!"/>
            </c:when> 
            <c:otherwise>  
            <table>
             <tr>
            <th> Candidate Name: </th> 
            <th> Email Id: </th>
            <th> Contact number: </th>
            <th> Location: </th>
            <th> CV: </th>
            <th> Application Date: </th>
           </tr>  
           <c:forEach var="ar" items="${ApplicationsReceived}">
            <tr>
            <th> ${ar.candidateId.firstName} ${ar.candidateId.lastName}</th>
            <th> ${ar.candidateId.userName}</th>
            <th> ${ar.candidateId.contact}</th>
            <th> ${ar.candidateId.current_location}</th>
            <th> ${ar.candidateId.cv}</th>
            <th> ${ar.applicationDate}</th>
            <!-- button to fetch and load CV -->
            <th>
            <c:set var= "curr_app" value="${ar.applicationId}" scope="request"/>
                <form action="updateApplication.htm" method="GET">
                    <input type="hidden" name="appid" value= "${curr_app}" />
                    Update status: 
                    <select id="sts" name="sts">
                        <option value="Processing">Under Processing</option>
                        <option value="Accepted">Accepted</option>
                        <option value="Rejected">Rejected</option>
                    </select>
                    Add Remarks: <input type="text" name= "remarks"/>
                    <input type="Submit" value= "Update!"/>
                </form></th> 
            <!-- button to update application status and remarks -->
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
