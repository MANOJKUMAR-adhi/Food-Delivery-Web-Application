<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="java.util.List,com.p.models.Restaurant"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GrabIt.com</title>
<link rel="icon" href="https://media.istockphoto.com/id/1289190483/vector/food-fast-delivery-brand-logo-concept-for-restaurant-catering-service-company-express-cafe.jpg?s=2048x2048&w=is&k=20&c=Od27aMEFIs8Az4buRiWtITpF_wJ4oQqFS7FRwH160Jk=" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: 'Poppins', sans-serif;
	line-height: 1.6;
	color: #333;
	background-color: #f8f9fa;
}

.container {
	max-width: 1200px;
	margin: 0 auto;
	padding: 0 20px;
}

/* Navbar container */
/* Gradient Navbar Styling */
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
.navbar {
	background:#3B2F2F;
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

/* Hero Section */
.hero {
	background:linear-gradient(to right, #ff512f, #dd2476);
	color: white;
	padding: 80px 0;
	text-align: center;
}

.hero-content h1 {
	font-size: 48px;
	font-weight: 700;
	margin-bottom: 20px;
	animation: fadeInUp 1s ease;
}

.hero-content p {
	font-size: 20px;
	margin-bottom: 30px;
	opacity: 0.9;
	animation: fadeInUp 1s ease 0.2s both;
}

.cta-btn {
	background: white;
	color: #fc8019;
	border: none;
	padding: 15px 30px;
	border-radius: 8px;
	font-size: 18px;
	font-weight: 600;
	cursor: pointer;
	transition: all 0.3s ease;
	animation: fadeInUp 1s ease 0.4s both;
}

.cta-btn:hover {
	transform: translateY(-2px);
	box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
	background:black;
}

/* Featured Restaurant Section */
.featured-restaurant {
	padding: 80px 0;
	background: #D2B48C;
}

.featured-restaurant h2 {
	text-align: center;
	font-size: 36px;
	font-weight: 600;
	margin-bottom: 50px;
	color: #333;
}

.restaurant-grid {
    display: flex;
    flex-wrap: wrap;        /* Wrap to next line if not enough space */
    gap: 20px;              /* Space between cards */
    justify-content: center; /* Center align cards */
}

.restaurant-card {
    width: 500px;/* Fixed width for each card */
    height:600px;
    margin: 0; 
    background:#2C2C2C; 
    color:white;            /* Remove auto centering */
}

.restaurant-card:hover {
	transform: translateY(-5px);
	box-shadow: 0 15px 40px rgba(0, 0, 0, 0.15);
}

.restaurant-image {
	position: relative;
	width: 100%;
	height: 300px;
	overflow: hidden;
}

.restaurant-image img {
	width: 100%;
	height: 100%;
	object-fit: cover;
	transition: transform 0.3s ease;
}

.restaurant-card:hover .restaurant-image img {
	transform: scale(1.05);
}

.restaurant-badge {
	position: absolute;
	top: 20px;
	right: 20px;
	background: rgba(0, 0, 0, 0.8);
	color: white;
	padding: 8px 12px;
	border-radius: 20px;
	font-size: 14px;
	font-weight: 600;
	display: flex;
	align-items: center;
	gap: 5px;
}

.restaurant-info {
	padding: 30px;
}

.restaurant-header {
	display: flex;
	justify-content: space-between;
	align-items: flex-start;
	margin-bottom: 15px;
}

.restaurant-name {
	font-size: 28px;
	font-weight: 700;
	color: white;
	margin: 0;
}

.restaurant-rating {
	display: flex;
	align-items: center;
	gap: 5px;
	background: #4caf50;
	color: white;
	padding: 6px 12px;
	border-radius: 20px;
	font-size: 14px;
	font-weight: 600;
}

.restaurant-cuisine {
	display: flex;
	align-items: center;
	gap: 8px;
	color: white;
	font-size: 16px;
	margin-bottom: 15px;
}

.restaurant-cuisine i {
	color: #fc8019;
}

.restaurant-address {
	display: flex;
	align-items: flex-start;
	gap: 8px;
	color: white;
	font-size: 14px;
	margin-bottom: 20px;
	line-height: 1.5;
}

.restaurant-address i {
	color: #fc8019;
	margin-top: 2px;
}

.restaurant-details {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 25px;
	padding: 15px 0;
	border-top: 1px solid #f0f0f0;
	border-bottom: 1px solid #f0f0f0;
}

.restaurant-phone, .restaurant-eta {
	display: flex;
	align-items: center;
	gap: 8px;
	color: white;
	font-size: 14px;
}

.restaurant-phone i, .restaurant-eta i {
	color: #fc8019;
}

.restaurant-actions {
	display: flex;
	gap: 15px;
}

.view-menu-btn, .order-now-btn {
	flex: 1;
	display: flex;
	align-items: center;
	justify-content: center;
	gap: 8px;
	padding: 12px 20px;
	border: none;
	border-radius: 8px;
	font-size: 16px;
	font-weight: 600;
	cursor: pointer;
	transition: all 0.3s ease;
}

.rid {
	text-align: center;
}

a {
	text-decoration: none;
}

/* Footer */
footer {
    background-color: #000; /* Your footer bg */
    color: white;
    padding: 30px 50px;
}

.footer-container {
    display: flex;
    justify-content: space-between; /* Even space between columns */
    align-items: flex-start; /* Align top of all sections */
    flex-wrap: wrap; /* Wrap on small screens */
    gap: 20px; /* Space between sections */
}

.footer-section {
    flex: 1; /* All sections get equal width */
    min-width: 200px; /* Prevent squishing */
}

.footer-section h4 {
    margin-bottom: 10px;
    font-size: 16px;
    font-weight: bold;
}

.footer-section ul {
    list-style: none;
    padding: 0;
    margin: 0;
}

.footer-section ul li {
    margin: 5px 0;
}

.footer-section ul li a {
    color: white;
    text-decoration: none;
    display: flex;
    align-items: center;
    gap: 8px; /* Space between icon and text */
}

.footer-section ul li a:hover {
    color: #f39c12; /* Hover color */
}

</style>
</head>
<body>
	<%@ page session="true"%>
	<nav class="navbar">
		<div class="nav-container">

			<!-- Logo and App Name -->
			<div class="nav-logo">
			<i class="fas fa-utensils"></i>
				<span>GrabIt 🥙🍟</span>
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

	<section class="hero">
		<div class="hero-content">
			<h1>🥗🥖 Your Favorite Meals, Just a Click Away 🍔🍕</h1>
			<p>Skip the wait — discover top restaurants near you and enjoy hot, fresh food delivered lightning-fast.
			</p>
			<a href="#featured-restaurant"><button class="cta-btn">GrabIt Now 🍜</button></a>
		</div>
	</section>


	<section class="featured-restaurant" id="featured-restaurant">
		<div class="container">
			<h2>Featured Restaurant</h2>
			<div class="restaurant-grid">
			
    <% 
     List <Restaurant> allrestaurants= (List <Restaurant>)request.getAttribute("restaurants");
    
    for(Restaurant r: allrestaurants)
    { 
    %>
    
        <a href="menu?restaurantId=<%= r.getRestaurantId()%>">
        
            <div class="restaurant-card">
                <div class="restaurant-image">
                    <img src="<%= r.getImagePath() %>" alt="Restaurant Image">
                    <div class="restaurant-badge">
                        <i class="fas fa-star"></i> <span><%= r.getRating() %></span>
                    </div>
                </div>
                <div class="restaurant-info">
                    <div class="restaurant-header">
                        <h3 class="restaurant-name"><%= r.getName() %></h3>
                    </div>
                    <div class="restaurant-cuisine">
                        <i class="fas fa-utensils"></i> <span><%= r.getCusineType() %></span>
                    </div>
                    <div class="restaurant-address">
                        <i class="fas fa-map-marker-alt"></i> <span><%= r.getAddress() %></span>
                    </div>
                    <div class="restaurant-details">
                        <div class="restaurant-phone">
                            <i class="fas fa-phone"></i> <span><%= r.getPhoneNumber() %></span>
                        </div>
                        <div class="restaurant-eta">
                            <i class="fas fa-clock"></i> <span><%= r.getEta() %></span>
                        </div>
                    </div>
                    <div class="rid">
                        <span><%= r.getRestaurantId() %></span>
                    </div>
                </div>
            </div>
        </a>
        
    <% 
        }
    %>
</div>
		</div>
		</a>
	</section>
	<footer>
    <div class="footer-container">
        <div class="footer-section">
            <h4>Company</h4>
            <ul>
                <li><a href="#">About Us</a></li>
                <li><a href="#">Team</a></li>
                <li><a href="#">Careers</a></li>
                <li><a href="#">Blog</a></li>
            </ul>
        </div>

        <div class="footer-section">
            <h4>Contact</h4>
            <ul>
                <li><a href="#">Help & Support</a></li>
                <li><a href="#">Partner with Us</a></li>
                <li><a href="#">Ride with Us</a></li>
            </ul>
        </div>

        <div class="footer-section">
            <h4>Legal</h4>
            <ul>
                <li><a href="#">Terms & Conditions</a></li>
                <li><a href="#">Refund & Cancellations</a></li>
                <li><a href="#">Privacy Policy</a></li>
                <li><a href="#">Cookie Policy</a></li>
            </ul>
        </div>

        <div class="footer-section">
            <h4>Social Links</h4>
            <ul>
                <li><a href="#"><i class="fab fa-facebook"></i>Facebook</a></li>
                <li><a href="#"><i class="fab fa-instagram"></i>Instagram</a></li>
                <li><a href="#"><i class="fab fa-twitter"></i>Twitter</a></li>
                <li><a href="#"><i class="fab fa-youtube"></i>Youtube</a></li>
            </ul>
        </div>
    </div>
</footer>
</body>
</html>