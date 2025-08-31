<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="java.util.List,com.p.models.Menu"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background: linear-gradient(135deg, #fc8019 0%, #ff6b35 100%);
	min-height: 100vh;
	padding: 20px;
}

/* Navbar container */
/* Gradient Navbar Styling */
.navbar {
	background: #2C2C2C;
	/* matching your hero section */
	padding: 14px 20px;
	font-family: 'Segoe UI', sans-serif;
	box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
	position: sticky;
	top: 0;
	z-index: 999;
}

/* Layout */
.nav-container {
	display: flex;
	justify-content: space-between;
	align-items: center;
	max-width: 1500px;
	margin: 0 auto;
}

/* Branding */
.nav-logo {
	color: white;
	font-size: 24px;
	font-weight: bold;
	display: flex;
	align-items: center;
	gap: 10px;
}

/* Nav links */
.nav-links {
	display: flex;
	align-items: center;
	gap: 22px;
	margin-left: auto;
}

.nav-links a {
	color: white;
	text-decoration: none;
	font-size: 16px;
	font-weight: 500;
	display: flex;
	align-items: center;
	gap: 6px;
	padding: 8px 12px;
	border-radius: 4px;
	transition: background 0.3s, color 0.3s;
}

.nav-links a:hover {
	background-color: rgba(255, 255, 255, 0.2);
}

/* Cart count badge */
.cart-link {
	position: relative;
}

.cart-count {
	background-color: white;
	color: #ff6a00;
	font-weight: bold;
	padding: 2px 6px;
	border-radius: 50%;
	font-size: 12px;
	position: absolute;
	top: -8px;
	right: -10px;
}

.nav-links span {
	color: white;
	font-weight: 500;
	font-size: 16px;
}

.container {
	max-width: 1200px;
	margin: 0 auto;
	padding: 0 20px;
}

.header {
	text-align: center;
	margin-bottom: 50px;
	color: white;
}

.header h1 {
	color: white;
	font-size: 2.8rem;
	margin-bottom: 15px;
	text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
	font-weight: 700;
	animation: fadeInUp 1s ease;
}

.header p {
	font-size: 1.2rem;
	opacity: 0.9;
	font-weight: 300;
	animation: fadeInUp 1s ease 0.2s both;
}

.menu-grid {
	display: grid;
	grid-template-columns: repeat(2, 1fr);
	gap: 30px;
	margin-bottom: 50px;
	align-items: start;

}

.menu-item {
	background: white;
	border-radius: 20px;
	overflow: hidden;
	box-shadow: 0 8px 30px rgba(0, 0, 0, 0.1);
	transition: all 0.3s ease;
	height: fit-content;
	display: flex;
	flex-direction: column;
	cursor: pointer;
	animation: fadeInUp 0.6s ease forwards;
	transform: perspective(1000px) rotateX(0deg) scale(1);
}

.menu-item:nth-child(odd) {
	animation-delay: 0.1s;
}

.menu-item:nth-child(even) {
	animation-delay: 0.2s;
}

.menu-item:hover {
	transform: translateY(-5px);
	transition: transform 0.3s ease;
	box-shadow: 0 20px 50px rgba(0, 0, 0, 10);
}

.menu-item img {
	width: 100%;
	height: 220px;
	object-fit: cover;
	transition: transform 0.3s ease;
}

.menu-item:hover img {
	transform: scale(1.05);
}

.menu-content {
	padding: 25px;
	flex: 1;
	display: flex;
	flex-direction: column;
}

.menu-title {
	font-size: 1.4rem;
	font-weight: 700;
	color: #333;
	margin-bottom: 12px;
	line-height: 1.3;
}

.menu-description {
	color: #666;
	font-size: 1rem;
	margin-bottom: 20px;
	line-height: 1.5;
	flex: 1;
}

.menu-footer {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 20px;
}

.price {
	font-size: 1.3rem;
	font-weight: 700;
	color: #4caf50;
	background: #f0f8f0;
	padding: 8px 15px;
	border-radius: 25px;
}

.rating {
	background: linear-gradient(45deg, #ff6a00, #ff8c00);
	color: white;
	border-radius: 20px;
	padding: 6px 12px;
	font-size: 0.9rem;
	font-weight: 600;
	display: flex;
	align-items: center;
	gap: 5px;
	box-shadow: 0 2px 10px rgba(255, 106, 0, 0.3);
}

.add-to-cart {
	background: #ff4d4d;
	color: white;
	border: none;
	border-radius: 15px;
	padding: 15px 30px;
	font-weight: 600;
	font-size: 1.1rem;
	cursor: pointer;
	width: 100%;
	transition: all 0.3s ease;
	text-transform: uppercase;
	letter-spacing: 0.5px;
	box-shadow: 0 4px 15px rgba(255, 106, 0, 0.3);
}

.add-to-cart:hover {
	background: black;
	transform: translateY(-2px);
	box-shadow: 0 6px 20px rgba(255, 106, 0, 0.4);
}

.add-to-cart:active {
	transform: translateY(0);
}
</style>


</head>
<body>
	<%@ page session="true"%>
	<nav class="navbar">
		<div class="nav-container">

			<!-- Logo and App Name -->
			<div class="nav-logo">
				<i class="fas fa-utensils"></i> <span>GrabIt 🥙🍟</span>
			</div>

			<!-- Navigation Links -->
			<div class="nav-links">
				<a href="GetAllRestaurantServelet"><i class="fas fa-home"></i>
					Home</a>

				<% 
        String username = (String) session.getAttribute("username"); 
        if (username != null) {
      %>
				<span style="color: white; font-weight: 500;">Hello, <%= username %></span>
				<a href="logout.jsp"><i class="fas fa-sign-out-alt"></i> Logout</a>
				<% } else { %>
				<a href="login.jsp"><i class="fas fa-user"></i> Login</a> <a
					href="Signup.jsp"><i class="fas fa-user-plus"></i> Sign Up</a>
				<% } %>

				<a href="cart.jsp" class="cart-link"> <i
					class="fas fa-shopping-cart"></i>

				</a>
			</div>

		</div>
	</nav>

	<div class="container">
		<div class="header">
			<h1>🍽 “A Feast Awaits You”</h1>
			<p>Indulge in dishes crafted with love.</p>
		</div>


		<div class="menu-grid">
		
			<% List <Menu> li =(List <Menu>)request.getAttribute("menus"); 
			
		if(li != null && !li.isEmpty()){
	 for(Menu m: li){ 
	 %>
			<div class="menu-item">
				<img src="<%= m.getImagePath() %>" alt="Image not founded">
				<div class="menu-content">
					<h3 class="menu-title"><%= m.getItemName() %></h3>
					<p class="menu-description"><%= m.getDescription() %></p>
					<div class="menu-footer">
						<span class="price">₹<%=m.getPrice()%></span> 
						<span class="rating">⭐<%= m.getRatings() %></span>
					</div>

					<form action="cart" method="post">
						<input type="hidden" name="restaurantId"value="<%= request.getParameter("restaurantId") %>">
						<input type="hidden" name="itemId" value="<%= m.getMenuId() %>">
						<input type="hidden" name="quantity" value="1" min="1"> 
						<input type="hidden" name="action" value="add">
						<button type="submit" class="add-to-cart">Add to cart</button>
					</form>

				</div>
			</div>
			
			<% 
			}
			} 
		else{ 
			 %>
			 
		</div>

	</div>

	<p>No menu items available... Please check back</p>
	<%} %>
</body>
</html>