<%--
  Created by IntelliJ IDEA.
  User: 子豪
  Date: 2021/10/23
  Time: 23:32
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
历史信息
<table>
    <tr>
        <td>&nbsp;订单号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td>车牌&nbsp;</td>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;车主&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系电话&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td>&nbsp;入库时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出库时间</td>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;费用</td>
    </tr>
</table>
<c:forEach items="${List}" var="history">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${history.order}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    ${history.car_number}&nbsp;&nbsp;&nbsp;&nbsp;
    ${history.host_name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    ${history.phone}&nbsp;&nbsp;&nbsp;&nbsp;
    ${history.starttime}&nbsp;&nbsp;&nbsp;
    ${history.endtime}&nbsp;&nbsp;&nbsp;
    ${history.fare}&nbsp;&nbsp;&nbsp;
    <br>
</c:forEach>
</body>
</html>
