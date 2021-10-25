<%--
  Created by IntelliJ IDEA.
  User: 子豪
  Demo: 2021/9/26
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/input">返回</a><br>
添加停车场信息
<br> <a href="${pageContext.request.contextPath}/input">返回</a>
<form action="${pageContext.request.contextPath }/addPLinfo" method="post">
    <label>状态</label><input type="type" name="parking_status" /> <br>
    <input type="submit" value="确认添加">
</form>

<br>
添加车辆信息
<br>
<form action="${pageContext.request.contextPath }/addCI" method="post">
    <label>车位编号</label><input type="type" name="parking_id" /> <br>
    <label>车牌</label><input type="type" name="car_number" /> <br>
    <label>车主</label><input type="type" name="host_name" /> <br>
    <label>联系电话</label><input type="type" name="phone" /> <br>
    <input type="submit" value="确认添加">
</form>
<br>添加费用
<form action="${pageContext.request.contextPath }/updatefareinfo" method="post">
    <label>车位号</label><input type="type" name="parking_id" /> <br>
    <label>金额</label><input type="type" name="fare" /> <br>
    <input type="submit" value="确认添加">
</form>
</body>
</html>
