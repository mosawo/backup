<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>HelloStruts</title>
</head>
<body>
	<h1>HelloStruts2!</h1>
	<br>
	<table>
		<tbody>
			<tr>
				<th>ユーザID</th>
				<th>ユーザ名</th>
				<th>パスワード</th>
				<th>Result</th>
			</tr>
			<s:iterator value="#session.helloStrutsDTOList">
			<tr>
				<td><s:property value="userId"/></td>
				<td><s:property value="userName"/></td>
				<td><s:property value="password"/></td>
				<td><s:property value="result"/></td>
			</tr>
			</s:iterator>
		</tbody>
	</table>
</body>
</html>