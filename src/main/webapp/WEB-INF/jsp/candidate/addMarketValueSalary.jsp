<%-- 
    Document   : addMarketValueSalary
    Created on : 23-Apr-2021, 3:58:45 pm
    Author     : jyoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Market Value Salary</title>
    </head>
    <body>
        <h1>Add Salary</h1>
        
                
        <form:form modelAttribute="marketValueSalary">
            
            
            Job Title :  <form:input path="jobTitle" type="text"/><br/></br>
            Company : 
            <form:select path="company"  multiple="false" >
                <form:options items="${UniversalCompanySet}"/>  
            </form:select></br></br>

            Location:   
            <form:input type="text" path="location"/> </br></br>

            Employment Status : 
                    <form:radiobutton path="employmentStatus" value="current"/> Current 
                    <form:radiobutton path="employmentStatus" value="former"/>  Former 
            <br/></br>

            Years Of Experience : <form:input type = "number" path= "yearsOfExperience"/> <br/></br>

            Employment Type: 
                   
                    <form:select path="employmentType"  multiple="false" >
                        <form:option value="fullTime" label="Full Time"/>
                        <form:option value="partTime" label="Part Time"/>
                        <form:option value="contract" label="Contract"/>
                        <form:option value="freelancer" label="Freelancer"/>
                        <form:option value="intern" label="Intern"/>
                    </form:select>
            <br/>
  </br>
            Base Pay : <form:input type = "number" path= "basePay"/> <br/></br>
            
            Cash Bonus : <form:input type = "number" path= "cashBonus"/> <br/></br>
            
            Stock Bonus : <form:input type = "number" path= "stockBonus"/> <br/></br>
            
            Profit Sharing : <form:input type = "number" path= "profitSharing"/> <br/></br>

            Sales Commission : <form:input type = "number" path= "salesCommission"/> <br/></br>
            
            <input type= "submit" value= "Submit Salary"/>
        </form:form>

            </br>
        <form action="/TechWorldHustle/candidate/CandidateHome.htm" method="GET">
            <input type="Submit" value= "Go to Homepage!"/>
        </form> </br>
        <form action="/TechWorldHustle/logout.htm" method="GET">
            <input type="Submit" value= "Logout"/>
        </form>
    </body>
</html>
