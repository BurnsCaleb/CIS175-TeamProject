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
        String action = request.getParameter("action");
        String url = "";
        
//        TODO: change to switch case to handle edit and delete pages
        if (action.equals("manage")) {
            url = manage(request, response);
        }

        getServletContext().getRequestDispatcher(url)
                .forward(request, response);
    }

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String url = "";
//        TODO: change to switch case to handle edit and delete pages
        if (action.equals("manage")) {
            url = manage(request, response);
        }

        getServletContext().getRequestDispatcher(url)
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
}
