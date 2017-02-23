package jpabook.embeddedid;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by lse0101 on 2017-02-15.
 */
public class EmbeddedIdTest {
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
        ChildId childId = new ChildId();
        childId.setParentId("parent1");
        childId.setId("childId1");
        Child child = em.find(Child.class, childId);

        System.out.println("parent name " + child.getParent().getName());

        tx.commit();
        em.close();
    }

    private static void testSave() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Parent parent = new Parent();
        parent.setId("parent1");
        parent.setName("parentName(EmbeddedIdTest)");
        em.persist(parent);

        Child child = new Child();

        ChildId childId = new ChildId();
        childId.setId("childId1");

        child.setParent(parent);
        child.setId(childId);
        child.setName("childName(embeddedId)");
        em.persist(child);

        GrandChild grandChild = new GrandChild();

        GrandChildId grandChildId = new GrandChildId();
        grandChildId.setGrandChildId("grandChildId");

        grandChild.setId(grandChildId);
        grandChild.setName("grandChildName(embeddedId)");
        grandChild.setChild(child);
        em.persist(grandChild);

        tx.commit();
        em.close();
    }
}
