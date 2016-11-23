<%--
  Created by IntelliJ IDEA.
  User: lizhi
  Date: 2016/11/23
  Time: 下午3:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath(); %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button id="ajaxBtn" value="点我试试~">点我试试~</button>
</body>
<script src="jquery.js"></script>
<script>
    $("#ajaxBtn").click(function () {
        $.ajax({
            url: "<%=path%>/AjaxServlet",
            type: 'get',
            cache: true,
            success: function (data) {
                alert(data);
            }
        });
    })
</script>
</html>
