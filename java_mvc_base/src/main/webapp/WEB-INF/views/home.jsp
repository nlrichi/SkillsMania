<!DOCTYPE html>
<html lang="en">
<!-- This HTML page is the first page that the user sees after heading to localhost:8080 -->
<!-- This code helps to load the image into the JSP -->
<base href="${pageContext.request.contextPath}">
<head>
    <meta charset="UTF-8">
</head>
<body>
<!-- Image of SkillsMania Logo -->
<img src="/img/SkillsMania Logo BIG.png" alt="SkillsMania Logo" style="width:280px;height:100px;">>
<h2>Welcome to SkillsMania, Please login using the link below :</h2>
<!-- Login Button -->
<a href="securedPage">Login</a>
</body>
</html>