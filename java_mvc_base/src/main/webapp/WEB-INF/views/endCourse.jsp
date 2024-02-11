<!-- start-tracking.jsp -->

<%@ page import="java.time.Instant" %>
<%@ page import="org.example.java_mvc_base.controller.DurationController" %>


<%
    DurationController controller = new DurationController();
%>

<html>
<body>
<form method="post">
    <input type="hidden" name="action" value="end">

    <button type="submit">End</button>
</form>

<% if (request.getParameter("action") != null &&
        request.getParameter("action").equals("end")) {

    // Save start time
    Instant startTime = Instant.now();
    controller.saveStartTime(startTime);
    // Redirect to external course URL
    response.sendRedirect(courseUrl);

} %>

</body>
</html>