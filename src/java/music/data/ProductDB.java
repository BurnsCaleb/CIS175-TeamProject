package music.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import music.business.Product;

/**
 *
 * @author burns
 */
public class ProductDB {

    public static int insert(Product product) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "INSERT INTO PRODUCT (ProductCode, ProductDescription, ProductID, ProductPrice)"
                + " VALUES (?, ?, ?, ?)";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getDescription());
            ps.setInt(3, 0);        // Database autoincrements
            ps.setDouble(4, product.getPrice());

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int update(Product product) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "UPDATE PRODUCT"
                + " SET ProductDescription = ?, ProductPrice = ?"
                + " WHERE ProductCode = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getDescription());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getCode());

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int delete(Product product) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM Product WHERE ProductCode = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getCode());

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static boolean exists(String productCode) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        boolean exists = false;

        String query = "SELECT CASE WHEN EXISTS(SELECT 1 FROM Product WHERE ProductCode = ?) then 'true' else 'false' end;";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, productCode);
            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    String result = rs.getString(1);
                    
                    exists = Boolean.parseBoolean(result);
                    System.out.println("After reading query:");
                    System.out.println(exists);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
            return exists;
        }
    }

    public static Product selectProduct(String productCode) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "SELECT *"
                + " FROM Product"
                + " WHERE ProductCode = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, productCode);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Product product = new Product();
                    product = new Product();
                    product.setCode(rs.getString("ProductCode"));
                    product.setDescription(rs.getString("ProductDescription"));
                    product.setId((long) rs.getInt("ProductId"));
                    product.setPrice(rs.getDouble("ProductPrice"));

                    return product;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return null;
    }

    public static List<Product> selectProducts() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        List<Product> products = new ArrayList<>();

        String query = "SELECT * FROM Product";

        try {
            ps = connection.prepareStatement(query);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setCode(rs.getString("ProductCode"));
                    product.setDescription(rs.getString("ProductDescription"));
                    product.setId((long) rs.getInt("ProductId"));
                    product.setPrice(rs.getDouble("ProductPrice"));

                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

        return products;
    }
}
