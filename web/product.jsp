<%-- 
    Document   : product
    Created on : Oct 23, 2024, 12:24:48 PM
    Author     : Ian McElderry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://example.com/custom" prefix="custom" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%-- Title has a switch case statement based on if the product fields are empty it will say Add or Editing for the product --%>
        <title>${product != null? "Editing Product" : "Adding Product"}</title>
        <style>
        .error {
            color: red;
            display: flex;
            margin-top: 5px;
        }
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
            width: 300px;
            padding: 20px;
            border: 1px solid #ccc;
        }
        label {
            margin-top: 10px;
        }
        input[type="text"] {
        padding: 8px;
        margin-bottom: 15px;
        font-size: 16px;
        border: 1px solid #ccc;
        border-radius: 4px;
        width: 100%;
        box-sizing: border-box;
        }
        button {
            margin-top: 20px;
        }
    
        .required {
            color: red;
        }
        </style>
        
    </head>
    <body>
      
        <form method="post" action="music?action=save">
            <div>
            <label for="code">
                <custom:requiredFieldTags fieldName="Product Code:" error="${errorCode}"/>
            </label>
                <input type="text" id="code" name="code" value="${product != null ? product.code : ''}"
                    <c:if test="${product != null}">readonly</c:if> />
                 <div id="codeError" class="error"></div>
            </div>
           <div>
            <label for="description">
                <custom:requiredFieldTags fieldName="Description:" error="${errorDescription}"/>
            </label>
            <input type="text" id="description" name="description" value="${product != null ? product.description : ''}"/>
            <div id="descriptionError" class="error"></div>
           </div>
           <div>
               <label for="price">
                   <custom:requiredFieldTags fieldName="Price:" error="${errorPrice}"/>
               </label>
            <input type="text" id="price" name="price" value="${product != null ? product.price : ''}"/>
             <div id="priceError" class="error"></div>
           </div>
            <input type="hidden" name="id" value="${product.id}"/>
            
            <button type="submit">${product != null ? "Update Product" : "Add Product"}</button>
            <button type="button"onclick="window.location.href='music?action=manage'">Cancel</button>
                
        </form>
    </body>
</html>
