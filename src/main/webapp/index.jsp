<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Teacher and Student List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
        }
        .main{
            max-width: 10000px;
            background-color: #fff;
        }
        h1 {
            text-align: center;
            font-size: 36px;
            margin-bottom: 10px;
        }
        p {
            text-align: center;
            font-size: 18px;
            margin-top: 0;
        }
        .btn {
            display: block;
            width: 150px;
            height: 40px;
            margin: 20px auto;
            background-color: #007bff;
            color: #fff;
            text-align: center;
            line-height: 40px;
            font-size: 18px;
            border-radius: 4px;
            text-decoration: none;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #07fd1d;
            color: #007bff;
            transform: scale(1.2);
            transition: transform 0.2s ease-in-out;
        }
        .table {
            margin-top: 30px;
            border-collapse: collapse;
            width: 100%;
            text-align: left;
        }
        .table th, .table td {
            padding: 50px;
            border: 1px solid #ddd;
        }
        .table th {
            background-color: #f5f5f5;
            font-weight: bold;
        }
        .table img {
            display: block;
            margin: 0 auto;
            width: 150px;
            height: 150px;
            object-fit: cover;
            border-radius: 50%;
        }
        .title {
            text-align: center;
            font-size: 36px;
            margin-top: 30px;
            margin-bottom: 10px;
        }
        .subtitle {
            text-align: center;
            font-size: 18px;
            margin-top: 0;
        }
    </style>
</head>
<body>
<div class="main">
    <div class="container">
        <h1>University Managment System</h1>
        <table class="table">
            <tr>
                <td>
                    <img src="https://pbs.twimg.com/profile_images/1391062171023446020/VvsH1Her_400x400.jpg" alt="Teacher" />
                    <h2 class="title">Teacher List</h2>
                    <p class="subtitle">You can view the full list of teachers of our university here.</p>
                    <a href="teacher-list.jsp" class="btn">Go Teacher List</a>
                </td>
                <td>
                    <img src="https://static.vecteezy.com/system/resources/thumbnails/007/746/077/small_2x/cute-little-boy-student-posing-cartoon-illustration-cartoon-clipart-vector.jpg" alt="Student" />
                    <h2 class="title">Student List</h2>
                    <p class="subtitle">You can view the full list of students of our university here.</p>
                    <a href="student-list.jsp" class="btn">Go Student List</a>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
