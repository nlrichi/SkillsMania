

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Start Course</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/start_n_end.css">
    <script type="text/javascript">
        function startCourse(event) {
            event.preventDefault(); // Prevent the form submitting traditionally

            var course = document.getElementById('course').value;
            var courseUrl = "https://skillsbuild.org/adult-learners/explore-learning/" + course;

            // Open endCourse.jsp in a new tab
            window.open('/end-course', '_blank');

            // Submit the form to the server
            var form = document.getElementById('courseForm');
            form.submit();

            // Redirect the current tab to the course URL after a short delay
            setTimeout(function() {
                window.location.href = courseUrl;
            }, 150);
        }
    </script>
</head>
<body>
<div class="content">
    <h2>Start Course</h2>
    <p>Click the start button when you're ready to start.</p>
    <form  id="courseForm" action="/start-button" method="post" onsubmit="startCourse(event);">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input type="hidden" id="course" name="course" value="${param.course}" />
        <input class="btn" type="submit" value="Start Course">

    </form>
    <a href="${pageContext.request.contextPath}/dashboard">
        <button class="btn">Back to dashboard</button>
    </a>
</div>

</body>
</html>


