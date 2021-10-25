<%--
  Created by IntelliJ IDEA.
  User: 子豪
  Date: 2021/10/9
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/input">返回</a><br>
停车场空闲车位<br>
<c:forEach items="${List}" var="Integer">
    ${Integer}&nbsp;&nbsp;&nbsp;&nbsp;
    <br>
</c:forEach>

<br>添加车位信息(仅供参考)
<form action="${pageContext.request.contextPath }/addCI" method="post">
    <label>停车位</label><input type="type" name="parking_id" /> <br>
    <label>车牌号</label><input type="type" name="car_number" /> <br>
    <label>车主</label><input type="type" name="host_name" /> <br>
    <label>联系电话</label><input type="type" name="phone" /> <br>
    <input type="submit" value="开始停车">
</form>

</body>
</html>
