/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package music.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import music.business.Product;
import music.data.ProductIO;

/**
 *
 * @author burns
 */
@WebServlet("/music")

public class ProductController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // calls doPost
        doPost(request, response);
    }
    
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String url = "";
        String productCode = "";
        Product product;
//      Added switch case to handle edit pages
        switch (action){
            case "save":
                url = save(request, response);
                break;
            case "manage":
                url = manage(request, response);
                break;
            // moved to doPost method
            case "edit":
                url = edit(request, response);
                break;
            // Delete cases for delete link on products page
            // and yes/no buttons on confirmdelete page
            case "delete":
                productCode = request.getParameter("code");
                product = ProductIO.selectProduct(productCode);
                request.setAttribute("product", product);
                url = "/confirmdelete.jsp";
                break;
            case "deleteYes":
                productCode = request.getParameter("code");
                product = ProductIO.selectProduct(productCode);
                ProductIO.deleteProduct(product);
                List<Product> products = ProductIO.selectProducts();
                request.setAttribute("productsList", products);
                url = "/products.jsp";
                break;
            case "deleteNo":
                products = ProductIO.selectProducts();
                request.setAttribute("productsList", products);
                url = "/products.jsp";
                break;
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    private String manage(HttpServletRequest request,
            HttpServletResponse response) {

//      Grabs path for ProductIO and then grabs all products from product.txt
        String path = getServletContext().getRealPath("/WEB-INF/classes/music/product.txt");
        ProductIO.init(path);
        List<Product> products = ProductIO.selectProducts();

//        Make productsList available for products.jsp
        request.setAttribute("productsList", products);
        return "/products.jsp";
    }
//      Pulls product from productIO to be available for editing on the product page
    private String edit(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        Product product = ProductIO.selectProduct(code);
        request.setAttribute("product", product);
        return "/product.jsp";
    }
//      Handles logic for adding a new product or updating an already made product
    private String save(HttpServletRequest request, HttpServletResponse response){
        String code = request.getParameter("code");
        String description = request.getParameter("description");
        double price = 0.0;
        
//      checking for a valid price input or giving an error message if incorrect
        try{
            price = Double.parseDouble(request.getParameter("price"));
        }catch (NumberFormatException e){
            request.setAttribute("error", "The price given was invalid please try again.");
            return "/product.jsp";
        }
        
        if (ProductIO.exists(code)) {
        Product product = ProductIO.selectProduct(code);
        if (product != null) {
            product.setDescription(description);
            product.setPrice(price);
            ProductIO.updateProduct(product);
        }
    } else {
        Product newProduct = new Product();
        newProduct.setCode(code);
        newProduct.setDescription(description);
        newProduct.setPrice(price);
        ProductIO.insertProduct(newProduct);
    }
        
        return manage(request, response);
        
    }
    
    
}
