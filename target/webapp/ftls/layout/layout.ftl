<#assign base="http://localhost:8070" />
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><@block name="title">后台管理系统</@block></title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="${base}/css/font.css">
    <link rel="stylesheet" href="${base}/css/xadmin.css">
    <link rel="stylesheet" href="${base}/static/lib/layui/css/layui.css">
    <script type="text/javascript" charset="utf-8" src="${base}/lib/jquery.min.3.2.1.js"></script>
    <script type="text/javascript" charset="utf-8" src="${base}/static/lib/layui/layui.js"></script>
    <script type="text/javascript" charset="utf-8" src="${base}/js/xadmin.js"></script>
</head>
<body>
<@block name="content">
</@block>
</body>
</html>
