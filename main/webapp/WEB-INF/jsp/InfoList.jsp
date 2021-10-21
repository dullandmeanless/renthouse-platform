<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
停车场信息<br>
<c:forEach items="${InfoList}" var="ParkingInfo">
    ${ParkingInfo.parking_id}&nbsp;&nbsp;&nbsp;&nbsp;
    ${ParkingInfo.parking_status}&nbsp;&nbsp;&nbsp;&nbsp;
   <br>
</c:forEach>
<br>

</body>
</html>