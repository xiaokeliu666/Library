<%--
  Created by IntelliJ IDEA.
  User: Shock
  Date: 2020/4/27
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
    <jsp:include page="template/header.jsp"/>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="color-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/book/updatebook" method="post">

    <input type="hidden" name="bookID" value="${QBooks.bookID}">
        <div class="form-group">
            <label>书籍名称:</label>
            <input type="text" name="bookName" class="form-control" value="${QBooks.bookName}">
        </div>
        <div class="form-group">
            <label>书籍数量:</label>
            <input type="text" name="bookCounts" class="form-control" value="${QBooks.bookCounts}">
        </div>
        <div class="form-group">
            <label>书籍描述:</label>
            <input type="text" name="detail" class="form-control "value="${QBooks.detail}">
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="修改">
        </div>
    </form>
</div>
</body>
</html>
