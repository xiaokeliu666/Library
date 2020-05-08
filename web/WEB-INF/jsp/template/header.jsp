<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Shock
  Date: 2020/5/3
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<%--    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->--%>
<%--    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>--%>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<%--    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>--%>

    <script type="text/javascript">
        $(document).ready(function() {
            $('dropdown-toggle').dropdown()
        });
    </script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/book/allBook">图书馆</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">书库<span class="sr-only">(current)</span></a></li>
                <li><a href="#">座位预定</a></li>
                <li class="dropdown">
<%--                    <button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">个人中心<span class="caret"></span></button>--%>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">个人中心<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">订阅</a></li>
                        <li><a href="#">待还</a></li>
                        <li><a href="#">预定</a></li>
<%--                        <li role="separator" class="divider"></li>--%>
<%--                        <li><a href="#">Separated link</a></li>--%>
<%--                        <li role="separator" class="divider"></li>--%>
<%--                        <li><a href="#">One more separated link</a></li>--%>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
<%--                <li><a href="#">Link</a></li>--%>
<c:choose>
    <c:when test="${sessionScope.userId!=null}">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${sessionScope.userId} <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">个人设置</a></li>
                        <li><a href="${pageContext.request.contextPath}/logout">登出</a></li>
<%--                        <li role="separator" class="divider"></li>--%>
<%--                        <li><a href="#">Separated link</a></li>--%>
                    </ul>
                </li>
    </c:when>
    <c:when test="${sessionScope.userId==null}">

<%--                <c:if test="${sessionScope.userId==null}">--%>

                   <li> <a href="${pageContext.request.contextPath}/login">登录</a></li>
    </c:when>
<%--                </c:if>--%>
</c:choose>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
</body>
</html>
