<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Dashboard</title>
    <style>
        html {
            font-family: Helvetica;
        }
        #logo {
            position: absolute;
            left: 0;
            top: 0;
            height: 63px;
            width: 130px;
            text-align: left;
            padding: 10px;
        }
        .header {
            top: 0;
            display: flex;
            justify-content: center;
            text-align: center;
            font-size: 30px;
            white-space: break-spaces;
        }
        .navbar{
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: dodgerblue;
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
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        .navbar li:hover {
            background-color: mediumblue;
            cursor: pointer;
        }
        .userInfo li{
            float: right;
            text-align: right;
        }
        .CoursePic{
            height: 200px;
            width: 200px;
        }
        #courses table{
            border: #555555 1px solid;
        }

        #courses td {
            padding: 10px 10px 10px;
        }


    </style>
</head>
<body>
<div class="header">
    <a href="https://www.ibm.com/uk-en"><img src="img/IBMLogo.png" alt="IBM logo" id="logo"></a>
    <div><h1>Track your SkillsBuild Progress</h1></div>
    <br>
    <br>
</div>
<div class="navbar">
    <ul>
        <div>
            <li>Home</li>
            <li>Dashboard</li>
        </div>
        <div>
            <li class="userInfo">Login</li>
            <li class="userInfo">Sign up</li>
        </div>
    </ul>
</div>
<br>
<div id="courses">
    <h2>Available Courses</h2>
    <table>
        <tr>
            <td>
                <figure>
                    <a href="https://skillsbuild.org/adult-learners/explore-learning/data-analyst"><img class="CoursePic" src="img/DataAnalyst-00.webp"/></a>
                    <figcaption>Data </figcaption>
                </figure>
            </td>
            <td>
                <figure>
                    <a href="https://skillsbuild.org/adult-learners/explore-learning/cybersecurity-analyst"><img class="CoursePic"  src="img/ibmCyberSecurity.webp"/></a>
                    <figcaption>CyberSecurity</figcaption>
                </figure>
            </td>
            <td>
                <figure>
                    <a href="https://skillsbuild.org/adult-learners/explore-learning/it-support-technician"> <img class="CoursePic"  src="img/Information-Technology-Fundamentals-1.webp"/></a>
                    <figcaption>Information Technology</figcaption>
                </figure>
            </td>
        </tr>
        <tr>
            <td>
                <figure>
                    <a href="https://skillsbuild.org/adult-learners/explore-learning/project-manager"><img class="CoursePic"  src="img/ProjectManager-00.webp"/></a>
                    <figcaption>Project Management</figcaption>
                </figure>
            </td>
            <td>
                <figure>
                    <a href="https://skillsbuild.org/adult-learners/explore-learning/web-developer"> <img class="CoursePic" src="img/Web_Development_Fundamentals-1-1.webp"/></a>
                    <figcaption>Web Development</figcaption>
                </figure>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
