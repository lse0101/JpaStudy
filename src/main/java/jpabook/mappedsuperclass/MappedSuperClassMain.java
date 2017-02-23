package jpabook.mappedsuperclass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by lse0101 on 2017-02-15.
 */
public class MappedSuperClassMain {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaBook");
    public static void main(String[] args) {
       save();
    }

    private static void save() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Member member = new Member();
        member.setName("memberName");
        member.setEmail("email");
        em.persist(member);

        tx.commit();
        em.close();
    }
}
