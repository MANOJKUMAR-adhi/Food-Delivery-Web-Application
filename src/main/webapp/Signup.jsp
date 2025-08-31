<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>GrabIt | Sign Up</title>
  <style>
    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    body {
      background: url('https://media.istockphoto.com/id/613891942/photo/copy-space-frame-and-coffee-with-cookies.jpg?s=2048x2048&w=is&k=20&c=PMvDKbZ_b1n5ZN5-AXgg7z1aY2PcAPFTZ5u4BsTAqFI=') no-repeat center center/cover;
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .signup-box {
      background-color: rgba(255, 255, 255, 0.95);
      padding: 40px 30px;
      border-radius: 12px;
      box-shadow: 0 8px 20px rgba(0,0,0,0.2);
      width: 100%;
      max-width: 450px;
      overflow-y: auto;
      max-height: 90vh;
    }

    .signup-box h2 {
      text-align: center;
      color: #ff6b00;
      margin-bottom: 30px;
      font-size: 28px;
    }

    .signup-box form {
      display: flex;
      flex-direction: column;
    }

    .signup-box input,
    .signup-box select {
      padding: 12px 15px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 8px;
      font-size: 16px;
    }

    .signup-btn {
      background-color: #ff6b00;
      color: white;
      padding: 12px;
      font-size: 16px;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      transition: background 0.3s ease;
    }

    .signup-btn:hover {
      background-color: #e65c00;
    }

    .footer-text {
      margin-top: 15px;
      text-align: center;
      font-size: 14px;
      color: #555;
    }

    @media screen and (max-width: 500px) {
      .signup-box {
        margin: 20px;
        padding: 30px 20px;
      }
    }
  </style>
</head>
<body>

  <div class="signup-box">
    <h2>Create Your GrabIt Account</h2>
    <form action="SignUpServlet" method="POST">
      <input type="text" name="name" placeholder="Full Name" required>
      <input type="text" name="userName" placeholder="Username" required>
      <input type="password" name="password" placeholder="Password" required>
      <input type="email" name="email" placeholder="Email Address" required>
      <input type="tel" name="phoneNumber" placeholder="Phone Number" required>
      <input type="text" name="address" placeholder="Address" required>
      <select name="role" required>
        <option value="" disabled selected>Select Role</option>
        <option value="customer" default>Customer</option>
        <option value="Restaurantadmin">Restaurant Admin</option>
        <option value="deliveryAgent">Delivery Agent</option>
       
      </select>
      <button type="submit" class="signup-btn">Sign Up</button>
    </form>
    <div class="footer-text">
      Already have an account? <a href="login.jsp" style="color: #ff6b00;">Login</a>
    </div>
  </div>

</body>
</html>