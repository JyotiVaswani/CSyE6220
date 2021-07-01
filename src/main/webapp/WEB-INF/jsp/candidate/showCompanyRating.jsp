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
        <title>Company Review and Rating</title>
    </head>
    <body>
        <h1>Company Review and Rating</h1>
        
        <c:choose>
            <c:when test="${empty Rating}">
                <c:out value="No Reviews and Ratings found!"/>
            </c:when> 
            <c:otherwise>
                
                
            <table>
                <tr>
                    <h3><th>Overall Rating</th></h3>
                    <th> Career Opportunities</th> 
                    <th> Compensation And Benefits</th>
                    <th>Work-Life Balance</th>
                    <th>Senior Management</th>
                    <th>Work Culture</th>
                    <th>Values Employee</th>
                    <th>Percent Recommend To A Friend</th>
                    <th>Business Outlook</th>
                    <th>CEO Approval</th>
                    
                </tr>  
                <c:forEach var="avgr" items="${Rating}">
                <tr>
                    <h3><th>${avgr.overallRating}</th></h3>
                    <th> ${avgr.careerOpportunities}</th> 
                    <th> ${avgr.compensationAndBenefits}</th>
                    <th> ${avgr.workLifeBalance}</th>
                    <th> ${avgr.seniorManagement}</th>
                    <th> ${avgr.workCulture}</th>
                    <th> ${avgr.valuesEmployee}</th>
                    <th> ${avgr.percentRecommendToAFriend}</th>
                    <th> ${avgr.businessOutlook}</th>
                    <th> ${avgr.ceoApproval}</th>
                    
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
