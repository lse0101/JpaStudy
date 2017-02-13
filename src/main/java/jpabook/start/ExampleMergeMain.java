package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by lse0101 on 2017-02-13.
 */
public class ExampleMergeMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaBook");

    public static void main(String[] args) {
        Member member = createMember("memberA", "회원1");

        System.out.println("first member tostring: "+ member.toString());
        member.setUsername("회원명변경");
        mergeMember(member);
    }

    private static Member createMember(String id, String username) {
        EntityManager em1 = emf.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();

        tx1.begin();

        Member member = new Member();
        member.setId(id);
        member.setUsername(username);
        member.setAge(15);

        em1.persist(member);
        tx1.commit();

        em1.close();

        return member;
    }

    static void mergeMember(Member member) {
        EntityManager em2 = emf.createEntityManager();
        EntityTransaction tx2 = em2.getTransaction();

        tx2.begin();
        Member mergeMember = em2.merge(member);
        System.out.println("member = "+member.getUsername());

        System.out.println("mergeMember toString "+ mergeMember.toString());
        System.out.println("mergeMeber = "+mergeMember.getUsername());
        System.out.println("em2 contains member = "+em2.contains(member));
        System.out.println("em2 contains mergeMember = "+em2.contains(mergeMember));

        em2.remove(mergeMember);
        tx2.commit();

        em2.close();
    }
}
