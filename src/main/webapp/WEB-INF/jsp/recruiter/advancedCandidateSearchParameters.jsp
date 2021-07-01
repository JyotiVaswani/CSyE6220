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
        <title>Advanced Candidate Search </title>
    </head>
    <body>
        <h1>Advanced Candidate Search </h1>
        
        <form:form modelAttribute="candidate">
            
            Job Title :  <form:input path="current_JobTitle" type="text"/><br/>
            </br>
            Location:   
            <form:input type="text" path="current_location"/> </br>
            
           </br></br>

            Employment Type Preference:
            <form:select path="employmentTypePreference"  multiple="false" >
                <form:option value="No preference"/>
                <form:option value="Full Time"/> 
                <form:option value="Freelance"/>
                <form:option value="Part Time"/>
                <form:option value="Contract"/>
                <form:option value="Intern"/>
            </form:select>
            </br></br>
            Key Skills:
            </br>
            <form:select path="primary_skills"  multiple="true" >
                <form:option value="" label="No preference"/>
                <form:options items="${UniversalSkillSet}"/>  
            </form:select></br>
            </br></br>
        <input type="submit" value="Advanced Search"></button> <br>
            
        </form:form>
        </br>
            
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
