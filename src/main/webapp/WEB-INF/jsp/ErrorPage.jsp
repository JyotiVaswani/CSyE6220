<%-- 
    Document   : ErrorPage
    Created on : 04-Apr-2021, 7:57:13 pm
    Author     : jyoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>${requestScope.ErrorMsg}</h1>
    </body>
</html>
