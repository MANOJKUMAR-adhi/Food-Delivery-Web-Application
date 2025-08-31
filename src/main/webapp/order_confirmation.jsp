<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Order Success!!!!</title>
  <style>
    body, html {
      margin: 0;
      padding: 0;
      height: 100%;
      overflow: hidden;
      font-family: 'Segoe UI', sans-serif;
    }

    .success-container {
      position: relative;
      width: 100vw;
      height: 100vh;
    }

    .success-container video {
      width: 100%;
      height: 100%;
      object-fit: fill;
      display: block;
    }

    .success-container h4 {
      position: absolute;
      bottom: 60px;
      left: 57%;
      transform: translateX(-50%);
      color: black;
      font-size: 20px;
      background-color: black;
      padding: 16px 32px;
      border-radius: 10px;
      text-decoration:none;
    }
 .Home:hover{
   text-decoration:underline;
 }
    .Home{
    text-decoration:none;
    color:#FDF4DC;
    }
  
  </style>
</head>
<body>
  <div class="success-container">
    <video src="o1.mp4" autoplay  muted></video>
    <h4><a href="GetAllRestaurantServelet" class="Home">Go Back to Home</a></h4>
  </div>
</body>
</html>