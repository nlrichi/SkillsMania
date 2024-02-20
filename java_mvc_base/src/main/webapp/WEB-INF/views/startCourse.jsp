
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Start Course</title>
    <script type="text/javascript">
        function startCourse() {
            // Open endCourse.jsp in a new tab
            window.open('/end-course', '_blank');

            // Redirect the current tab to the external course URL
            // Construct the course URL dynamically based on the selected course
            var course = document.getElementById('course').value;
            var courseUrl = "https://skillsbuild.org/adult-learners/explore-learning/" + course;
            window.location.href = courseUrl;

            // Prevent the form from submitting normally
            return false;
        }
    </script>
</head>
<body>
<h2>Start Course</h2>
<p>Click the start button when you're ready to start.</p>
<form onsubmit="return startCourse();">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="hidden" id="course" name="course" value="${param.course}" />
    <input type="submit" value="Start Course">
</form>
</body>
</html>
