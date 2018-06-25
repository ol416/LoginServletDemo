<%--
  Created by IntelliJ IDEA.
  User: yan11
  Date: 2018/6/7
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"  contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>注册</title>
    <%--<script type="text/javascript" src="js/bootstrap.min.js"></script>--%>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="js/register.js"></script>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
    <form class="form-horizontal register" action="/register" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label class="col-lg-2 control-label" for="username">用户名<small>(必填)</small></label>
            <div class="col-lg-4">
                <input class="form-control" id="username" name="username" type="text"  />
                <span class="help-block">用户以字母、数字、下划线开头，切能以数字开头！</span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-lg-2 control-label" for="password">密码<small>(必填)</small></label>
            <div class="col-lg-4">
                <input class="form-control" id="password" name="password" type="password"/>
            </div>
            <div class="col-lg-5">
                <div class="btn-group" role="group">
                    <button type="button" class="btn btn-success active">密文</button>
                    <button type="button" class="btn btn-default">明文</button>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-lg-2 control-label" for="phone">电话<small>(必填)</small></label>
            <div class="col-lg-4">
                <input class="form-control" id="phone" name="phone" type="text"/>
                <span class="help-block">电话号码为11位</span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-lg-2 control-label" for="email">邮箱<small>(必填)</small></label>
            <div class="col-lg-4">
                <input class="form-control" id="email" name="email" type="text"/>
                <span class="help-block">邮箱格式xxx123456@qq.com</span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-lg-2 control-label" for="introduction">个人简介<small>(必填)</small></label>
            <div class="col-lg-4">
                <textarea class="form-control" rows="5" id="introduction" name="introduction" type="text"></textarea>
            </div>
        </div>
        <div class="form-group">
            <label class="col-lg-2 control-label" for="validateCode_img">验证码<small>(必填)</small></label>
                <div class="col-lg-4">
                    <input class="form-control" id="validateCode" name="validateCode" type="text"/>
                    <img id="validateCode_img" src="validateCode">
                </div>
        </div>
        </div>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-4">
                <button id="register" class="btn btn-primary btn-block" type="button">注册</button>
            </div>
        </div>
    </form>
</body>
</html>
