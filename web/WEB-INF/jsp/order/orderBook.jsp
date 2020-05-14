<%--
  Created by IntelliJ IDEA.
  User: Shock
  Date: 2020/5/8
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订阅详情</title>
    <jsp:include page="../template/header.jsp"/>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="color-md-12 column">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form action="${pageContext.request.contextPath}/order/confirm?orderId=${order}&&bookName=${name}&&userId=${user}&&borrowDate=${start}&&returnDate=${end}" method="post">
                    <table class="table table-hover table-striped" id="order">
                        订单号:
                        <tr name="order">
                            <input type="text" disabled="disabled" name="orderId" value=${order}>
                        </tr>
                        <thead>
                        <tr>
                            <th>书籍名称</th>
                            <th>借书人</th>
                            <th>起始日期</th>
                            <th>终止日期</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><input type="text" disabled="disabled" name="bookName" value=${name}></td>
                            <td><input type="text" disabled="disabled" name="userId" value=${user}></td>
                            <td><input type="text" disabled="disabled" name="borrowDate" value=${start}></td>
                            <td><input type="text" disabled="disabled" name="returnDate" value=${end}></td>
                        </tr>
                        </tbody>
                    </table>
                        <div class="form-group">
                            <input type="submit" class="form-control" value="确定">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%--<script type="text/javascript">--%>
<%--    // function sendAjax(){--%>
<%--        var obj = {--%>
<%--            "orderId": ${order},--%>
<%--            "bookName": ${name},--%>
<%--            "userId": ${user},--%>
<%--            "borrowDate": ${start},--%>
<%--            "returnDate": ${end},--%>
<%--            "status": "processing"--%>
<%--        };--%>
<%--        $.ajax({--%>
<%--            type:"POST"--%>
<%--            ,url:"${pageContext.request.contextPath}/order/confirm"--%>
<%--            ,data:JSON.stringify(obj)--%>
<%--            ,headers: {--%>
<%--                'Accept':'application/json',--%>
<%--                'Content-Type': 'application/json'--%>
<%--            }--%>
<%--            // ,contentType:"application/json;charset=utf-8"--%>
<%--            ,dataType:"json"--%>
<%--            ,success: function(data) {--%>
<%--                console.log("success...");--%>
<%--            }--%>
<%--            ,error: function(data) {--%>
<%--                console.log("error...");--%>
<%--            }--%>
<%--        });--%>
<%--    // }--%>
<%--</script>--%>

</body>
</html>
