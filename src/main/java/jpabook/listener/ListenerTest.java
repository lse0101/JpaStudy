package jpabook.listener;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by lse0101 on 2017-03-02.
 */
public class ListenerTest {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaBook");
    public static void main(String[] args) {
        testEntityListener();
        testEntityListener1();
    }

    private static void testEntityListener1() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Duck1 duck1 = new Duck1();
        duck1.setName("duck1!!!!!!!!!!!!");

        em.persist(duck1);
        tx.commit();
        em.close();
    }

    private static void testEntityListener() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Duck duck = new Duck();
        duck.setName("duck!!!!");

        em.persist(duck);

        tx.commit();
        em.close();

    }
}
