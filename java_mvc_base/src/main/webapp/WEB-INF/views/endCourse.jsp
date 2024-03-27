<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>End Course</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/start_n_end.css">
</head>
<body>
<div class="content">
    <h2>End Course</h2>
    <p>Click the end button when once you have completed the course.</p>
    <form  action="/end-button" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input type="hidden" name="course" value="${course}" />
        <input class="btn" type="submit" value="End Course">
    </form>
</div>

</body>
</html>
