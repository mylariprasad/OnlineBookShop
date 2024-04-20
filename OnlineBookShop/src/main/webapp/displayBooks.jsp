<%@ page import="java.util.List" %>
<%@ page import="in.ineuron.dto.Books" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Books</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('https://monsterspost.com/wp-content/uploads/2020/06/online-bookstore.jpg');
            background-size: 100% 100%;
            background-repeat: no-repeat;
            margin: 0;
            padding: 0;
            
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f0f0f0;
            font-weight: bold;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .buy-btn {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 8px 16px;
            border-radius: 5px;
            cursor: pointer;
        }
        .buy-btn:hover {
            background-color: #0056b3;
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
        .search-container {
            margin-bottom: 20px;
        }
        .search-container input[type=text] {
            padding: 8px;
            margin-right: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .search-container input[type=submit] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 8px 16px;
            border-radius: 5px;
            cursor: pointer;
        }
        .search-container input[type=submit]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>List of Books</h1>
        
         <div class="search-container">
            <form method="post" action="./search">
                <input type="text" name="search" placeholder="Search by Book Name">
                <input type="submit" value="Search">
            </form>
        </div>
        
        <table border="1">
            <tr>
                <th>Book Id</th>
                <th>Name</th>
                <th>Author</th>
                <th>Price</th>
                <th>Condition</th>
                <th>Action</th>
            </tr>
            <% 
                Object obj = request.getAttribute("booksList");
                if (obj instanceof List) {
                    List<Books> booksList = (List<Books>) obj;
                    for (Books book : booksList) {
            %>
            <tr>
                <td><%= book.getId() %></td>
                <td><%= book.getName() %></td>
                <td><%= book.getAuthor() %></td>
                <td><%= book.getPrice() %></td>
                <td><%= book.getCondition() %></td>
                <td>
                    <form method="post" action="./buyBook">
                        <input type="hidden" name="bookName" value="<%= book.getName() %>">
                        <input type="submit" class="buy-btn" value="Buy">
                    </form>
                </td>
            </tr>
            <% 
                    }
                } else {
            %>
            <tr>
                <td colspan="5">No books found.</td>
            </tr>
            <% 
                }
            %>
        </table>
        
        <a href="../Main.jsp" class="main-menu-btn">Main Menu</a>
    </div>
</body>
</html>
