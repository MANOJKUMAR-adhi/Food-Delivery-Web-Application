🚀 Food Delivery Web Application
A full-stack web application built using HTML, CSS, JSP, Servlets, JDBC, and MySQL.



1. Introduction :

GrabIt is an online food delivery web application that allows users to browse restaurants, explore menus, place food orders, and get them delivered conveniently. The application provides a smooth and user-friendly interface for customers to order their favorite meals online in just a few clicks. The system integrates frontend technologies (HTML, CSS) with backend technologies (Java Servlets, JSP, JDBC) and a MySQL database to store user, restaurant, and order details.

2. Objectives:

•To develop a responsive and user-friendly food delivery platform.

•To provide restaurant listings with menu details.

•To enable users to add items to the cart and place orders.

•To ensure secure login and order processing.

3. Technologies Used:

(i) Frontend:

• HTML5 – Structure of web pages.

• CSS3 – Styling and responsiveness.

(ii) Backend:

• Java Servlet & JSP – Server-side logic & dynamic page rendering.

• JDBC (Java Database Connectivity) – Database interaction.

(iii) Database:

•MySQL – Storage of user data, restaurant details, menu items, orders, and transaction details.

(iv) Tools & Server:

•Apache Tomcat – Web server for running servlets and JSP.

•Eclipse – IDE for development.

4. System Architecture:

The system follows a 3-tier architecture:

1.Presentation Layer (Frontend) – HTML, CSS, JS (User interface).

2.Application Layer (Backend) – Java Servlets, JSP (Business logic).

3.Database Layer – MySQL (Data storage).

Flow: User → Web Browser (UI) → Servlet/JSP → JDBC → MySQL Database

5. Modules of the Application

 (i). User Module

         •User Registration & Login (Authentication).
         •Profile Management.

 (ii). Restaurant Module

         •View restaurant listings.
         •View restaurant details & menu..

 (iii). Cart Module

         •Add/remove menu items.
         •View cart summary (items, quantity, price).

 (iv). Order Module

         •Place order with delivery details.
         •Select payment method (Cash on Delivery / Online).
         •Order confirmation.


6. Database Design:
Main Tables (Example sample):

            1.User – (userId, name, userName,email, password, phoneNumber, address)
            2.Restaurant – (restaurantId, name, location, rating,cuisineType)
            3.Menu – (menuId, restaurantId, itemName, price, isAvailable)
            4.Cart – (cart_id, user_id, menu_id, quantity)
            5.Order– (orderId, userId, restaurantId, totalAmount, status, orderDate)
            6.OrderItem – (orderItemId, orderId, menuId, quantity, price)
7. Workflow

 🔹 Homepage
         •Restaurants and food items.
         •View popular restaurants.
 
 🔹 Restaurant Listings
         •Display of restaurants with ratings, cuisine, and delivery time.
 
 🔹 Menu Page
         •Display of restaurant menu with categories.
         •Option to add items to cart.
         
 🔹 Cart Page
         •View selected items.
         •Update quantity or remove items.
         •Order summary with subtotal, taxes, and delivery fee.
         
 🔹 Checkout Page
         •Enter delivery details.
         •Choose payment method.
         •Place final order.
         
 🔹 Order Confirmation
         •Order confirmation message.
       
         
8. Key Features:

•User authentication (Login/Signup).

•Restaurant and menu browsing.

•Dynamic cart and checkout system.

•Real-time order summary.

•Secure and scalable architecture.

9. Future Enhancements:

•Live order tracking with delivery partner module.

•AI-based food recommendations.

•Admin dashboard for analytics.

•Push notifications for order status.

10. Conclusion:

The GrabIt Food Delivery Web Application provides an efficient way for users to order food online from multiple restaurants. Using Java Servlets, JSP, and MySQL, the application ensures smooth order management and data handling. With a responsive UI built with HTML, CSS it enhances the user experience and brings convenience to customers.
