<%@ page import="java.util.List" %>
<%@ page import="in.ineuron.dto.Transaction" %>
<%@ page import="in.ineuron.dto.Customer" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Profile</title>
    <style>
         body {
            font-family: Arial, sans-serif;
            background-image: url('https://monsterspost.com/wp-content/uploads/2020/06/online-bookstore.jpg');
            background-size: 100% 100%;
            background-repeat: no-repeat;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1, h2 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            text-align: center; /* Center align table contents */
        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px;
        }
        th {
            background-color: #f0f0f0;
            font-weight: bold;
        }
        .main-menu-btn {
            display: block;
            width: 120px;
            margin: 20px auto;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
        }
        .main-menu-btn:hover {
            background-color: #0056b3;
        }
        .customer-details {
            margin-bottom: 20px;
            border-left: 5px solid #007bff;
            padding-left: 10px;
        }
        .customer-details p {
            margin: 5px 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Profile Details:</h1>
        
        <div class="customer-details">
            <% 
                Object customerObj = session.getAttribute("customer");
                if (customerObj != null){
                    Customer customer = (Customer) customerObj;
            %>
            <p><strong>ID:</strong> <%= customer.getCid() %></p>
            <p><strong>Name:</strong> <%= customer.getCname() %></p>
            <p><strong>Email:</strong> <%= customer.getCemail() %></p>
            <p><strong>Address:</strong> <%= customer.getCaddress() %></p>
            <% } %>
        </div>
        
        <hr>
        
        <h2>History:</h2>
        <% 
            List<Transaction> transactionsList = (List<Transaction>) request.getAttribute("TransactionsList");
            if (transactionsList == null || transactionsList.isEmpty()) {
        %>
        <p>No history available.</p>
        <% } else { %>
        <table>
            <tr>
                <th>Transaction Id</th>
                <th>Transaction Type</th>
                <th>Book Name</th>
            </tr>
            <% 
                for (Transaction transaction : transactionsList) {
            %>
            <tr>
                <td><%= transaction.getTransaction_id() %></td>
                <td><%= transaction.getTransaction_type() %></td>
                <td><%= transaction.getBook_name() %></td>
            </tr>
            <% } %>
        </table>
        <% } %>

        
        <a href="../Main.jsp" class="main-menu-btn">Main Menu</a>
    </div>
</body>
</html>
