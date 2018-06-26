$(document).ready(function() {
    function btn_waring_show(state){
        if(state === true){
            $('#register').addClass('btn-warning');
        }else if(state === false){
            $('#register').removeClass('btn-warning');
        }
    }
    /* 明文/密文 */
    $('.btn-group .btn:first').click(function () {
        $(this).removeClass('btn-default').addClass('btn-success active');
        $('.btn-group .btn:last').removeClass('btn-success active').addClass('btn-default');
        $('#password')[0].type = 'password';
    });

    $('.btn-group .btn:last').click(function () {
        $(this).removeClass('btn-default').addClass('btn-success active');
        $('.btn-group .btn:first').removeClass('btn-success active').addClass('btn-default');
        $('#password')[0].type = 'text';
    });

    /* 注册验证 */
// 用户名验证
    $('#username').focus(function () {
        $(this).on('input', function () {
            if ($.isNumeric($(this).val().substr(0, 1))) {  // 判断第一个字符是不是数字
                $(this).parents('.form-group').addClass('has-error');
                btn_waring_show(true);
            } else {
                $(this).parents('.form-group').removeClass('has-error');
                btn_waring_show(false);
            }
        });
    }).blur(function () {
        if ($(this).val().length === 0) {
            $(this).parents('.form-group').addClass('has-error');
            btn_waring_show(true);
        }
    });


// 密码验证
    $('#password').focus(function () {
        $(this).on('input', function () {
            if ($(this).val().length === 0) {
                $(this).parents('.form-group').addClass('has-error');
                btn_waring_show(true);
            } else {
                $(this).parents('.form-group').removeClass('has-error');
                btn_waring_show(false);
            }
        });
    }).blur(function () {
        if ($(this).val().length === 0) {
            $(this).parents('.form-group').addClass('has-error');
            btn_waring_show(true);
        }
    });

    //确认密码
    $('#confirm_password').focus(function () {
        $(this).on('input', function () {
            if ($(this).val().length === 0) {
                $(this).parents('.form-group').addClass('has-error');
                btn_waring_show(true);
            } else if(!($("#password").val() === $(this).val())){
                $(this).parents('.form-group').addClass('has-error');
                btn_waring_show(true);
            }else {
                $(this).parents('.form-group').removeClass('has-error');
                btn_waring_show(false);
            }
        });
    }).blur(function () {
        if ($(this).val().length === 0) {
            $(this).parents('.form-group').addClass('has-error');
            btn_waring_show(true);
        }
    });
// 电话
    $('#phone').focus(function () {
        $(this).on('input', function () {
            if ($(this).val().length === 0) {
                $(this).parents('.form-group').addClass('has-error');
                btn_waring_show(true);
            } else {
                $(this).parents('.form-group').removeClass('has-error');
                btn_waring_show(false);
            }
        });
    }).blur(function () {
        if ($(this).val().length !== 11) {
            $(this).parents('.form-group').addClass('has-error');
            btn_waring_show(true);
        }
    });

// 邮箱
    $('#email').focus(function () {
        $(this).on('input', function () {
            if ($(this).val().length === 0) {
                $(this).parents('.form-group').addClass('has-error');
                btn_waring_show(true);
            } else {
                $(this).parents('.form-group').removeClass('has-error');
                btn_waring_show(false);
            }
        });
    }).blur(function () {
        if (!$(this).val().match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) {
            $(this).parents('.form-group').addClass('has-error');
            btn_waring_show(true);
        }
    });
    $('.btn-primary').click(function () {
        $('.register input:not("[type=file]")').each(function () {
            if ($(this).val().length === 0) {
                $(this).parents('.form-group').addClass('has-error');
                btn_waring_show(true);
            }
        });

        if ($('.register .has-error').length > 0) {
            console.log($('.has-error'));
            return false;
        } else {
            $(this).parents('form').submit();
        }
    });
});