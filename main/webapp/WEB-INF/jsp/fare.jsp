<%--
  Created by IntelliJ IDEA.
  User: 子豪
  Date: 2021/10/8
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
    <script>
        var v=document.getElementById("parking_id")
        $(function (){
            $("#std").click(function(){
                $.post({
                    url:"${pageContext.request.contextPath}/selectTimeDiff",
                    data:{"parking_id":$('#parking_id').val()},
                    success:function(data){
                      $("#time").html(data);
                    }
                })
            })
        })
    </script>
</head>
<body>
 <a href="${pageContext.request.contextPath}/input">返回</a><br>
费用信息
 <table>
     <tr>
         <td>停车号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
         <td>入库时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
         <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出库时间&nbsp;&nbsp;&nbsp;&nbsp;</td>
         <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;费用</td>
     </tr>
 </table>
<c:forEach items="${InfoList}" var="fare">
   ${fare.parking_id}&nbsp;&nbsp;
    ${fare.starttime}&nbsp;
    ${fare.endtime}&nbsp;
   ${fare.fare}
    <br>
</c:forEach>
<br>
时间信息<br>
<input type="button" value="获取输入编号的停车时间差" id="std">
<label>车位编号</label><input type="type" id="parking_id" /> <br>
<label id="time"></label>
<br>
<form action="http://localhost:8080/getStartTime" method="post">
    <label>根据车位编号查询入库时间</label><input type="type" name="parking_id" /> <br>
    <input type="submit" value="确认">
</form>
<form action="http://localhost:8080/getEndTime" method="post">
    <label>根据车位编号查询出库时间</label><input type="type" name="parking_id" /> <br>
    <input type="submit" value="确认">
</form>
<form action="http://localhost:8080/pay" method="post">
    <label>根据车位编号查询费用</label><input type="type" name="parking_id" /> <br>
    <input type="submit" value="缴费">
</form>
 <br> <a href="${pageContext.request.contextPath }/add">添加费用信息</a>
 <br> <a href="${pageContext.request.contextPath }/update">更新费用信息</a>
 <br> <a href="${pageContext.request.contextPath }/delete">删除费用信息</a>
</body>
</html>
