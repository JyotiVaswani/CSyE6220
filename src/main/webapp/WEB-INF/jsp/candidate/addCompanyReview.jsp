<%-- 
    Document   : addCompanyReview
    Created on : 05-Apr-2021, 1:01:05 pm
    Author     : jyoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Company Review</title>
        <link href="resource/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
    <div class="container">
      <h1> Add Company Review</h1>
        
        <form:form modelAttribute="companyReview">

            Job Title :  <form:input path="jobTitle" type="text" class="form-control"/><br/><br/>
            Company : 
            <form:select path="company"  multiple="false" class="form-select" aria-label="Default select example" >
                <form:options items="${UniversalCompanySet}"/>  
            </form:select>
            
            <br/><br/>

            Employment Status : 
                    <form:radiobutton path="employmentStatus" value="current"/> Current 
                    <form:radiobutton path="employmentStatus" value="former"/>  Former 
            <br/><br/>

            Last Year Of Employment : <form:input type = "number" path= "lastYearOfEmployment"/> <br/><br/>

            Employment Type: 
                  
                    <form:select path="employmentType"  multiple="false" class="form-select" aria-label="Default select example" >
                        <form:option value="fullTime" label="Full Time"/>
                        <form:option value="partTime" label="Part Time"/>
                        <form:option value="contract" label="Contract"/>
                        <form:option value="freelancer" label="Freelancer"/>
                        <form:option value="intern" label="Intern"/>
                    </form:select>
            <br/><br/>
   
            Pros:  
            <form:input type="textarea" path="pros" class="form-control" aria-label="With textarea"/> </br><br/>
            
            Cons :
            <form:input type="textarea" path="cons" class="form-control" id="exampleFormControlTextarea1" rows="3"/> </br>
<br/>
            Advice To Management : <form:input type="textarea" path="adviceToManagement" class="form-control" id="exampleFormControlTextarea1" rows="3"/> </br>
<br/>
            
            
            Additional Comments : <form:input type = "textarea" path= "additionalComments" class="form-control" id="exampleFormControlTextarea1" rows="3"/> <br/>
            
            <br/>
            Career Opportunities : <form:input type = "number" path= "rating.careerOpportunities" step=".01"/> <br/>
            Compensation And Benefits : <form:input type = "number" path= "rating.compensationAndBenefits" step=".01"/> <br/>
            Work-Life Balance : <form:input type = "number" path= "rating.workLifeBalance" step=".01"/> <br/>
            Senior Management : <form:input type = "number" path= "rating.seniorManagement" step=".01"/> <br/>
            Work Culture : <form:input type = "number" path= "rating.workCulture" step=".01"/> <br/>
            Values Employee : <form:input type = "number" path= "rating.valuesEmployee" step=".01"/> <br/>
            Percent Recommend To A Friend : <form:input type = "number" path= "rating.percentRecommendToAFriend"/> <br/>
            Business Outlook : <form:input type = "number" path= "rating.businessOutlook" step=".01"/> <br/>
            CEO Approval : <form:input type = "number" path= "rating.ceoApproval" step=".01"/> <br/>
            
            <input type= "submit" value= "Submit Review"/>

        </form:form>
            
 
        
        <form action="/TechWorldHustle/candidate/CandidateHome.htm" method="GET">
            <input type="Submit" value= "Go to Homepage!"/>
        </form> 
        <br>
        <br>
        <form action="/TechWorldHustle/logout.htm" method="GET">
            <input type="Submit" value= "Logout"/>
        </form>  
         </div>
            
    </body>
</html>
