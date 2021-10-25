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
删除停车场信息
<form action="${pageContext.request.contextPath }/deletePLinfo" method="post">
    <label>编号</label><input type="type" name="parking_id" /> <br>
    <input type="submit" value="确认删除"/>
</form><br>
删除车辆信息
<form action="${pageContext.request.contextPath }/deleteCI" method="post">
    <label>编号</label><input type="type" name="user_id" /> <br>
    <input type="submit" value="确认删除"/>
</form>
</body>
</html>
