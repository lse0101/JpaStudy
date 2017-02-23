package jpabook.associcate1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by lse0101 on 2017-02-14.
 */
public class TestAssocicate1 {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaBook");

    public static void main(String[] args) {
       testSave();

       emf.close();
    }

    private static void testSave() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Member member1 = new Member("member1","회원1");
        Member member2 = new Member("member2","회원2");

        Team team1 = new Team("team1", "회원1");
        team1.getMembers().add(member1);
        team1.getMembers().add(member2);

        em.persist(member1);
        em.persist(member2);
        em.persist(team1);

        tx.commit();
        em.close();
    }
}
