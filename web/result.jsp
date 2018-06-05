<%--
  Created by IntelliJ IDEA.
  User: yan11
  Date: 2018/4/2
  Time: 0:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>结果页面</title>
</head>
<body>
    验证码：${sessionScope.code}<br>
    登录信息：${sessionScope.login}<br>
    sessionID：${pageContext.session.id}
</body>
</html>
