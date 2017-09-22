<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:if test="${true}">
<link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.css">
<link rel="stylesheet" href="/webjars/animate.css/3.5.2/animate.css">
</c:if>
<c:if test="${false}">
<link rel="stylesheet" href="../css/bootstrap.css" data-th-remove="all">
<link rel="stylesheet" href="../css/3.5.2/animate.css" data-th-remove="all">
</c:if>
<title>DeptList.jsp</title>
</head>
<body>
	<table class="table table-hover animated bounce">
        <thead>
                <tr>
                        <th>DEPTNO</th><th>DNAME</th><th>LOC</th>
                </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
                <c:forEach var="d" items="${depts}">
                <tr>
                        <td>${d.deptno}</td><td>${d.dname}</td><td>${d.loc}</td>
                <tr>
                </c:forEach>
        </tbody>
</table>
<hr>
<c:set var="xxx" value="${depts}"/>
<ul class="list-group animated fadeInDown" >
        <li class="list-group-item">${xxx}</li>
</ul>

</body>
</html>