<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <%@ include file="/WEB-INF/jsp/fragmentos/bootstrap.jspf" %>
</head>
<body class="bg-light">
    <%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>
    <a href="hello-servlet">Hello Servlet</a>
    <%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>
</html>