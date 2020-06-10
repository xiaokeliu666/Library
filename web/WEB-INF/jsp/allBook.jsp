<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Users: Shock
  Date: 2020/4/27
  Time: 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>书籍展示</title>
<%--    BootStrap--%>
    <jsp:include page="template/header.jsp"/>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
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
            <div class="page-header">
                <h1>
                    <small>书籍列表 —— 显示所有书籍 </small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 column">
            <c:if test="${sessionScope.role=='admin'}">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增书籍</a>
                <form action="${pageContext.request.contextPath}/book/batchAdd" method="post" enctype="multipart/form-data">
                    选择文件:<input type="file" name="file">
                    <input type="submit" value="提交">
                </form>
            </c:if>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">显示书籍</a>
        </div>
        <div class="col-md-4 column">
            <form action="${pageContext.request.contextPath}/book/queryBook" method="post" style="float: right">
                <input type="text" class="form-inline" placeholder="请输入要查询的书籍名称" name="queryBookName">
                <input type="submit" value="查询" class="btn btn-primary">
            </form>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名称</th>
                    <th>书籍数量</th>
                    <th>书籍详情</th>
                    <th>操作</th>
                </tr>
                </thead>

<%--                书籍从数据库中查询出来，从这个list中遍历出来:foreach--%>
                <tbody>
                <c:forEach var="book" items="${list}">
                    <tr>
                        <td>${book.bookID}</td>
                        <td>${book.bookName}</td>
                        <td>${book.bookCounts}</td>
                        <td>${book.detail}</td>
                        <td>
                            <c:choose>
                                <c:when test="${sessionScope.role=='admin'}">
                                <a href="${pageContext.request.contextPath}/book/toUpdate?id=${book.bookID}">修改</a>
                                &nbsp;|&nbsp;
                                <a href="${pageContext.request.contextPath}/book/deleteBook/${book.bookID}">删除</a>
                                </c:when>
                                <c:when test="${sessionScope.role=='user'}">
                                    <c:if test="${book.bookCounts>0}">
                                        <a href="${pageContext.request.contextPath}/order/orderBook/${book.bookName}">借阅</a>
                                    </c:if>
                                    <c:if test="${book.bookCounts==0 && subList.contains(book.bookName)}">
                                        <a href="${pageContext.request.contextPath}/unsubscribe?name=${book.bookName}">取消订阅</a>
                                    </c:if>
                                    <c:if test="${book.bookCounts==0 && !subList.contains(book.bookName)}">
                                        <a href="${pageContext.request.contextPath}/subscribe?name=${book.bookName}">订阅</a>
                                    </c:if>
                                </c:when>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<ul class="pager">
    <li><a href="${pageContext.request.contextPath}/book/allBook/${page-1}">Previous</a></li>
    <li><a href="${pageContext.request.contextPath}/book/allBook/${page+1}">Next</a></li>
</ul>
</body>
<%--<script type="text/javascript">--%>
<%--    $('input[id=lefile]').change(function() {--%>
<%--        $('#photoCover').val($(this).val());--%>
<%--    });--%>
<%--</script>--%>
</html>
