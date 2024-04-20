<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Placed</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f8f8;
            text-align: center;
            background-image: url('https://monsterspost.com/wp-content/uploads/2020/06/online-bookstore.jpg');
            background-size: 100% 100%;
            background-repeat: no-repeat;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .container {
            width: 600px;
            height: 200px;
            margin: 50px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333333;
        }
        .message {
            margin-bottom: 20px;
            color: #009900;
            font-size: 24px;
        }
        .links {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }
        .link-btn {
            padding: 10px 20px;
            background-color: #007bff;
            color: #ffffff;
            border-radius: 5px;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }
        .link-btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Your order is placed</h1>
        <p class="message">Thank you for your purchase!</p>
        <div class="links">
            <a href="./book/fetch" class="link-btn">Buy More Books</a>
            <a href="./Main.jsp" class="link-btn">Return to Main Menu</a>
        </div>
    </div>
</body>
</html>
