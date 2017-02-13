package jpabook.associcate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by lse0101 on 2017-02-13.
 */
public class AssocicateTest {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaBook");

    public static void main(String[] args) {
        testSave();
        testObjectGraph();
        testJPQL();

        emf.close();
    }

    private static void testJPQL() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        List<Member> memberList = em.createQuery("select m from Member m join m.team t where t.name = :teamName")
            .setParameter("teamName", "team1")
            .getResultList();

        for (Member member : memberList) {
            System.out.println(member);
        }

        tx.commit();
        em.close();
    }

    private static void testObjectGraph() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member = em.find(Member.class, "member1");

        System.out.println(member);

        tx.commit();
        em.close();
    }

    private static void testSave() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Team team = new Team();
        team.setId("team1");
        team.setName("team1");
        em.persist(team);

        Member member1 = new Member();
        member1.setId("member1");
        member1.setUsername("회원1");
        member1.setTeam(team);
        em.persist(member1);

        Member member2 = new Member();
        member2.setId("member2");
        member2.setUsername("회원2");
        member2.setTeam(team);
        em.persist(member2);

        tx.commit();
        em.close();
    }
}
