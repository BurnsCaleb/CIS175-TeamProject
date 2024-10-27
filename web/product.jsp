<%-- 
    Document   : product
    Created on : Oct 23, 2024, 12:24:48 PM
    Author     : Ian McElderry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%-- Title has a switch case statement based on if the product fields are empty it will say Add or Editing for the product --%>
        <title>${product != null? "Editing Product" : "Adding Product"}</title>
    </head>
    <body>
        <%-- Same can be found for the input as if the product is being edited instead of added the fields will populate with the needed data or be blank --%>
        <form method="post" action="music?action=save">
            
            <label for="code">Product Code:</label>
            <input type="text" id="code" name="code" value="${product != null ? product.code : ''}" required />

            <label for="description">Description:</label>
            <input type="text" id="description" name="description" value="${product != null ? product.description : ''}" required />

            <label for="price">Price:</label>
            <input type="text" id="price" name="price" value="${product != null ? product.price : ''}" required />
            
            <input type="hidden" name="id" value="${product.id}"/>
            
            <button type="submit">${product != null ? "Update Product" : "Add Product"}</button>
            <button type="button"onclick="window.location.href='music?action=manage'">Cancel</button>
                
        </form>
    </body>
</html>

