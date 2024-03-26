<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Available Goals</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h2 {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border-radius: 5px;
        }
        form {
            background-color: white;
            padding: 15px;
            margin-bottom: 10px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        p {
            margin: 0;
            color: #333;
        }
        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 5px;
        }
        .back-link {
            display: block;
            width: max-content;
            margin-top: 20px;
            padding: 10px;
            background-color: #e7e7e7;
            color: #333;
            text-decoration: none;
            border-radius: 5px;
            margin-right: 10px;
        }
        .back-link:hover {
            background-color: #d7d7d7;
        }
        .flash-message {
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid transparent;
            border-radius: 4px;
        }
        .success {
            color: #3c763d;
            background-color: #dff0d8;
            border-color: #d6e9c6;
        }
        .error {
            color: #a94442;
            background-color: #f2dede;
            border-color: #ebccd1;
        }
    </style>
</head>
<body>
<!-- Flash messages -->
<c:if test="${not empty error}">
    <div class="flash-message error">
            ${error}
    </div>
</c:if>
<c:if test="${not empty success}">
    <div class="flash-message success">
            ${success}
    </div>
</c:if>
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
<a href="http://localhost:8080/dashboard" class="back-link">Back to Dashboard</a>
<a href="http://localhost:8080/users/${username}/goals" class="back-link">Active Goals</a>
</body>
</html>



