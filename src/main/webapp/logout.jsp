<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%
    session.invalidate(); // Clear the session
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Logged Out | GrabIt</title>
  <style>
    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    body {
      background: url('https://media.istockphoto.com/id/894536416/photo/delicious-breakfast-on-a-rustic-table.jpg?s=2048x2048&w=is&k=20&c=czbsoAmyaiF25V1F7zeA6dpW9UHh7FeYjJIjBMdRGsw=') no-repeat center center/cover;
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .logout-box {
      background-color: rgba(255, 255, 255, 0.95);
      padding: 40px 30px;
      border-radius: 12px;
      box-shadow: 0 8px 20px rgba(0,0,0,0.2);
      width: 100%;
      max-width: 400px;
      text-align: center;
    }

    .logout-box h2 {
      color: #ff6b00;
      font-size: 28px;
      margin-bottom: 20px;
    }

    .logout-box p {
      font-size: 16px;
      color: #333;
      margin-bottom: 30px;
    }

    .logout-box a {
      display: inline-block;
      padding: 12px 24px;
      background-color: #ff6b00;
      color: white;
      text-decoration: none;
      border-radius: 8px;
      font-weight: bold;
      transition: 0.3s ease;
    }

    .logout-box a:hover {
      background-color: #e65c00;
    }

    @media screen and (max-width: 500px) {
      .logout-box {
        margin: 20px;
        padding: 30px 20px;
      }
    }
  </style>
</head>
<body>

  <div class="logout-box">
    <h2>You've been logged out</h2>
    <p>Thank you for visiting GrabIt......</p>
    <a href="login.jsp">Login Again</a>
  </div>

</body>
</html>