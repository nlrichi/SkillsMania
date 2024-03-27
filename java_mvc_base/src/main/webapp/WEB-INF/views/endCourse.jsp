<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>End Course</title>
</head>
<body>
<h2>End Course</h2>
<p>Click the end button when once you have completed the course.</p>
<form action="/end-button" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="hidden" name="course" value="${course}" />
    <input type="submit" value="End Course">
</form>
</body>
</html>
