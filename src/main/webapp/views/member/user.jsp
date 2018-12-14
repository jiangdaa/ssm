<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/13
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/header.jsp" %>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="#">系统管理</a>
        <a href="#"><cite>用户管理</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <table class="layui-hide" id="UserMember" lay-filter="UserMemberFilter"></table>
</div>


<script type="text/html" id="TableHeaderTool">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="AddUserEvent">新增用户</button>
    </div>
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
    layui.use('table', function () {
        var table = layui.table;
        table.render({
            elem: '#UserMember',
            url: '/member/getUserList',
            toolbar: '#TableHeaderTool',
            title: '用户数据表',
            height: 700,
            size: 'sm',
            cols: [[
                {type: 'checkbox', fixed: 'left'},
                {field: 'member_id', title: 'ID', width: 80, fixed: 'left', unresize: true, sort: true},
                {field: 'username', title: '用户名', width: 120, edit: 'text'},
                {field: 'role_ids', title: '用户角色', width: 100, sort: true},
                {field: 'create_time', title: '创建时间', width: 120},
                {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150}
            ]],
            page: true
        });

        //头工具栏事件
        table.on('toolbar(UserMemberFilter)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'AddUserEvent':
                    var data = checkStatus.data;
                    layer.open({
                        title: "新增用户",
                        type: 2,
                        content: ['/member/action/add', 'no'],
                        area: ['600px','600px'],
                        maxmin: true
                    });
                    break;
            }
        });

        //监听行工具事件
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            //console.log(obj)
            if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                layer.prompt({
                    formType: 2
                    , value: data.email
                }, function (value, index) {
                    obj.update({
                        email: value
                    });
                    layer.close(index);
                });
            }
        });
    });
</script>
<%@include file="../common/footer.jsp" %>
