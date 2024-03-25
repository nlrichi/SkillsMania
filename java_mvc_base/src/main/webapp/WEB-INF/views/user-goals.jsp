<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Goals</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
            color: #333;
        }
        h2 {
            color: #444;
        }
        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
        }
        th, td {
            text-align: left;
            padding: 8px;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        .completed {
            color: green;
        }
        .in-progress {
            color: orange;
        }
        .back-link {
            display: inline-block;
            margin-top: 20px;
            padding: 10px;
            background-color: #ddd;
            color: #333;
            text-decoration: none;
            border-radius: 5px;
            margin-right: 10px;
        }
        .back-link:hover {
            background-color: #ccc;
        }
    </style>
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
            <td>${userGoal.progress}/${userGoal.goal.targetCount}</td>
            <td class="${userGoal.isCompleted ? 'completed' : 'in-progress'}">
                    ${userGoal.isCompleted ? 'Completed' : 'In Progress'}
            </td>
        </tr>
    </c:forEach>
</table>
<a href="http://localhost:8080/dashboard" class="back-link">Back to Dashboard</a>
<a href="http://localhost:8080/goals/list" class="back-link">Back to List Goals</a>
</body>
</html>



