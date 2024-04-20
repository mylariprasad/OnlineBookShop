<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
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
            width: 80%;
            max-width: 700px;
            height: 40vh;
            padding: 40px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            display: flex;
            flex-direction: column;
            justify-content: space-around;
            position: relative;
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }
        .profile-button {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            text-transform: uppercase;
            font-weight: bold;
            cursor: pointer;
        }
        .logout-button {
            background-color: #dc3545;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            text-transform: uppercase;
            font-weight: bold;
            cursor: pointer;
            position: absolute;
            top: 25px;
            right: 55px;
        }
        .options {
            display: flex;
            justify-content: space-between;
        }
        .option-button {
            flex-grow: 1;
            background-color: #28a745;
            color: #fff;
            border: none;
            padding: 15px;
            border-radius: 5px;
            text-align: center;
            text-transform: uppercase;
            font-weight: bold;
            cursor: pointer;
            margin: 0 10px;
            transition: background-color 0.3s ease;
        }
        .option-button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Welcome to Main Menu</h1>
            <button class="profile-button" onclick="viewProfile()">View Profile</button>
            <button class="logout-button" onclick="logout()">Logout</button>
        </div>
        <div class="options">
            <button class="option-button" onclick="buyBook()">Buy a Book</button>
            <button class="option-button" onclick="sellBook()">Sell a Book</button>
        </div>
    </div>

    <script>
        function viewProfile() {
            window.location.href = './customer/profile';
        }

        function buyBook() {
            window.location.href = './book/fetch';
        }

        function sellBook() {
            window.location.href = './uploadBook.jsp';
        }

        function logout() {
            window.location.href = './index.jsp';
        }
    </script>
</body>
</html>
