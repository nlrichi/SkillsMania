<!DOCTYPE html>
<html lang="en">
<!-- This HTML page is the page that Okta Auth2.0 redirects to after logging in  -->
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to SkillsMania</title>
    <!-- some styling with gradient background  -->
    <!--below is redirect link as Okta needs users to access the securedPage JSP after logging in -->
    <meta http-equiv="refresh" content="1; URL=http://localhost:8080/dashboard" />
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(to bottom right, #4facfe, #00f2fe);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            text-align: center;
            background-color: rgba(255, 255, 255, 0.7);
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);
            height: 60vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }
        h1 {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<!--Thanks message -->
<div class="container">
    <h1>Thanks for logging in, redirecting you to your dashboard now...</h1>
</div>

</body>
</html>
