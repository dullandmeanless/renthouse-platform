<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: 子豪
  Date: 2021/10/6
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/input">返回</a><br>
车辆信息
<table>
    <tr>
        <td>&nbsp;车牌号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td>&nbsp;&nbsp;车主&nbsp;</td>
        <td>&nbsp;&nbsp;&nbsp;联系电话&nbsp;</td>
        <td>&nbsp;停车位</td>
    </tr>
</table>
<c:forEach items="${List}" var="carinfo">
    ${carinfo.car_number}&nbsp;&nbsp;&nbsp;&nbsp;
    ${carinfo.host_name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    ${carinfo.phone}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    ${carinfo.parking_id}&nbsp;&nbsp;&nbsp;&nbsp;
    <br>
</c:forEach>
<br> <a href="${pageContext.request.contextPath }/add">添加车辆信息</a>
<br> <a href="${pageContext.request.contextPath }/update">更新车辆信息</a>
<br> <a href="${pageContext.request.contextPath }/delete">删除车辆信息</a>
</body>
</html>
