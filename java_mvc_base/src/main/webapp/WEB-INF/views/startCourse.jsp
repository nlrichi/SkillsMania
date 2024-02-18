<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Start Course</title>
</head>
<body>
<h2>Start Course</h2>
<form action="/start-course" method="post">
    <input type = "hidden" name="course" value="${param.course}" />
    <input type="submit" value="Start Course">
</form>
</body>
</html>