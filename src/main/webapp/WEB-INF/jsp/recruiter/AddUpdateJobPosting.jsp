<%-- 
    Document   : AddJobPosting
    Created on : 05-Apr-2021, 11:22:00 am
    Author     : jyoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add/Update Job Posting</title>
        <style type="text/css">
            .error{color:red} 
        </style>
    </head>
    <body>
        
        <h1>Add New Job: </h1> <br>
        
        <form:form modelAttribute="job">
            
            Job Title :  <form:input path="jobTitle" type="text"/>
            <form:errors path="jobTitle" cssClass="error"/>
            <br/>
            Company : <form:input path= "company" type = "text"/>
            <form:errors path="company" cssClass="error"/><br><br/>

            Start Date : <form:input type = "Date" path= "startDate" placeholder="MM/dd/yyyy"/>
            <form:errors path="startDate" cssClass="error"/><br/>

            Salary Offered : <form:input type = "number" path= "salaryOffered"/> 
            <form:errors path="salaryOffered" cssClass="error"/><br/>

            <br/>
  

            Location:   
            <form:input type="text" path="location"/>
            <form:errors path="location" cssClass="error"/></br>
           
            Job Description :
            <form:input type="textarea" path="jobDescription"/> </br>
            <br>
            Key Skills :
            </br>
            <form:select path="primary_skills" multiple="true">
                <form:option value="No preference"/> 
                <c:forEach var="s" items="${requestScope.UniversalSkillSet}">
                    <form:option value="${s.skillName}"/>  
                </c:forEach>
            </form:select></br>
            <form:errors path="primary_skills" cssClass="error"/>

            <br>
            Status: 
            <form:input type="text" path="status"/> </br>
            
            <input type= "submit" value= "Submit"/>
        </form:form>
            
        
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
