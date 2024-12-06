<%-- 
    Class      : CIS175 - Java II
    Document   : products.jsp
    Created on : Oct 23, 2024
    Author     : Caleb Burns
    Contact    : cdburns1@dmacc.edu
    Description: Display all products in a table.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="text/html" />
        <title>Manage Products</title>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" type="text/css" media="screen" href="styles/myStyle.css" />
    </head>
    <body>
        <header><h1>Manage Products</h1></header>
        <table>
            <tr>
                <!--Table headers-->
                <!--Last one empty for delete button-->
                <th>Code</th>
                <th>Description</th>
                <th>Price</th>
                <!--Added the Add product button to add a product on the products.jsp page-->
                <th>
                    <button id="add-button" class="buttons" type="button" onclick="window.location.href='product.jsp';">Add Product</button>
                </th>
                <th></th>
            </tr>

            <c:forEach var="product" items="${productsList}">
                <tr>
                    <td>${product.code}</td>
                    <td>${product.description}</td>
                    <td>${product.priceCurrencyFormat}</td>
                    <!--On button click, the product code is sent to the servlet to be handled-->
                    <td><a href="music?action=edit&code=${product.code}">Edit</a></td>
                    <td><a href="music?action=delete&code=${product.code}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>