<%-- 
    Document   : confirmdelete
    Created on : Oct 26, 2024, 10:39:41 PM
    Author     : Logun
    Description: Confirmation page for deletion of items,
    displays information of item to be deleted and two buttons of yes and no.
    Yes deletes the item and returns user to products page with item gone,
    no simply returns user back to products page.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" media="screen" href="styles/myStyle.css" />
        <title>Product Maintenance</title>
    </head>
    <header>
        <h1 style="color: cadetblue">Are you sure you want to delete this product?</h1>
    </header>
    <body>
        <table>
            <tr><td>Code:</td><td>${product.code}</td></tr>
            <tr><td>Description:</td><td>${product.description}</td></tr>
            <tr><td>Price:</td><td>${product.priceCurrencyFormat}</td></tr>
        </table>
        <div class="button-group">
            <input type="button" value="Yes" onClick="window.location.href = 
                    'music?action=deleteYes&code=${product.code}'";/>
            <input type="button" value="No" onClick="window.location.href = 
                    'music?action=deleteNo'";/>
        </div>
        
        
    </body>
</html>
