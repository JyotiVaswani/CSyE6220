<%-- 
    Document   : Login
    Created on : 04-Apr-2021, 6:30:04 pm
    Author     : jyoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="resource/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
<form action = "login.htm" method= "post">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name= "userName">
    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" name= "password">
  </div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="role" id="flexRadioDefault1" value="Recruiter">
  <label class="form-check-label" for="flexRadioDefault1">
    Recruiter
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="role" id="flexRadioDefault2" checked value="Candidate"> 
  <label class="form-check-label" for="flexRadioDefault2">
    Candidate
  </label>
</div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form> 

        </div>
    </body>
</html>