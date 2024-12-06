<%-- 
    Class      : CIS175 - Java II
    Document   : index.jsp
    Created on : Oct 23, 2024
    Author     : Caleb Burns
    Contact    : cdburns1@dmacc.edu
    Description: Opening page for the web application.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="text/html" />
        <title>Music Products</title>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" type="text/css" media="screen" href="styles/myStyle.css" />
    </head>
    <body>
        <header><h1>Music Products</h1></header>
        <main>
            <div class="main-text">
                <h3>Use the button below to add, edit or delete music products on a different page.</h3>
            </div>
            <div class="button-group">
                <!--On click, button goes to servlet and is handled there-->
                <button id='manage-button' class='buttons' type='button' onclick="window.location.href = 'music?action=manage';">Manage Products</button>
            </div>   
        </main>
        <!--JavaScript to change button color on hover-->
        <script>
            const MANAGEBUTTON = document.getElementById("manage-button");

            MANAGEBUTTON.addEventListener("mouseover", function () {
                MANAGEBUTTON.style.backgroundColor = "gray";
            });
            MANAGEBUTTON.addEventListener("mouseout", function () {
                MANAGEBUTTON.style.backgroundColor = "#e9e7e7";
            });
        </script> 
    </body>
</html>
