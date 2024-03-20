<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://fonts.google.com/specimen/IBM+Plex+Sans">
    <title>Your Dashboard</title>
    <style>
        html {
            font-family: ibm plex, sans-serif;
        }
        #logo {
            position: absolute;
            left: 0;
            top: 0;
            height: 113px;
            width:400px;
            text-align: left;
            padding: 10px 10px 10px;
        }


        .header {
            margin-bottom: 0;
            margin-top: 0;
            display: flex;
            justify-content: center;
            text-align: center;
            font-size: 30px;
            white-space: break-spaces;
        }

        .header h1 {
            margin-left: 420px;
        }

        /*Navigation bar */
        .navbar{
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #fd816d;
            color: ghostwhite;
        }

        li {
            float: left;
        }
        ul {
            display: flex;
            justify-content: space-between;
        }


        .navbar li {
            display: block;
            color: #000000;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;


        }
        .navbar li:hover {
            background-color: #fad56f;
            cursor: pointer;
        }

        .rightside li{
            display: flex;
            justify-content: flex-end;
        }

        /*CSS for course options/
        /*Size for pictures in polaroids. height:width ratio is 6:8 */
        .CoursePic{
            height: 300px;
            width: 400px;

        }

        /*Polaroid effect with hover effect */
        div.polaroid {
            width: 400px;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            text-align: center;
            transition: transform .2s;
        }

        .polaroid:hover {
            transform: scale(1.05);
        }

        div.container {
            padding: 10px;
        }


        #courses td {
            padding: 10px 10px 10px;
        }

        .progress-bar {
            width: 100%;
            height: 30px;
            background-color: #e0e0e0;
            border-radius: 5px;
            margin-bottom: 10px;
        }

        .progress {
            width: ${completionPercentage}%;
            height: 100%;
            background-color: #4CAF50;
            border-radius: 5px;
            text-align: center;
            line-height: 30px;
            color: white;
        }


    </style>
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
<!-- Progress bar -->
<div class="progress-bar">
    <div class="progress">
        <!-- Display completion percentage dynamically -->
        ${completionPercentage}%
    </div>
</div>

<br>

<!-- Course table and heading-->
<div id="courses">
    <h2>Available Courses</h2>
    <table>
        <tr>

            <td>
                <div class="polaroid">
                    <a href="/start-course-page?course=data-analyst"><img class="CoursePic" src="/img/DataAnalyst-00.webp"/></a>
                    <div class="container">
                        <p>Data Analyst</p>
                    </div>
                </div>
            </td>

            <td>
                <div class="polaroid">
                    <a href="/start-course-page?course=cybersecurity-analyst"><img class="CoursePic"  src="/img/ibmCyberSecurity.webp"/></a>
                    <div class="container">
                        <p>Cybersecurity</p>
                    </div>
                </div>
            </td>

            <td>
                <div class="polaroid">
                    <a href="/start-course-page?course=it-support-technician"> <img class="CoursePic"  src="/img/Information-Technology-Fundamentals-1.webp"/></a>
                    <div class="container">
                        <p>Information Technology</p>
                    </div>
                </div>
            </td>
        </tr>

        <tr>
            <td>
                <div class="polaroid">
                    <a href="/start-course-page?course=project-manager"><img class="CoursePic"  src="/img/ProjectManager-00.webp"/></a>
                    <div class="container">
                        <p>Project Management</p>
                    </div>
                </div>
            </td>

            <td>
                <div class="polaroid">
                    <a href="/start-course-page?course=web-developer"> <img class="CoursePic" src="/img/Web_Development_Fundamentals-1-1.webp"/></a>
                    <div class="container">
                        <p>Web Development</p>
                    </div>
                </div>
            </td>

        </tr>
    </table>
</div>
</body>
</html>
