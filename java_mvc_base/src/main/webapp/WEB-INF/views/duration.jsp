<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Course Result</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/start_n_end.css">
</head>
<body>
<div class="content">
    <h2>Course Result</h2>
    <p><strong>Course:</strong> ${course}</p>
    <p><strong>Start Time:</strong> ${startTime}</p> <!-- Formatted ISO instant string -->
    <p><strong>End Time:</strong> ${endTime}</p>   <!-- Formatted ISO instant string -->
    <p><strong>Duration:</strong> ${duration} seconds</p> <!-- Duration in seconds -->
    <p><strong>-----------------------------------------</p>
    <a  href="http://localhost:8080/dashboard"><button class="btn">Back to Dashboard</button></a>
</div>
<!-- Back to dashboard link -->
</body>
</html>



