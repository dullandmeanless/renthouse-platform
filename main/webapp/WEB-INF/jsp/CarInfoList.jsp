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
车辆信息<br>
<c:forEach items="${CarInfoList}" var="carinfo">
    ${carinfo.car_number}&nbsp;&nbsp;&nbsp;&nbsp;
    ${carinfo.host_name}&nbsp;&nbsp;&nbsp;&nbsp;
    ${carinfo.phone}&nbsp;&nbsp;&nbsp;&nbsp;
    ${carinfo.parking_id}&nbsp;&nbsp;&nbsp;&nbsp;
    <br>
</c:forEach>
<br>
</body>
</html>
