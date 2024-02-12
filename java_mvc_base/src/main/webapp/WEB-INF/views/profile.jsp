<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<h2>User Profile</h2>
Hello, username <strong>${principal_username}</strong>
Email = <strong>${principal_email}</strong>

<p>
    Here are your details from your <a href="https://developer.okta.com/docs/api/resources/oidc.html#get-userinformation">Access Token</a>:
<table>
    <thead>
    <tr>
        <th>Claim</th>
        <th>Value</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="entry" items="${details}">
        <tr>
            <td>${entry.key}</td>
            <td>${entry.value}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>