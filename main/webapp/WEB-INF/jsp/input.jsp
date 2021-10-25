<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/select" method="post">
    <input type="submit" value="查看停车场信息"/>
</form>
<form action="${pageContext.request.contextPath }/selectCIALL" method="post">
    <input type="submit" value="查看车辆信息信息"/>
</form>
<form action="${pageContext.request.contextPath }/selectallfare" method="post">
    <input type="submit" value="查看费用信息"/>
</form>
<form action="${pageContext.request.contextPath }/selectAllhistory" method="post">
    <input type="submit" value="查看历史信息"/>
</form>
    <br>
<br> <a href="${pageContext.request.contextPath }/park">查看空闲车位</a>
<br> <a href="${pageContext.request.contextPath }/add">添加信息</a>
<br> <a href="${pageContext.request.contextPath }/update">更新信息</a>
<br> <a href="${pageContext.request.contextPath }/delete">删除信息</a>
<br>
<form action="${pageContext.request.contextPath }/selectPLStatusById" method="post">
    <label>编号</label><input type="type" name="parking_id" />
    <input type="submit" value="停车场编号查询车位状态">
</form><br>
<form action="${pageContext.request.contextPath }/getfareById" method="post">
    <label>编号</label><input type="type" name="parking_id" /> <br>
    <input type="submit" value="根据车位号查询费用">
</form>
<br>
<form action="${pageContext.request.contextPath }/getParkingIdByUserId" method="post">
    <label>编号</label><input type="type" name="user_id" /> <br>
    <input type="submit" value="根据用户号查询车位号">
</form>
<br>
    <form action="${pageContext.request.contextPath }/selecthistoryBycarnumber" method="post">
        <label>编号</label><input type="type" name="car_number" /> <br>
        <input type="submit" value="查看"/>
    </form>
<%--<form action="${pageContext.request.contextPath }/selectPLStatusById" method="post">--%>
<%--    <label>编号</label><input type="type" name="parking_id" /> <br>--%>
<%--    <input type="submit" value="停车场编号查询车位状态">--%>
<%--</form>--%>


</body>
</html>
