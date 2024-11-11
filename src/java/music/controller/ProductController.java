package music.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import music.business.Product;
import music.data.ProductDB;

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
        switch (action) {
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
                product = ProductDB.selectProduct(productCode);
                request.setAttribute("product", product);
                url = "/confirmdelete.jsp";
                break;
            case "deleteYes":
                productCode = request.getParameter("code");
                product = ProductDB.selectProduct(productCode);
                ProductDB.delete(product);
                List<Product> products = ProductDB.selectProducts();
                request.setAttribute("productsList", products);
                url = "/products.jsp";
                break;
            case "deleteNo":
                products = ProductDB.selectProducts();
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

//      Grabs products from database
        List<Product> products = ProductDB.selectProducts();

//        Make productsList available for products.jsp
        request.setAttribute("productsList", products);
        return "/products.jsp";
    }

//      Pulls product from database to be available for editing on the product page
    private String edit(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        Product product = ProductDB.selectProduct(code);
        request.setAttribute("product", product);
        return "/product.jsp";
    }

//      Handles logic for adding a new product or updating an already made product
    private String save(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        String description = request.getParameter("description");
        double price = 0.0;

        if (code == null || code.trim().isEmpty()) {
            request.setAttribute("errorCode", "Product Code is required.");
        }
        if (description == null || description.trim().isEmpty()) {
            request.setAttribute("errorDescription", "Description is required.");
        }
        
//      checking for a valid price input or giving an error message if incorrect
        try{
            price = Double.parseDouble(request.getParameter("price"));
            if (price <= 0) {
                request.setAttribute("errorPrice", "Price must be a positive number.");
            }
        }catch (NumberFormatException e){
            request.setAttribute("errorPrice", "The price given was a invalid number please try again.");
            
        }
        if (request.getAttribute("errorCode") != null || request.getAttribute("errorDescription") != null || request.getAttribute("errorPrice") != null) {   
            return "/product.jsp";
        }

        if (ProductDB.exists(code)) {   //Update
            Product product = ProductDB.selectProduct(code);
            if (product != null) {
                product.setDescription(description);
                product.setPrice(price);
                ProductDB.update(product);
            }
        } else {    //New
            Product newProduct = new Product();
            newProduct.setCode(code);
            newProduct.setDescription(description);
            newProduct.setPrice(price);
            
            ProductDB.insert(newProduct);        
        }

        return manage(request, response);

    }

}
