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
        <style>
            .error{
                color:red;
                display:none;
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
            button {
                margin-top: 20px;
            }
        </style>
        <script>
            // Function created to validate form with custom tags
            function validatemyForm(){
                let isValid = true;
                const code = document.getElementById("code");
                const codeErr = document.getElementById("codeError");
                //Checks to see if the product input is empty and displays error message if that is the case
                //Otherwise error message is hidden and you are able to continue
                if(!code.value.trim()){
                    codeErr.textContent = "Product Code is Required to complete the entry.";
                    codeErr.style.display = "block";
                    isValid = false;
                }else{
                    codeErr.style.display = "none";
                }
                //Checks to see if the description is empty and will display corresponding error message
                //hides error message if it is not empty 
                const description = document.getElementById("description");
                const descriptionErr = document.getElementById("descriptionError");
                if(!description.value.trim()){
                    descriptionErr.textContent = "Description is required to complete the entry";
                    descriptionErr.style.display = "block";
                    isValid = false;
                } else{
                    descriptionErr.style.display = "none";
                }
                //Checks to see if the price is empty or if it is negative and prints out an error message
                //Will hide error message if it is not empty and or not negative
                const price = document.getElementById("price");
                const priceErr = document.getElementById("priceError");
                const priceValue = parseFloat(price.value);
                if (isNaN(priceValue) || priceValue <=0){
                    priceErr.textContent = "Price cannot be a negative number and is required to complete the form.";
                    priceErr.style.display = "block";
                    isValid = false;
                }else{
                    priceErr.style.display = "none";
                }
                return isValid;
            }
        </script>
    </head>
    <body>
      
        <form method="post" action="music?action=save" onsubmit="return validatemyForm()">
           <div>
            <label for="code">Product Code:</label>
            <input type="text" id="code" name="code" value="${product != null ? product.code : ''}"/>
            <div id="codeError" class="error"></div>
           </div>
           <div>
            <label for="description">Description:</label>
            <input type="text" id="description" name="description" value="${product != null ? product.description : ''}"/>
            <div id="descriptionError" class="error"></div>
           </div>
           <div>
            <label for="price">Price:</label>
            <input type="text" id="price" name="price" value="${product != null ? product.price : ''}"/>
             <div id="priceError" class="error"></div>
           </div>
            <input type="hidden" name="id" value="${product.id}"/>
            
            <button type="submit">${product != null ? "Update Product" : "Add Product"}</button>
            <button type="button"onclick="window.location.href='music?action=manage'">Cancel</button>
                
        </form>
    </body>
</html>