package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by lse0101 on 2017-02-10.
 */
public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaBook");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            logic(em);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        
        emf.close();
    }

    private static void logic(EntityManager em) {
        String id = "id1";

        Member member = new Member();
        member.setId(id);
        member.setUsername("지한");
        member.setAge(2);

        System.out.println("persist");
        em.persist(member);

        System.out.println("modify");
        member.setAge(20);

        System.out.println("find");
        Member findMember = em.find(Member.class, id);
        System.out.println("findMember"+ findMember.toString());

        System.out.println("JPQL");
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("member.size="+members.size());

        em.remove(member);

    }
}
