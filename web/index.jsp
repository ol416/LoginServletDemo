<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>登录界面</title>
    <script src="js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
</head>
<body>
<div id="loginpanelwrap">
    <div>
        <div>登录</div>
    </div>
    <form action="/register" method="post">
        <div>
            <div>
                <label>用户名:</label>
                <input type="text" name="username" />
            </div>
        </div>
        <div>
            <label>密码：</label>
            <input type="password" name="password" />
        </div>
        <div>
            <label>性别：</label>
            <input type="text" name="gender" />
        </div>
        <div>
            <label>手机号：</label>
            <input type="text" name="telephone" />
        </div>
        <div>
            <label>邮箱：</label>
            <input type="text" name="email" />
        </div>
        <div>
            <label>个人简介：</label>
            <input type="text" name="introduction" />
        </div>
        <div>
            <label>验证码:</label>
            <input type="text" name="validateCode"/>
            <img id="validationCode_img"  src="validateCode">
        </div>
        <div>
            <span></span>
            <input type="submit" id="loginform_submit" value="登录" />
        </div>
    </form>
</div>
</body>
</html>