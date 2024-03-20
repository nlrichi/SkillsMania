<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Available Goals</title>
</head>
<body>
<h2>Available Goals</h2>
<c:forEach var="goal" items="${goals}">
    <form action="/users/setGoal" method="post">
        <input type="hidden" name="goalId" value="${goal.goalId}" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <p>${goal.description} - Reward: ${goal.xpReward} XP
            <button type="submit">Select</button>
        </p>
    </form>
</c:forEach>
</body>
</html>


