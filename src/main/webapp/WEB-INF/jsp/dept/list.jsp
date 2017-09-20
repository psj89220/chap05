<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.css">
<link rel="stylesheet" href="/webjars/animate.css/3.5.2/animate.css">
<link rel="stylesheet" href="../css/bootstrap.css" th:remove="all">
<link rel="stylesheet" href="../css/3.5.2/animate.css" th:remove="all">
<title>DeptList.jsp</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>DEPTNO</td>
			<td>DNAME</td>
			<td>LOC</td>
		</tr>
		<th:block th:each="dept : ${depts}">
			<tr >
				<td th:text="${dept.deptno}"></td>
				<td th:text="${dept.dname}"></td>
				<td th:text="${dept.loc}"></td>
			</tr>		
		</th:block>
	</table>
	
	${depts}
</body>
</html>