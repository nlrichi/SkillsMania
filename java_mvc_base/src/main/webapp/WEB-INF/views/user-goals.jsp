<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Goals</title>
</head>
<body>
<h2>Your Goals</h2>
<table>
    <tr>
        <th>Description</th>
        <th>Type</th>
        <th>Target Count</th>
        <th>Status</th>
    </tr>
    <c:forEach items="${userGoals}" var="userGoal">
        <tr>
            <td>${userGoal.goal.description}</td>
            <td>${userGoal.goal.goalType}</td>
            <td>${userGoal.goal.targetCount}</td>
            <td>${userGoal.completed ? 'Completed' : 'In Progress'}</td>
        </tr>
    </c:forEach>
</table>


