<!DOCTYPE html>
<html lang="en">
<!-- This HTML page is the landing page before sign up / login  -->
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to SkillsMania</title>
    <!-- some styling with gradient background  -->
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

        .login-btn {
            padding: 15px 30px;
            font-size: 18px;
            background-color: #4facfe;
            border: none;
            border-radius: 5px;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s;
            text-decoration: none;
            background-image: linear-gradient(to bottom right, #4facfe, #00f2fe);
            margin: 20px auto; /* Centering the button horizontally with top and bottom margin */
        }
        .login-btn:hover {
            background-color: #00f2fe;
        }
    </style>
</head>
<body>
<!-- Button redirects to OAuth2 Secure Page  -->
<div class="container">
    <h1>Welcome to SkillsMania</h1>
    <a href="http://localhost:8080/securedPage" class="login-btn">Login / Sign Up</a>
</div>

</body>
</html>
