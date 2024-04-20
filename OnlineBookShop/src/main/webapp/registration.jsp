<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration form</title>
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
            width: 400px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px;
        }
        input[type="text"], input[type="password"], input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
    <h1 align="center">Register Below</h1>
        <form method="post" action="./customer/registration">
            <table align='center'>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name='cname' /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name='cemail' /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name='cpassword' /></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name='caddress' /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value='Save' /></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
