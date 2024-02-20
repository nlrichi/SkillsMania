<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Start Course</title>
</head>
<body>
<h2>Start Course</h2>
<p>Click the start button when you're ready to start.</p>
<form action="/start-button" method="post">
    <input type = "hidden" name="course" value="${param.course}" />
    <input type="submit" value="Start Course">
</form>
</body>
</html>