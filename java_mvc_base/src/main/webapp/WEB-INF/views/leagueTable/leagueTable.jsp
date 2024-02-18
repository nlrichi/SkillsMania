<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<base href="${pageContext.request.contextPath}">
    <head title="League">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/leagueTable.css">

    </head>
    <body>
        <div class="bg_image2">
            <h1 class="header">${league.tierName} league</h1>
            <h2 class="header">${league.daysLeft} ${league.daysLeft==1 ? ' day left' : ' days left'}</h2>

            <div class="pseudo_table">
                <!-- The PDP table consisting of 6 rows and 2 columns -->
                <div class="table_header">
                    <a class="posi">Position</a>
                    <a class="avatar">Avatar</a>
                    <a class="header_names">Name</a>
                    <a class="header_names">XP for the time</a>
                </div>

                <c:forEach var="member" items="${league.members}" varStatus="loop">
                    <div class=${member.username == logged_users_uname ? "logged_user_model" : 'user_model'}>

                        <a class=${member.username == logged_users_uname ? "logged_user_position" :
                                'user_position'}>${loop.index + 1}.
                        </a>

                        <img class="user_model_image" src="https://via.placeholder.com/150">

                        <a class=${member.username == logged_users_uname ? "logged_user_model_name" :
                         'user_model_name'}>${member.username} ${member.username == logged_users_uname ?
                         "(you)" : ''}
                        </a>

                        <a class=${member.username == logged_users_uname ? "logged_user_model_xp" :
                                'user_model_xp'} >
                                ${member.overallXp} xp
                        </a>
                    </div>


                </c:forEach>

            </div>
        </div>

    </body>
</html>