<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<base href="${pageContext.request.contextPath}">
    <head title="League">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/leagueTable.css">

    </head>
    <body>
        <div class="bg_image2">
            <h1 class="header">${league.tierName} league: ${league.daysLeft} days remaining</h1>
            <div class="pseudo_table">
                <!-- The PDP table consisting of 6 rows and 2 columns -->
                <div class="table_header">
                    <a class="avatar">Avatar</a>
                    <a class="header_names">Name</a>
                    <a class="header_names">XP for the time</a>
                </div>
                <c:forEach var="member" items="${league.members}">
                    <div class="user_model">
                        <img class="user_model_image" src="https://via.placeholder.com/150">
                        <a class="user_model_name">${member.username}</a>
                        <a class="user_model_xp">
                                ${member.overallXp} xp
                        </a>
                    </div>

                </c:forEach>

            </div>
        </div>

    </body>
</html>