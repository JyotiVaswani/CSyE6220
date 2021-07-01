<%-- 
    Document   : CandidateHome
    Created on : 04-Apr-2021, 8:05:33 pm
    Author     : jyoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Candidate HomePage</title>
    </head>
    <body>
        <h1>Hello Candidate!</h1>
        <p> ---- Job Opportunities --- </p>
        <form action="/TechWorldHustle/candidate/searchJobs.htm" method="GET">
            <input type="Submit" value= "SearchJobs"/>
        </form>
        <br>
        
        <form action="/TechWorldHustle/candidate/ViewWalkInDrive.htm" method="GET">
            <input type="Submit" value= "Show WalkInDrives"/>
        </form>
        <br>
        
        
        <p> ---- Update Profile --- </p>
        
        <form action="/TechWorldHustle/candidate/updateProfile.htm" method="GET">
            <input type="Submit" value= "Update Profile"/>
        </form>
        <br>
        <form action="/TechWorldHustle/candidate/uploadcv.htm" method="GET">
            <input type="Submit" value= "Upload CV"/>
        </form>
        <br>
        

        <p> ---- Applications --- </p>
        
        <form action="/TechWorldHustle/candidate/checkApplications.htm" method="GET">
            <input type="Submit" value= "Check Applications"/>
        </form>
        <br>
        <p> ----Add Reviews --- </p>
        <form action="/TechWorldHustle/candidate/addCompanyReview.htm" method="GET">
            <input type="Submit" value= "Add Company Review"/>
        </form>
            <br>
        <p> ---- Salaries --- </p>
        <form action="/TechWorldHustle/candidate/addMarketValueSalary.htm" method="GET">
            <input type="Submit" value= "Add Salary"/>
        </form>
        <br>
        
        <p> ---- Show Ratings  --- </p>
        <form action="/TechWorldHustle/candidate/showAvgCompanyRating.htm" method="POST">
          Company:  <input type="text" name="company"/>
            <input type="Submit" value= "Show Company Average Rating"/>
        </form>
        <br>
        
        <form action="/TechWorldHustle/candidate/showCompanyReviews.htm" method="POST">
           Company: <input type="text" name="company"/>
           Job Title:  <input type="text" name="jobtitle"/>
            <input type="Submit" value= "Show Company Reviews"/>
        </form>
        <br>
                 <form action="/TechWorldHustle/candidate/avgMarketValueSalary.htm" method="POST">
                    Job Title: <input type="text" name="jobTitle"/> <br>
                    <p> Search by</p>
                    Company:   <input type="text" name="company"/> And/Or Location:   <input type="text" name="location"/>
                             <input type="Submit" value= "Search Salaries"/>
                 </form>

        <br>
        
         <p> ---- Ranking Board --- </p>       
        <form action="/TechWorldHustle/candidate/RankingBoard.htm" method="GET">
            <input type="Submit" value= "Ranking Board"/>
        </form>
        <br>
        
        
        
        
        <br>
        <form action="/TechWorldHustle/logout.htm" method="GET">
            <input type="Submit" value= "Logout"/>
        </form>
        
        
        
        
    </body>
</html>
