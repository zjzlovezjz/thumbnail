<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>缩略图效果</title>
</head>
<body>
<h4>图片信息</h4>
	<hr/>
	<table width="100%">
		<tr>
			<td width="50%" align="center"><img src='${pageContext.request.contextPath}${imageURL}' width="500"></td>
			<td width="50%" align="center"><img src='${pageContext.request.contextPath}${thumbImageURL}'></td>
		</tr>
	</table>
	<hr/>
	<a href="${pageContext.request.contextPath}">返回</a>
	<hr/>
</body>
</html>