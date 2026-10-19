<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Checkout</title>

<script src="https://checkout.razorpay.com/v1/checkout.js"></script>

<style>

body{
    font-family:Arial,sans-serif;
    background:#f5f5f5;
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
    margin:0;
}

.container{
    width:420px;
    background:white;
    padding:30px;
    border-radius:10px;
    box-shadow:0 5px 15px rgba(0,0,0,.2);
}

h2{
    color:#fc8019;
    text-align:center;
}

.amount{
    text-align:center;
    font-size:28px;
    font-weight:bold;
    margin:20px 0;
}

.payment-box{
    border:1px solid #ddd;
    padding:15px;
    border-radius:8px;
    margin-bottom:20px;
}

.payment-box label{
    display:block;
    padding:10px;
    font-size:18px;
    cursor:pointer;
}

button{
    width:100%;
    padding:14px;
    border:none;
    background:#fc8019;
    color:white;
    font-size:18px;
    border-radius:6px;
    cursor:pointer;
}

button:hover{
    background:#e66a00;
}

</style>

</head>

<body>

<div class="container">

    <h2>FoodieExpress Checkout</h2>

    <div class="amount">
        ₹ <%=request.getAttribute("totalAmount")%>
    </div>

    <div class="payment-box">

        <h3>Select Payment Method</h3>

        <label>
            <input type="radio"
                   name="paymentMethod"
                   value="COD"
                   checked>

            Cash On Delivery
        </label>

        <label>
            <input type="radio"
                   name="paymentMethod"
                   value="ONLINE">

            Pay Online (Razorpay)
        </label>

    </div>

    <button id="placeOrderBtn">
        Place Order
    </button>

</div>


<!-- COD FORM -->

<form id="codForm"
      action="PlaceOrderServlet"
      method="post">

    <input type="hidden"
           name="paymentMethod"
           value="COD">

</form>


<!-- ONLINE PAYMENT FORM -->

<form id="paymentForm"
      action="PaymentSuccessServlet"
      method="post">

    <input type="hidden"
           name="paymentMethod"
           value="ONLINE">

    <input type="hidden"
           name="razorpay_payment_id"
           id="payment_id">

    <input type="hidden"
           name="razorpay_order_id"
           id="order_id">

    <input type="hidden"
           name="razorpay_signature"
           id="signature">

</form>

<script>

var options = {

    key : "<%=request.getAttribute("key")%>",

    amount : "<%=request.getAttribute("amount")%>",

    currency : "<%=request.getAttribute("currency")%>",

    name : "FoodieExpress",

    description : "Food Order Payment",

    order_id : "<%=request.getAttribute("orderId")%>",

    theme:{
        color:"#fc8019"
    },

    handler:function(response){

        document.getElementById("payment_id").value =
        response.razorpay_payment_id;

        document.getElementById("order_id").value =
        response.razorpay_order_id;

        document.getElementById("signature").value =
        response.razorpay_signature;

        document.getElementById("paymentForm").submit();

    }

};

var rzp = new Razorpay(options);

document.getElementById("placeOrderBtn").onclick=function(e){

    e.preventDefault();

    var paymentMethod =
    document.querySelector('input[name="paymentMethod"]:checked').value;

    if(paymentMethod=="COD"){

        document.getElementById("codForm").submit();

    }
    else{

        rzp.open();

    }

};

</script>

</body>
</html>