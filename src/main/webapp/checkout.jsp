<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>

<style type="text/css">

 body{
 background:#fd7a21;
}

.project-img{
 	  display:block;
      height:120px;
      margin-left:auto;
      margin-right:auto;
   }
   
.checkout-title {
  text-align: center;
  color: black;
  font-size: 28px;
  margin-bottom: 20px;
  font-family: 'Segoe UI', sans-serif;
}

/* Form styling */
.checkout-form {
  max-width: 500px;
  margin: 0 auto;
  background: #fff;
  padding: 25px;
  border-radius: 12px;
  box-shadow: 0 4px 16px rgba(0, 0, 0, 0.1);
  font-family: 'Segoe UI', sans-serif;
}

/* Form elements */
.checkout-form label {
  display: block;
  margin: 12px 0 6px;
  font-weight: 500;
  color: #333;
}

.checkout-form textarea,
.checkout-form select {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 6px;
  font-size: 14px;
  resize: vertical;
}

/* Button styling */
.place-order-btn {
  margin-top: 20px;
  padding: 12px 20px;
  background: #ff4d4d;
  color: white;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  font-size: 16px;
  font-weight: bold;
  transition: background 0.3s;
  width: 100%;
}

.place-order-btn:hover {
  background: black;
}
</style>

</head>
<body>
 <img
            src="https://static.thenounproject.com/png/700396-200.png"
            alt="Weather App"
            class="project-img"
          />
	<h2 class="checkout-title">Checkout</h2>

<form action="checkout" method="post" class="checkout-form"> <!-- jsp calling servlet -->
  <label for="address">Delivery Address:</label>
  <textarea id="address" name="address" required></textarea>

  <label for="paymentMethod">Payment Mode:</label>
  <select name="paymentMethod" id="paymentMethod">
    <option value="Credit Card">Credit Card</option>
    <option value="Debit Card">Debit Card</option>
    <option value="Cash">Cash on Delivery</option>
    <option value="UPI">UPI ( Gpay , Phonepay ,..)</option>
  </select>

  <button type="submit" class="place-order-btn">Place Order</button>
</form>
</body>
</html>