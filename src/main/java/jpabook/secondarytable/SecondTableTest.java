package jpabook.secondarytable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by lse0101 on 2017-02-15.
 */
public class SecondTableTest {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaBook");
    public static void main(String[] args) {
       testSave();
       emf.close();
    }

    private static void testSave() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Board board = new Board();
        board.setTitle("board title");
        board.setContent("sencond table content");

        em.persist(board);
        tx.commit();
        em.close();
    }
}
