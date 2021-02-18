<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<style>
    table {
        width: 100%; /* Ширина таблицы */
        background: black; /* Цвет фона таблицы */
        color: black; /* Цвет текста */
        border-spacing: 1px; /* Расстояние между ячейками */
    }
    td, th {
        background: whitesmoke; /* Цвет фона ячеек */
        padding: 5px; /* Поля вокруг текста */
    }
</style>

<table>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th></th>
        <th></th>
    </tr>


    <tr>
        <c:forEach var="mealsTo" items="${list}">
        <td>${mealsTo.dateTime}</td>
        <td>${mealsTo.description}</td>
        <td>${mealsTo.calories}</td>
            <td><a href="">UPDATE</a></td>
            <td><a href="">DELETE</a></td>
    <tr>
    </tr>
    </c:forEach>
    </tr>
</table>

</body>
</html>
