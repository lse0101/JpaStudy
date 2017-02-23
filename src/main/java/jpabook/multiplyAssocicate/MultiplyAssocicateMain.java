package jpabook.multiplyAssocicate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by lse0101 on 2017-02-15.
 */
public class MultiplyAssocicateMain {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaBook");

    public static void main(String[] args) {
        save();
        find();
//        reversefind();
        emf.close();
    }

    private static void reversefind() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Product product = em.find(Product.class, "productA");

        tx.begin();
        em.close();
    }

    private static void find() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Order order = em.find(Order.class, 1L);

        Member member = order.getMember();
        Product product = order.getProduct();

        System.out.println("Member = " + member.getUsername());
        System.out.println("product = " + product.getName());

        tx.commit();
        em.close();
    }

    private static void save() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Member member1 = new Member();
        member1.setId("member1");
        member1.setUsername("회원1");
        em.persist(member1);

        Product productA = new Product();
        productA.setId("productA");
        productA.setName("상품A");
        em.persist(productA);

        Order order = new Order();
        order.setMember(member1);
        order.setProduct(productA);
        order.setOrderAmount(1);
        em.persist(order);

        tx.commit();
        em.close();
    }
}
