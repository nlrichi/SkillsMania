<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <base href="${pageContext.request.contextPath}">
    <link rel="stylesheet" href="https://fonts.google.com/specimen/IBM+Plex+Sans">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dashboard/dashboard.css">
    <script src="${pageContext.request.contextPath}/dashboard/dashboard.js"></script>
    <title>Your Dashboard</title>
</head>
<body>
    <div class="header">
        <div><img src="/img/SkillsMania Logo BIG.png" id="logo"></div>
        <div><h1>Track your SkillsBuild Progress</h1></div>
        <br>
        <br>
    </div>

    <!-- Navigation bar-->
    <div class="navbar">
        <ul>
            <div>
                <!--username display, leaderboard and streaks page-->
                <li>Hello, <strong>${principal_username}</strong></li>
                <a href="http://localhost:8080/leaderboard"><li>Leaderboard</li></a>
                <li>Current Streak ${streak}</li>
                <!--Avatar display and log out -->
                <div class="rightside">
                    <a href=http://localhost:8080/avatars><li>Your Avatar</li></a>
                    <a href="http://localhost:8080/logout"><li>Log out</li></a>
                </div>
            </div>
        </ul>
    </div>

    <br>

    <div class="dropdown">
        <button onclick="filterBy('popular')" class="filter-btn">Filter by popularity</button>
    </div>
    <!-- Course table and heading-->
    <div id="courses" class="courses_container">
        <h2 style="align-self: center">Available Courses</h2>

        <div class="course_cards">
            <c:forEach items="${courses}" var="course">
                <div class="polaroid">
                    <a href="${course.link}"><img class="CoursePic" src="${course.pic}"/></a>
                    <div class="container">
                        <p class="course_card_text">${course.courseName}</p>
                        <p class="popularity_tag">(taken by ${course.getPopularity()} users)</p>
                    </div>
                </div>
            </c:forEach>



        </div>
    </div>
</body>
</html>
