<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<h2>Hello World!</h2>
<hr>
<div>
    <ul>
        <li>${user.id()}</li>
        <li>${user.userId()}</li>
        <li>${user.username()}</li>
    </ul>
</div>
</body>
</html>