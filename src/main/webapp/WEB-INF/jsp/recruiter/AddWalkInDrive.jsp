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
        <title>Add/Update Walk-In Interview Drive</title>
        <style type="text/css">
            .error{color:red} 
        </style>
    </head>
    <body>
        
        <h1>Add/Update Walk-In Interview Drive: </h1> <br>
        
        <form:form modelAttribute="walkInDrive">
            

            <br/>
            Company : <form:input path= "company" type = "text"/>
            <form:errors path="company" cssClass="error"/><br><br/>

            Date : <form:input type = "Date" path= "driveDate" placeholder="MM/dd/yyyy"/>
            <form:errors path="driveDate" cssClass="error"/><br/>

            Location:   
            <form:input type="text" path="baseLocation"/>
            <form:errors path="baseLocation" cssClass="error"/></br>

            Venue:  
            <form:input type="text" path="venue"/> </br>
            <form:errors path="venue" cssClass="error"/></br>
            
            <input type= "submit" value= "Add Drive"/>
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
