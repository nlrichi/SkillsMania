<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Course Result</title>
</head>
<body>
<h2>Course Result</h2>
<p><strong>Course:</strong> ${session.getAttribute("course")}</p>
<p><strong>Start Time:</strong> ${session.getAttribute("startTime")}</p>
<p><strong>End Time:</strong> ${session.getAttribute("endTime")}</p>
<p><strong>Duration:</strong> ${session.getAttribute("duration")} seconds</p>
</body>
</html>
