<%--
  Created by IntelliJ IDEA.
  User: GOUC003
  Date: 2019/4/4
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
用户列表：
  <c:forEach items="${userList}">

  </c:forEach>
  </body>
</html>
