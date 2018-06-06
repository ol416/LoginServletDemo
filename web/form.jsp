<%--
  Created by IntelliJ IDEA.
  User: yan11
  Date: 2018/6/7
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
    <form class="form-horizontal register" action="{:U('handleRegister')}" method="post" enctype="multipart/form-data">
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
            <label class="col-lg-2 control-label" for="portrait">头像</label>
            <div class="col-lg-4">
                <input class="form-control" id="portrait" name="portrait" type="file" />
                <img id="showPortrait" src="" alt=""/>
                <span class="help-block">支持上传GIF,JPG,PNG图片，尺寸为70*70</span>
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
            <div class="col-lg-offset-2 col-lg-4">
                <button class="btn btn-primary btn-block" type="button">注册</button>
            </div>
        </div>
    </form>
<script type="text/javascript">
    /* 明文/密文 */
    $('.btn-group .btn:first').click(function() {
        $(this).removeClass('btn-default').addClass('btn-success active');
        $('.btn-group .btn:last').removeClass('btn-success active').addClass('btn-default');
        $('#password')[0].type = 'password';
    });

    $('.btn-group .btn:last').click(function() {
        $(this).removeClass('btn-default').addClass('btn-success active');
        $('.btn-group .btn:first').removeClass('btn-success active').addClass('btn-default');
        $('#password')[0].type = 'text';
    });

    /* 注册验证 */
    // 用户名验证
    $('#username').focus(function() {
        $(this).on('input', function() {
            if($.isNumeric($(this).val().substr(0, 1))) {  // 判断第一个字符是不是数字
                $(this).parents('.form-group').addClass('has-error');
            } else {
                $(this).parents('.form-group').removeClass('has-error');
            }
        });
    }).blur(function() {
        if($(this).val().length === 0) {
            $(this).parents('.form-group').addClass('has-error');
        }
    });


    // 密码验证
    $('#password').focus(function() {
        $(this).on('input', function() {
            if($(this).val().length === 0) {
                $(this).parents('.form-group').addClass('has-error');
            } else {
                $(this).parents('.form-group').removeClass('has-error');
            }
        });
    }).blur(function() {
        if($(this).val().length === 0) {
            $(this).parents('.form-group').addClass('has-error');
        }
    });

    // 电话
    $('#phone').focus(function() {
        $(this).on('input', function() {
            if($(this).val().length === 0) {
                $(this).parents('.form-group').addClass('has-error');
            } else {
                $(this).parents('.form-group').removeClass('has-error');
            }
        });
    }).blur(function() {
        if($(this).val().length !== 11) {
            $(this).parents('.form-group').addClass('has-error');
        }
    });

    // 邮箱
    $('#email').focus(function() {
        $(this).on('input', function() {
            if($(this).val().length === 0) {
                $(this).parents('.form-group').addClass('has-error');
            } else {
                $(this).parents('.form-group').removeClass('has-error');
            }
        });
    }).blur(function() {
        if(!$(this).val().match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) {
            $(this).parents('.form-group').addClass('has-error');
        }
    });
    $('.btn-primary').click(function() {
        $('.register input:not("[type=file]")').each(function() {
            if($(this).val().length === 0) {
                $(this).parents('.form-group').addClass('has-error');
            }
        });

        if($('.register .has-error').length > 0) {
            console.log($('.has-error'));
            return false;
        } else {
            $(this).parents('form').submit();
        }
    });
</script>
</body>
</html>
