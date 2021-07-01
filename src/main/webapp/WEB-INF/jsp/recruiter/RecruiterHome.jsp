<%-- 
    Document   : RecruiterHome
    Created on : 04-Apr-2021, 8:04:53 pm
    Author     : jyoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recruiter HomePage</title>
    </head>
    <body>
        <h1>Hello Recruiter!</h1>

        <p> ---- Jobs --- </p>
        <form action="/TechWorldHustle/recruiter/AddJobPosting.htm" method="GET">
            <input type="Submit" value= "Add New Job Posting!"/>
        </form>
        <br>
        <form action="/TechWorldHustle/recruiter/ViewJobs.htm" method="GET">
            <input type="Submit" value= "ViewJobs"/>
        </form>
        <br>
        <form action="/TechWorldHustle/recruiter/AddWalkInDrive.htm" method="GET">
            <input type="Submit" value= "Add New WalkIn Interview Drive!"/>
        </form>
        <br>
        <p> ---- Candidates --- </p>
        <br>
        <form action="/TechWorldHustle/recruiter/searchCandidates.htm" method="GET">
            <input type="Submit" value= "Search Candidates"/>
        </form>
        
        
        <br>
        <form action="/TechWorldHustle/logout.htm" method="GET">
            <input type="Submit" value= "Logout"/>
        </form>
        

         
           
    </body>
</html>
