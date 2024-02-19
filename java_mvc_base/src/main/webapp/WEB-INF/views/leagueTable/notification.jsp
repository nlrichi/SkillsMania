<!DOCTYPE html>
<html lang="en">
    <base href="${pageContext.request.contextPath}">
    <head>
        <meta charset="UTF-8">
        <title>League Situation</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/lt_assets/notification.css">
    </head>
    <body>
        <div class="${situation}_bg_image">
            <img src="${pageContext.request.contextPath}/lt_assets/shine_${logo}.png"
                 width="250" height="250">
            <p class="${situation}_notif_message">${message}</p>
            <a href="/leaderboard"><button class="btn"><b>LET'S GO</b></button></a>
        </div>
    </body>
</html>