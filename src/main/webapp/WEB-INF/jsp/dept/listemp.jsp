<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ tablib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:if test="${true}">
	<link rel="stylesheet"
		href="/webjars/bootstrap/3.3.7/css/bootstrap.css">
	<link rel="stylesheet" href="/webjars/animate.css/3.5.2/animate.css">
</c:if>
<c:if test="${false}">
	<link rel="stylesheet" href="../css/bootstrap.css" data-th-remove="all">
	<link rel="stylesheet" href="../css/3.5.2/animate.css"
		data-th-remove="all">
</c:if>
<title>listemp.jsp</title>
</head>
<body>
	<h1>Dept List With Emp</h1>
	${depts}
	<hr />
	<ol>

		<c:forEach var="dept" items="${depts}">
		<li>
			<h3>${dept.deptno}, ${dept.dname}, ${dept.loc}</h3>
			<table class="table table-bordered">
				<thead>
					<tr><td>EMPNO</td><td>ENAME</td><td>GENDER1</td>
						<td>GENDER2</td><td>JOB</td><td>MGR</td>
					</tr>
				</thead>
				<c:forEach var="emp" items="${dept.emps}">
					<tr>
						<td>${emp.empno}</td>
						<td>${emp.ename}</td>
						<td>${emp.gender}</td>
						<td>
							<c:choose>
								<c:when test="${emp.gender =='M'}">남자</c:when>
								<c:when test="${emp.gender =='m'}">남자</c:when>
								<c:when test="${emp.gender =='F'}">여자</c:when>
								<c:when test="${emp.gender =='f'}">여자</c:when>
							</c:choose>
						</td>
						<td>${emp.job}</td>
						<td>매니저: ${emp.mgr.ename}</td>
<%-- 						<td><fmt:formatDate value="${emp.hiredate}" pattern="yyyy MM dd"/></td> --%>
					</tr>
				</c:forEach>
			</table>
		</li>
		</c:forEach>
	</ol>
	<%-- 	${depts[0].emps} --%>
	<%-- 	${depts[1].emps}  --%>
	<%-- 	${depts[2].emps}  --%>
	<%-- 	${depts[3].emps}  --%>
</body>
</html>