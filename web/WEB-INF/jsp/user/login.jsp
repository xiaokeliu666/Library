<%--
  Created by IntelliJ IDEA.
  User: Shock
  Date: 2020/5/2
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <link href="favicon.ico" rel="shortcut icon" />
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
</head>
<body style=" background-color: aliceblue; background-size: 100%;">


<div class="modal-dialog" style="margin-top: 10%;">
    <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title text-center" id="myModalLabel">登录</h4>
        </div>
       <form action="${pageContext.request.contextPath}/login" method="post" >
        <div class="modal-body" id = "model-body">

            <div class="form-group">
                <input type="text" class="form-control"placeholder="用户名" name="userId">
            </div>

            <div class="form-group">
                <input type="password" class="form-control" placeholder="密码" name="password">
            </div>

        </div>
        <div class="modal-footer">
            <div class="form-group">
                <button type="submit" class="btn btn-primary form-control">登录</button>
            </div>
            <div class="form-group">
                <button type="" class="btn btn-default form-control">注册</button>
            </div>
        </div>
       </form>

    </div><!-- /.modal-content -->

</div><!-- /.modal -->

</body>
</html>

