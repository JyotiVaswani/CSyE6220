<%-- 
    Document   : RegistrationSuccess
    Created on : 04-Apr-2021, 11:04:27 am
    Author     : jyoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Successfull Registration</title>
    </head>
    <body>
        <h1>Welcome to TechWorldHustle!</h1>
        <h2> ${requestScope.successMessage} </h2>
      
               <form action="/TechWorldHustle/login.htm" method="GET">
            <input type="Submit" value= "Click to Login"/>
        </form>
        
    </body>
</html>
