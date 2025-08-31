<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.p.DAOImpl.Cart" %>
<%@ page import="com.p.models.CartItem" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Your Cart</title>

    <style>
      body {
      	font-family: "Segoe UI", sans-serif;
        background: #fd7a21;
        margin: 0;
        padding: 20px;
      }

      h1 {
        text-align: center;
        color: #333;
      }
      
  	  .project-img{
 	  display:block;
      height:120px;
      margin-left:auto;
      margin-right:auto;
   }
   
      .cart-container {
        max-width: 800px;
        margin: auto;
      }

      .cart-item {
        display: flex;
        justify-content: space-between;
        align-items: center;
        background: white;
        padding: 20px;
        margin-bottom: 15px;
        border-radius: 16px;
        box-shadow: 0 6px 18px rgba(0, 0, 0, 0.1);
      }

      .cart-item-details {
        flex: 1;
      }

      .cart-item-details h3 {
        margin: 0;
        color: #333;
      }

      .cart-item-details p {
        margin: 4px 0;
        color: #555;
      }

      .quantity-controls {
        margin-top: 10px;
      }

      .quantity-btn {
        padding: 6px 10px;
        margin: 0 5px;
        background-color: #ff4d4d;
        color: white;
        border: none;
        border-radius: 8px;
        cursor: pointer;
      }

      .quantity-btn:disabled {
        background-color: #ccc;
        cursor: not-allowed;
      }

      .remove-btn {
        background-color: #ff4d4d;
        color: white;
        padding: 8px 14px;
        border: none;
        border-radius: 8px;
        cursor: pointer;
      }

      .total {
        text-align: right;
        font-size: 1.2rem;
        font-weight: bold;
        margin-top: 20px;
        color: #333;
      }

      .add-more-item {
        text-align: center;
        margin-top: 20px;
      }

      .add-more-item a {
        display: inline-block;
        padding: 10px 20px;
        background: black;
        color: white;
        border-radius: 10px;
        text-decoration: none;
        font-weight: bold;
      }

      .btn-proceed-to-checkout {
        padding: 12px 24px;
        background-color: #28a745;
        color: white;
        font-size: 1rem;
        border: none;
        border-radius: 10px;
        cursor: pointer;
        margin-top: 30px;
        display: block;
        margin-left: auto;
        margin-right: auto;
      }

      .empty-cart {
        text-align: center;
        color: white;
      }
    </style>
  </head>
  <body>
  <img
            src="https://uxwing.com/wp-content/themes/uxwing/download/e-commerce-currency-shopping/shopping-cart-white-icon.png"
            alt="Cart img"
            class="project-img"
          />
    <h1>Your Cart</h1>
    <div class="cart-container">
    
    <% Cart cart= (Cart) session.getAttribute("cart"); 
    	Integer restaurantId=(Integer) session.getAttribute("restaurantId");
    	
    	if(cart != null && !cart.getItems().isEmpty()) {  //make sure the cart is not empty &
    		int grantTotal=0;                           // cart -> items (Map)
    		for(CartItem item: cart.getItems().values()){
    			grantTotal= grantTotal+ item.getTotalPrice();
    	
    	
    %>
      <div class="cart-item">
        <div class="cart-item-details">
          <h3><%= item.getName() %></h3>
          <p>Price: ₹ <%= item.getPrice() %></p>
          <p>Total: ₹ <%= item.getTotalPrice() %></p>

          <div class="quantity-controls">
          
            <form action="cart" method="post" style="display: inline">
             <input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId") %>">
              <input type="hidden" name="itemId" value="<%= item.getItemId() %>" />
              <input type="hidden" name="action" value="update" />
              <input
                type="hidden"
                name="quantity"
                value="<%= item.getQuantity()-1 %>"
              />
              <button type="submit" class="quantity-btn">-</button>
            </form>

            <span> <%= item.getQuantity() %> </span>

            <form action="cart" method="post" style="display: inline">
             <input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId") %>">
              <input type="hidden" name="itemId" value="<%= item.getItemId() %>" />
              <input type="hidden" name="action" value="update" />
              <input type="hidden" name="quantity" value="<%= item.getQuantity()+1 %>" />
              <button  type="submit" class="quantity-btn">+</button>
            </form>
          </div>
          
          
        </div>

        <form action="cart" method="post">
        <input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId") %>">
          <input type="hidden" name="itemId" value="<%= item.getItemId() %>" />
          <input type="hidden" name="action" value="remove" />
          <button  type="submit"  class="remove-btn">Remove</button>
        </form>
      </div>
	<%} %>
      <div class="total">Grand Total: ₹<%= grantTotal %></div>

      <div class="add-more-item">
        <a href="menu?restaurantId=<%= restaurantId %>">Add More Items</a>
      </div>
<%} 
    	else{ %>
      <p class="empty-cart">Your cart is empty.</p>
      
<% } %>

<% 
	if (session.getAttribute("cart") != null && !cart.getItems().isEmpty()){
%>
      <form action="checkout.jsp" method="post"> <!-- Calling checkout.jsp  not checkout.servlet -->
        <input
          type="submit" value="Proceed to Checkout" class="btn-proceed-to-checkout"/>
      </form>
      
  <%} else { %>
           <div class="add-more-item">
        <a href="menu?restaurantId=<%= restaurantId %>">Add Items in Cart</a>
      </div>
      
<% } %>
      
       </div>
  </body>
</html>