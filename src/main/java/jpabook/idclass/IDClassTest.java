package jpabook.idclass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by lse0101 on 2017-02-15.
 */
public class IDClassTest {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaBook");

    public static void main(String[] args) {
        saveTest();
    }

    private static void saveTest() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Parent parent = new Parent();
        parent.setId("parent1");
        parent.setName("parentName");

        em.persist(parent);

        Child child = new Child();
        child.setParent(parent);
        child.setChildId("child1");
        child.setName("childName");
        em.persist(child);

        GrandChild grandChild = new GrandChild();
        grandChild.setChild(child);
        grandChild.setId("grandChild1");
        grandChild.setName("grandChildName");
        em.persist(grandChild);

        tx.commit();
        em.close();
    }
}
