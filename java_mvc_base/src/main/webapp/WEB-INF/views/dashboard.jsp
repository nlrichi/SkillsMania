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
            height: 63px;
            width: 130px;
            text-align: left;
            padding: 100px;
        }
        .header {
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
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

        .navbar li {
            float: left;
            display: block;
            color: white;
            text-align: center;
            padding: 5px 10px;
            text-decoration: none;
        }
        .navbar li:hover {
            background-color: mediumblue;
            cursor: pointer;
        }

        #courses {
            position: fixed;

        }

    </style>
</head>
<body>
<div class="header">
    <a href="https://www.ibm.com/uk-en"><img src="img/IBMLogo.png" alt="IBM logo" id="logo"></a>
    <h1>Track your SkillsBuild Progress</h1>
    <br>
    <br>
</div>
<div class="navbar">
    <ul>
        <li>Home</li>
        <li>Dashboard</li>
        <li>Placeholder</li>
        <li>Placeholder</li>
    </ul>
</div>

<div id="courses">
    <h3>Available Courses</h3>
    <table>
        <tr>
            <td>Placeholder Name</td>
            <td>Placeholder Link</td>
        </tr>
        <tr>
            <td>Placeholder Name</td>
            <td>Placeholder Link</td>
        </tr>
    </table>
</div>
</body>
</html>
