<%--
  Created by IntelliJ IDEA.
  User: 子豪
  Date: 2021/10/8
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
时间信息<br>
<input type="button" value="获取输入编号的停车时间差" id="std">
<label>停车编号</label><input type="type" id="parking_id" /> <br>
<label id="time"></label>
<br>
<form action="http://localhost:8080/getStartTime" method="post">
    <label>车位编号</label><input type="type" name="parking_id" /> <br>
    <input type="submit" value="确认">
</form>
<form action="http://localhost:8080/getEndTime" method="post">
    <label>车位编号</label><input type="type" name="parking_id" /> <br>
    <input type="submit" value="确认">
</form>
<form action="http://localhost:8080/pay" method="post">
    <label>车位编号</label><input type="type" name="parking_id" /> <br>
    <input type="submit" value="缴费">
</form>
</body>
</html>
