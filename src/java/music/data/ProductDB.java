package music.data;

import java.util.List;
import music.business.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/*
    Class      : CIS175 - Java II
    Document   : ProductDB.java
    Author     : Caleb Burns, Ian McElderry
    Contact    : cdburns1@dmacc.edu, ipmcelderry@dmacc.edu
    Description: Functions for database interactions.
*/
public class ProductDB {

    public static void insert(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(product);
            trans.commit();
        }
        catch (Exception ex) {
            trans.rollback();
            System.out.println(ex);
        }
        finally {
            em.close();
        }
    }

    public static void update(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {    
            em.merge(product);
            trans.commit();
        }
        catch (Exception ex) {
            System.out.println(ex);
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    public static void delete(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(product));
            trans.commit();
        }
        catch (Exception ex) {
            System.out.println(ex);
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    public static boolean exists(String productCode) {
        Product item = selectProduct(productCode);
        
        return (item != null);
    }

    public static Product selectProduct(String productCode) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT i FROM Product i " + 
                "WHERE i.code = :code";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        q.setParameter("code", productCode);
        
        Product item = null;
        try {
            item = q.getSingleResult();
        }
        catch (NoResultException ex) {
            System.out.println(ex);
        }
        finally {
            em.close();
        }
        return item;
    }

    public static List<Product> selectProducts() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT i FROM Product i";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        
        List<Product> items;
        try {
            items = q.getResultList();
            if (items == null || items.isEmpty()) {
                items = null;
            }
        }
        finally {
            em.close();
        }
        return items;
    }
}
