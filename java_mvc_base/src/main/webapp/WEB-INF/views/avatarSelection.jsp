<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Avatar Selection</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<h2>Select Your Avatar</h2>
<div class="avatar-container">
    <c:forEach var="avatar" items="${avatars}">
        <div class="avatar">
            <img src="${pageContext.request.contextPath}${avatar.image}" alt="${avatar.name}" />
            <h3>${avatar.name}</h3>
            <p>${avatar.description}</p>
        </div>
    </c:forEach>
</div>
</body>
</html>

