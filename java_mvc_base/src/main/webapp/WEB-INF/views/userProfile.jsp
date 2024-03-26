<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            background-image: url('https://www.toptal.com/designers/subtlepatterns/patterns/memphis-mini.png');
            margin: 0;
            padding: 20px;
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .container {
            width: 100%;
            max-width: 800px;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center; /* Center everything in the container */
        }
        ul {
            list-style: none;
            padding: 0;
        }
        ul li {
            display: flex;
            justify-content: center; /* Center the list items */
            align-items: center;
            padding-bottom: 10px;
        }
        .badge-icon {
            margin-right: 15px;
            border-radius: 50%;
            width: 50px;
            height: 50px;
            object-fit: cover;
        }
        strong {
            margin-right: 5px;
        }
        li:not(:last-child) {
            border-bottom: 1px solid #eee;
            padding-bottom: 10px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>User Profile</h2>
    <!-- Display User Information -->
    <h3>User Information:</h3>
    <p>Username: ${user.username}</p>
    <!-- Display Badges Earned -->
    <h3>Badges Earned:</h3>
    <ul>

        <li>
            <c:if test="${user.badge != null}"> <!-- If statement -->
                <img src="/images/badge.jpeg" alt="${user.badge.name}" class="badge-icon"/>
                <strong>${user.badge.name}</strong> - ${user.badge.description}
            </c:if>
        </li>

    </ul>
</div>
</body>
</html>
