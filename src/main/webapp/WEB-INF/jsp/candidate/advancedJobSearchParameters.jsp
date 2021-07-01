<%-- 
    Document   : advancedSearchParameters
    Created on : 18-Apr-2021, 10:44:46 am
    Author     : jyoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Advanced Job Search </title>
    </head>
    <body>
        <h1>Advanced Job Search </h1>
        
        <form:form modelAttribute="job">
            
            Job Title :  <form:input path="JobTitle" type="text"/><br/><br/>
            Company : <form:input path= "Company" type = "text"/><br/><br/>

            Start Date : <form:input type = "Date" path= "StartDate"/><br/><br/>

            Minimum Salary : <form:input type = "number" path= "SalaryOffered"/> <br/><br/>

            <br/>
            Primary Skills :
            </br>
            <form:select path="primary_skills"  multiple="true" >
                <form:option value="" label="No preference"/>
                <form:options items="${UniversalSkillSet}"/>  
            </form:select></br><br/>

            Location:   
            <form:input type="text" path="Location"/> </br><br/>
            
            <button name="jobaction" type="submit" value="advancedSearch"> Search </button> <br><br/><br/>
            <button name="jobaction" type="submit" value="addForAlerts"> Create Alert</button><br/><br/>
        </form:form>  
            
        <form action="/TechWorldHustle/candidate/CandidateHome.htm" method="GET">
            <input type="Submit" value= "Go to Homepage!"/>
        </form>  
        <br><br/><br/>
        <br>
        <form action="/TechWorldHustle/logout.htm" method="GET">
            <input type="Submit" value= "Logout"/>
        </form>
        
            
    </body>
</html>
