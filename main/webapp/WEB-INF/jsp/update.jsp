<%--
  Created by IntelliJ IDEA.
  User: 子豪
  Demo: 2021/9/26
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/input">返回</a><br>
更新停车位状态信息
<form action="${pageContext.request.contextPath }/statusToFree" method="post">
    <label>编号</label><input type="type" name="parking_id" /> <br>
    <input type="submit" value="确认修改状态到空闲">
</form><br>
<form action="${pageContext.request.contextPath }/statusToBusy" method="post">
    <label>编号</label><input type="type" name="parking_id" /> <br>
    <input type="submit" value="确认修改状态到占用">
</form>
更新车辆信息
<form action="${pageContext.request.contextPath }/updateCI" method="post">
    <label>用户编号</label><input type="type" name="user_id" /> <br>
    <label>车牌</label><input type="type" name="car_number" /> <br>
    <label>车主</label><input type="type" name="host_name" /> <br>
    <label>联系电话</label><input type="type" name="phone" /> <br>
    <label>车位号</label><input type="type" name="parking_id" /> <br>
    <input type="submit" value="确认修改">
</form>
</body>
</html>
