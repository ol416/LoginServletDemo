<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>注册测试</title>
</head>
<body>

<form id="form1" name="form1" method="post" action="testReg.do">
    <p>注册并发送欢迎邮件测试  </p>
    <p>姓名：
        <input type="text" id="username" name="username"/>
    </p>
    <p>E-mail:
        <input type="text" id="email" name="email"/>
    </p>
    <p>
        <input type="submit" value="提交" />
    </p>
</form>

</body>
</html>