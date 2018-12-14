
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台登录-X-admin2.0</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="../../css/font.css">
    <link rel="stylesheet" href="../../css/xadmin.css">
    <script type="text/javascript" charset="utf-8" src="../../lib/jquery.min.3.2.1.js"></script>
    <script type="text/javascript" charset="utf-8" src="../../static/lib/layui/layui.js"></script>
    <script type="text/javascript" charset="utf-8" src="../../js/xadmin.js"></script>

</head>
<body class="login-bg">

<div class="login layui-anim layui-anim-up">
    <div class="message">x-admin2.0-管理登录</div>
    <div id="darkbannerwrap"></div>

    <form method="post" class="layui-form">
        <input name="username" placeholder="用户名" type="text" lay-verify="required" class="layui-input">
        <hr class="hr15">
        <input name="password" lay-verify="required" placeholder="密码" type="password" class="layui-input">
        <hr class="hr15">
        <input value="登录" lay-submit lay-filter="login" type="submit">
        <hr class="hr20">
    </form>
</div>

<script>
    $(function () {
        layui.use('form', function () {
            var form = layui.form;
            form.on('submit(login)', function (data) {

                $.post("/login/checkPassword", data.field, function (res) {
                    if (res.code == 1) {
                        layer.msg('登录成功!', function () {
                            location.href = '/main'
                        });
                    } else {
                        layer.msg(res.msg);
                    }
                });
                return false;
            });
        });
    })


</script>

</body>
</html>
