<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dung
  Date: 10/28/2024
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 50px;
        }
        .calculator-container {
            border: 1px solid #ddd;
            padding: 20px;
            max-width: 300px;
        }
        .calculator-container h1 {
            font-size: 24px;
            text-align: center;
        }
        .calculator-container label {
            display: block;
            margin-top: 10px;
        }
        .calculator-container input[type="text"],
        .calculator-container select {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            box-sizing: border-box;
        }
        .calculator-container button {
            margin-top: 15px;
            width: 100%;
            padding: 10px;
            font-size: 16px;
        }
    </style>
</head>
<body>
<div class="calculator-container">
    <h1>Simple Calculator</h1>
    <form action="/calculator" method="post">
        <label for="first-operand">First operand:</label>
        <input type="text" id="first-operand" name="a" required>

        <label for="operator">Operator:</label>
        <select id="operator" name="operator" required>
            <option value="+">Addition</option>
            <option value="-">Subtraction</option>
            <option value="*">Multiplication</option>
            <option value="/">Division</option>
        </select>

        <label for="second-operand">Second operand:</label>
        <input type="text" id="second-operand" name="b" required>

        <button type="submit">Calculate</button>
    </form>
    <h2>Result: ${result}
    </h2>
</div>
</body>
</html>
