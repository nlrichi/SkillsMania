<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<base href="${pageContext.request.contextPath}">
<head title="League">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lt_assets/leagueTable.css">

</head>
    <body>
        <div class="bg_image2">

<%--            determine the required logo based on the tier name--%>
            <c:if test="${league.tierName == 'Kings Intelligence'}">
                <img class="league_logo" src="${pageContext.request.contextPath}/lt_assets/ki.png">
            </c:if>
            <c:if test="${league.tierName == 'Bronze'}">
                <img class="league_logo" src="${pageContext.request.contextPath}/lt_assets/Bronze.png">
            </c:if>
            <c:if test="${league.tierName == 'Artificial Champions'}">
                <img class="league_logo" src="${pageContext.request.contextPath}/lt_assets/tier1_logo.png">
            </c:if>

            <h1 class="header">${league.tierName} league</h1>
            <h2 class="header">${league.daysLeft} ${league.daysLeft==1 ? ' day left' : ' days left'}</h2>
            <div class="back-to-dashboard">
                <a href="${pageContext.request.contextPath}/dashboard" class="dashboard-link">Go Back to Dashboard</a>
            </div>
                    <div class="pseudo_table">
                        <div class="table_header">
                            <a class="posi">Position</a>
                            <a class="avatar">Avatar</a>
                            <a class="header_names">Name</a>
                            <a class="header_names">XP for the time</a>
                        </div>

                        <c:forEach var="member" items="${league.members}" varStatus="loop">
                            <!-- for each member of the league add a data model to the table.
                            If it's the logged user, give a special design. -->

                            <div class=${member.username == logged_users_uname ? "logged_user_model" : 'user_model'}>

                                <a class=${member.username == logged_users_uname ? "logged_user_position" :
                                        'user_position'}>${loop.index + 1}.
                                </a>

                                <img class="user_model_image" src="${pageContext.request.contextPath}${member.avatar.image}" alt="${member.avatar.name}" />

                                <a class=${member.username == logged_users_uname ? "logged_user_model_name" :
                                 'user_model_name'}>${member.username} ${member.username == logged_users_uname ?
                                 "(you)" : ''}
                                </a>

                                <a class=${member.username == logged_users_uname ? "logged_user_model_xp" :
                                        'user_model_xp'} >
                                        ${member.leagueXP} xp
                                </a>
                            </div>


                        </c:forEach>

                    </div>

        </div>

    </body>
</html>