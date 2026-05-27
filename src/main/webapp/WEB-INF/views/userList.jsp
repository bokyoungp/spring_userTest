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
<h2>부서 검색</h2>

<form method="get" action="/users/dynamicSearch">
    부서명 <input type="text" name="dept" value="${param.dept}" placeholder="부서명 입력 (비우면 전체조회)" />
    나이 <input type="text" name="age" value="${param.age}" placeholder="나이 입력 (비우면 전체조회)" />
    <button type="submit">검색</button>
</form>

<hr>
<c:choose>
    <c:when test="${empty userList}">
        <p>검색 결과가 없습니다.</p>
    </c:when>
    <c:otherwise>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>아이디</th>
                <th>이름</th>
                <th>부서</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td>${user.id()}</td>
                    <td><a href="/users/${user.id()}">${user.userId()}</a></td>
                    <td>${user.username()}</td>
<%--                    <td>${user.dept()}</td>--%>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>
</body>
</html>