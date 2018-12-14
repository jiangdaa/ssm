<@override name="content">
<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="/main">Ssm整合</a></div>
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe699;</i>
    </div>
    <ul class="layui-nav left fast-add" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">+新增</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a onclick="x_admin_show('资讯','http://www.baidu.com')"><i class="iconfont">&#xe6a2;</i>资讯</a></dd>
                <dd><a onclick="x_admin_show('图片','http://www.baidu.com')"><i class="iconfont">&#xe6a8;</i>图片</a></dd>
                <dd><a onclick="x_admin_show('用户','http://www.baidu.com')"><i class="iconfont">&#xe6b8;</i>用户</a></dd>
            </dl>
        </li>
    </ul>
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:void(0);">
                 <@shiro.principal property="name" />
            </a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a onclick="x_admin_show('个人信息','http://www.baidu.com')">个人信息</a></dd>
                <dd><a onclick="x_admin_show('切换帐号','http://www.baidu.com')">切换帐号</a></dd>
                <dd><a href="/logout">退出</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item to-index"><a href="/">前台首页</a></li>
    </ul>

</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<!-- 左侧菜单开始 -->
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">
            <#list menu as item>
                <li>
                    <a href="javascript:void(0);">
                        <i class="iconfont">${item.icon }</i>
                        <cite>${item.title }</cite>
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                    <#if item.childMenus?? >
                        <ul class="sub-menu">
                            <#list item.childMenus as cItem>
                            <li>
                                <a _href="${cItem.url }">
                                    <i class="iconfont">${cItem.icon }</i>
                                    <cite>${cItem.title }</cite>
                                    <#if !cItem.childMenus?? >
                                        <i class="iconfont nav_right">&#xe697;</i>
                                    </#if>
                                </a>
                                <#if !item.childMenus?? >
                                <ul class="sub-menu">
                                    <#list cItem.childMenus as ccItem>
                                        <li>
                                            <a _href="${ccItem.url }">
                                                <i class="iconfont">${ccItem.icon }</i>
                                                <cite>${ccItem.title }</cite>
                                            </a>
                                        </li>
                                    </#list>
                            </ul>
                            </#if>
                        </#list>
                    </#if>
            </#list>

        <#-- <c:forEach items="${menu }" var="item">
             <li>
                 <a href="javascript:void(0);">
                     <i class="iconfont">${item.icon }</i>
                     <cite>${item.title }</cite>
                     <i class="iconfont nav_right">&#xe697;</i>
                 </a>
                 <c:if test="${item.childMenus != null }">

                     <ul class="sub-menu">
                         <c:forEach items="${item.childMenus }" var="cItem">
                             <li>
                                 <a _href="${cItem.url }">
                                     <i class="iconfont">${cItem.icon }</i>
                                     <cite>${cItem.title }</cite>
                                     <c:if test="${cItem.childMenus  != null }">
                                         <i class="iconfont nav_right">&#xe697;</i>
                                     </c:if>
                                 </a>
                                 <c:if test="${cItem.childMenus  != null }">
                                     <ul class="sub-menu">
                                         <c:forEach items="${cItem.childMenus }" var="ccItem">
                                             <li>
                                                 <a _href="${ccItem.url }">
                                                     <i class="iconfont">${ccItem.icon }</i>
                                                     <cite>${ccItem.title }</cite>
                                                 </a>
                                             </li>
                                         </c:forEach>
                                     </ul>
                                 </c:if>
                             </li>
                         </c:forEach>
                     </ul>
                 </c:if>
             </li>
         </c:forEach>-->
        </ul>
    </div>
</div>
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='/home' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
        </div>
    </div>
</div>
<div class="page-content-bg"></div>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->
<!-- 底部开始 -->
<div class="footer">
    <div class="copyright">Copyright ©2017 x-admin v2.3 All Rights Reserved</div>
</div>
<!-- 底部结束 -->
</@override>
<@extends name="./layout/layout.ftl" />

