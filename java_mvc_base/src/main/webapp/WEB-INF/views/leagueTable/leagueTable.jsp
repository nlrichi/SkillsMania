<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head title="League">
        <!-- <link rel="stylesheet" href=".leagueTable.css"> -->
        <style>
            .bg_image2{
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                background-image: url('bg2.jpeg');
                background-size: cover;
                background-repeat: no-repeat;
                height: 100%;
                border-width: 5px;
                width: 1420px;
                flex: 1;
            }


            table{
                height: 600px;
                width: 100%;
                text-align: center;
            }
            td{
                background-color:rgba(97, 173, 90, 0.192);
                font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
                font-size: large;
                text-align: center;
            }
            td:hover{

                background-color: rgba(8, 66, 1, 0.652);
                color: rgb(0, 255, 89);
            }

        </style>
    </head>
    <body>
        <div class="bg_image">
            <h1>${league.tierName} league: ${league.daysLeft} days remaining</h1>
            <table class="table">
                <!-- The PDP table consisting of 6 rows and 2 columns -->
                <tr>
                    <th>Position</th>
                    <th>Name</th>
                </tr>
                <c:forEach var="member" items="${league.members}">
                    <tr>
                        <td>${member.username}</td>
                        <td>
                                ${member.overallXp} XP
                        </td>
                    </tr>

                </c:forEach>

            </table>
        </div>

    </body>
</html>