<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Avatar Selection</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<div class="main-container"> <!-- Wrap your content in a main container for centering and padding -->
    <h2>Avatar Selection</h2>

    <!-- Display the current avatar if it exists -->
    <div class="current-avatar-section">
        <h3>Current Avatar</h3>
        <c:if test="${not empty currentAvatar}">
            <div class="current-avatar">
                <img src="${pageContext.request.contextPath}${currentAvatar.image}" alt="Current Avatar" />
                <p>${currentAvatar.name}</p>
            </div>
        </c:if>
        <c:if test="${empty currentAvatar}">
            <p>No avatar selected yet.</p>
        </c:if>
    </div>

    <h3>Available Avatars</h3>

    <!-- List of available avatars for selection -->
    <div class="avatar-container">
        <c:forEach var="avatar" items="${avatars}">
            <div class="avatar" onclick="location.href='${pageContext.request.contextPath}/avatars/select/${avatar.id}'" style="cursor:pointer;">
                <img src="${pageContext.request.contextPath}${avatar.image}" alt="${avatar.name}" />
                <h4>${avatar.name}</h4>
                <p>${avatar.description}</p>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
