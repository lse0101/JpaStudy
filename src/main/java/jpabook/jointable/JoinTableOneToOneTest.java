package jpabook.jointable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by lse0101 on 2017-02-15.
 */
public class JoinTableOneToOneTest {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaBook");
    public static void main(String[] args) {
       testSave();
       testFind();
       emf.close();
    }

    private static void testFind() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Parent parent = em.find(Parent.class, 1L);

        System.out.println("parent name: "+parent.getName());
        System.out.println("child name: " + parent.getChild().getName());


        tx.commit();
        em.close();
    }

    private static void testSave() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Parent parent = new Parent();
        parent.setName("joinTable parent");
        em.persist(parent);

        Child child = new Child();
        child.setName("joinTable child");
        em.persist(child);

        parent.setChild(child);

        tx.commit();
        em.close();
    }
}
