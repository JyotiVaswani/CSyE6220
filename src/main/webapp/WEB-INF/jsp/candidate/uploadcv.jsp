<%-- 
    Document   : uploadCV
    Created on : 29-Apr-2021, 9:49:09 am
    Author     : jyoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Upload CV</title>

    </head>
    <body>
        <h1>Upload CV</h1>
<form method="POST" enctype="multipart/form-data" action="/TechWorldHustle/candidate/uploadcv.htm">
  File to upload: <input type="file" name="upfile"><br/>
 
  <br/>
  <input type="submit" value="Press"> to upload the file!
</form>
        
        <form action="/TechWorldHustle/candidate/CandidateHome.htm" method="GET">
            <input type="Submit" value= "Go to Homepage!"/>
        </form>  
        <br>
        <br>
        <form action="/TechWorldHustle/logout.htm" method="GET">
            <input type="Submit" value= "Logout"/>
        </form>
        
    </body>
</html>
