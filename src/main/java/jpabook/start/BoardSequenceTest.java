package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by lse0101 on 2017-02-13.
 */
public class BoardSequenceTest {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaBook");

    public static void main(String[] args) {
        sequenceInsert();
        emf.close();
    }

    private static void sequenceInsert() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Board newBoard = null;

        for(int i = 0; i < 51; i++) {
            newBoard = new Board();
            newBoard.setContent("content_"+i);

            em.persist(newBoard);
        }

        tx.commit();
        em.close();
    }
}
