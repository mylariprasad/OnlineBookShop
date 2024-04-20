<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Failed to Add Book</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('https://monsterspost.com/wp-content/uploads/2020/06/online-bookstore.jpg');
            background-size: 100% 100%;
            background-repeat: no-repeat;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .container {
            max-width: 600px;
            margin: 100px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h1 {
            color: #333;
        }
        p {
            color: #cc0000;
            font-size: 18px;
            margin-bottom: 20px;
        }
        .try-again-btn {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }
        .try-again-btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Failed to Add Book</h1>
        <p>Sorry, there was an error adding the book to the database.</p>
        <a href="./uploadBook.jsp" class="try-again-btn">Try Again</a>
    </div>
</body>
</html>
