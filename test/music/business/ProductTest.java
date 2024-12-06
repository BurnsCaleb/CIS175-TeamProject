package music.business;

import org.junit.Test;
import static org.junit.Assert.*;

/*
    Class      : CIS175 - Java II
    Document   : ProductTest.java
    Author     : Logun Van Luong
    Contact    : lvanluong@dmacc.edu
    Description: Unit tests for Product class.
*/

public class ProductTest {
    
    public ProductTest() {
    }
    

    /**
     * Test of getId method, of class Product.
     Unused/Unsupported
    @Test
    public void testGetId() {
        System.out.println("getId");
        Product instance = new Product();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
    }
*/
    /**
     * Test of setId method, of class Product.
     Unused/Unsupported
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long productId = null;
        Product instance = new Product();
        instance.setId(productId);
    }
*/
    
    /**
     * Test of setCode method, of class Product.
     */
    @Test
    public void testSetCode() {
        System.out.println("setCode");
        String code = "982";
        Product instance = new Product();
        instance.setCode(code);
        assertEquals(code, instance.getCode());
    }

    /**
     * Test of getCode method, of class Product.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        Product instance = new Product();
        String expResult = "456";
        instance.setCode("456");
        String result = instance.getCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Product.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "86 (the band) - True Life Songs and Pictures";
        Product instance = new Product();
        instance.setDescription(description);
        assertEquals(description, instance.getDescription());
    }

    /**
     * Test of getDescription method, of class Product.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Product instance = new Product();
        instance.setDescription("86 (the band) - True Life Songs and Pictures");
        String expResult = "86 (the band) - True Life Songs and Pictures";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getArtistName method, of class Product.
     */
    @Test
    public void testGetArtistName() {
        System.out.println("getArtistName");
        Product instance = new Product();
        instance.setDescription("86 (the band) - True Life Songs and Pictures");
        String expResult = "86 (the band)";
        String result = instance.getArtistName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAlbumName method, of class Product.
     */
    @Test
    public void testGetAlbumName() {
        System.out.println("getAlbumName");
        Product instance = new Product();
        instance.setDescription("86 (the band) - True Life Songs and Pictures");
        String expResult = "True Life Songs and Pictures";
        String result = instance.getAlbumName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPrice method, of class Product.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double price = 12.5;
        Product instance = new Product();
        instance.setPrice(price);
        assertEquals(price, instance.getPrice(), 0.01);
    }

    /**
     * Test of getPrice method, of class Product.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Product instance = new Product();
        instance.setPrice(12.5);
        double expResult = 12.5;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of getPriceCurrencyFormat method, of class Product.
     */
    @Test
    public void testGetPriceCurrencyFormat() {
        System.out.println("getPriceCurrencyFormat");
        Product instance = new Product();
        instance.setPrice(12.5);
        String expResult = "$12.50";
        String result = instance.getPriceCurrencyFormat();
        assertEquals(expResult, result);
    }

    /**
     * Test of getImageURL method, of class Product.
     */
    @Test
    public void testGetImageURL() {
        System.out.println("getImageURL");
        Product instance = new Product();
        instance.setCode("546");
        String expResult = "/musicStore/images/546_cover.jpg";
        String result = instance.getImageURL();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProductType method, of class Product.
     */
    @Test
    public void testGetProductType() {
        System.out.println("getProductType");
        Product instance = new Product();
        String expResult = "Audio CD";
        String result = instance.getProductType();
        assertEquals(expResult, result);
    }
    
}
