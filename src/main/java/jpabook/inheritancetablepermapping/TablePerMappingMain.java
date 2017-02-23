package jpabook.inheritancetablepermapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by lse0101 on 2017-02-15.
 */
public class TablePerMappingMain {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaBook");
    public static void main(String[] args) {
       save();
       saveBook();
       emf.close();
    }

    private static void saveBook() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Book book = new Book();
        book.setName("movie1");
        book.setAuthor("author");
        book.setIsbn("isbn");
        book.setPrice(3000);

        em.persist(book);

        tx.commit();
        em.close();
    }

    private static void save() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Movie movie1 = new Movie();
        movie1.setName("movie1");
        movie1.setActor("actor");
        movie1.setDirector("director");
        movie1.setPrice(3000);

        em.persist(movie1);

        tx.commit();
        em.close();
    }

}
