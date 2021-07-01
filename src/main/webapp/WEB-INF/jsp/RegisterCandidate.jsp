<%-- 
    Document   : RegisterCandidate
    Created on : 02-Apr-2021, 10:54:43 pm
    Author     : jyoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Register Candidate</title>
        <style type="text/css">
            .error{color:red}
        </style>
         <link href="resource/css/bootstrap.min.css" rel="stylesheet" />

    </head>
    <body>
        <div class="container">
            
      <center>  <h1> Candidate Registeration Form</h1> </center>
        <form:form modelAttribute="candidate"> 
            FirstName :  <form:input path="firstName" type="text" class="form-control"/>
            <form:errors path="firstName" cssClass="error"/><br/>
            
            LastName : <form:input path= "lastName" type = "text" class="form-control"/>
            <form:errors path="lastName" cssClass="error"/><br/>

            Current Company : <form:input type = "text" path= "current_Company" class="form-control"/>
            <form:errors path="current_Company" cssClass="error"/><br/>

            DOB : <form:input type = "date" path= "dob" placeholder="MM/dd/yyyy"/>
            <form:errors path="dob" cssClass="error"/><br/>

            
            Gender: <form:radiobutton path="gender" value="male" class="form-check-input"/> Male 
                    <form:radiobutton path="gender" value="female" class="form-check-input"/>  Female 
            <br/>
  

            Contact:  
            <form:input type="text" path="contact" class="form-control"/>
            <form:errors path="contact" cssClass="error"/></br>
            
            Current location :
            <form:input type="text" path="current_location" class="form-control"/> 
            <form:errors path="current_location" cssClass="error"/></br>

            Current Job Title : <form:input type="text" path="current_JobTitle" class="form-control"/> </br>
            
            Employment Type Preference:
            <form:select path="employmentTypePreference"  multiple="false" class="form-select" aria-label="Default select example">
                <form:option value="Full Time"/> 
                <form:option value="Freelance"/>
                <form:option value="Part Time"/>
                <form:option value="Contract"/>
                <form:option value="Intern"/>
            </form:select>
            <form:errors path="primary_skills" cssClass="error"/></br>
            
            
            Primary Skills :
            </br>
            <form:select path="primary_skills"  multiple="true" class="form-select" aria-label="Default select example">
                <form:options items="${UniversalSkillSet}"/>  
            </form:select>
            <form:errors path="primary_skills" cssClass="error"/></br>

 
            Username : <form:input type = "email" path= "userName" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"/>
            <form:errors path="userName" cssClass="error"/><br/>
            Password : <form:input type = "password" path= "password" class="form-control" id="exampleInputPassword1"/>
            <form:errors path="password" cssClass="error"/><br/>

            <button type="submit" class="btn btn-primary">Submit</button>

        </form:form>
            </div>
    </body>
</html>
