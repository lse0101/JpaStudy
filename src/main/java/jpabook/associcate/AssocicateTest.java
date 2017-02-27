package jpabook.associcate;

import com.mysema.query.jpa.JPASubQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Projections;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by lse0101 on 2017-02-13.
 */
public class AssocicateTest {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaBook");

    public static void main(String[] args) {
        testSave();

//        testSaveWithCascade();
//        testRemoveWithCascade();
//        testObjectGraph();
//        testJPQL();
//        testJPQL1();
//        testCrieria();
//        testCrieria1();
//        testCriteria2();
//        testCriteria3();
//        testCriteriaJOIN();
//        testCriteriaSubQuery();
//        testCriteriaAssocicateSubQuery();
//        testCriteriaINExpression();
//        testCriteriaCaseExpression();
//        testCriteriaWithMetaModelgen();
//        testQueryDsl();
//        testQueryDsl1();
//        testQueryDsl2();
//        testQueryDsl3();
//        testQueryDsl4();
//        testQueryDsl5();

//        testQueryDSL();
//        updateRelation();
//        biDirection();
//        testORMbiDirection();
//        testSaveNonOwner();
//        deleteRelation();
//        testSave2();

        emf.close();
    }

    private static void testQueryDsl5() {
/*        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        JPAQuery q = new JPAQuery(em);
        QMember m = QMember.member;
        List<MemberDto> memberDtos = q.from(m)
                .where(m.age.gt(90))
                .list(Projections.constructor(MemberDto.class,m.username, m.age));

        for (MemberDto dto : memberDtos) {
            System.out.println(dto);
        }
        tx.commit();
        em.close();*/
    }

    private static void testQueryDsl4() {
/*        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        JPAQuery q = new JPAQuery(em);
        QMember m = QMember.member;
        QMember m1 = new QMember("m1");

        q.from(m)
                .where(m.age.eq(
                        new JPASubQuery().from(m1).unique(m1.age.max())
                ))
                .list(m);
        tx.commit();
        em.close();*/
    }

    private static void testQueryDsl3() {
/*        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        JPAQuery query = new JPAQuery(em);
        QTeam t = QTeam.team;
        QMember m = QMember.member;

        Team rt = query.from(t)
                .innerJoin(t.members, m).fetch()
                .where(m.username.eq("회원1"))
                .uniqueResult(t);

        System.out.println(rt.getMembers());

        tx.commit();
        em.close();*/
    }

    private static void testQueryDsl2() {
/*        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        JPAQuery query = new JPAQuery(em);
        QMember m = QMember.member;

        List<Member> members = query.from(m)
                                    .orderBy(m.age.asc())
                                    .offset(1)
                                    .limit(20)
                                    .list(m);

        for (Member member : members) {
            System.out.println(member);
        }

        tx.commit();
        em.close();*/
    }

    private static void testQueryDsl1() {
/*        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        JPAQuery query = new JPAQuery(em);
        QMember m = QMember.member;

        List<Member> list = query.from(m)
                .where(m.username.eq("회원1").or(m.age.gt(9)))
                .list(m);

        for (Member member : list) {
            System.out.println(member.getUsername());
        }

        tx.commit();
        em.close();*/
    }

    private static void testQueryDsl() {
/*        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        JPAQuery query = new JPAQuery(em);
        QMember member = new QMember("m");

        List<Member> members =
                query.from(member)
                        .where(member.username.eq("회원1"))
                        .orderBy(member.username.desc())
                        .list(member);

        tx.commit();
        em.close();*/
    }

    private static void testCriteriaWithMetaModelgen() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);

        Root<Member> m = cq.from(Member.class);
        cq.select(m);

        cq.where(cb.greaterThanOrEqualTo(m.get("age"), 9));

        List<Member> list = em.createQuery(cq).getResultList();

        for (Member member : list) {
            System.out.println(member.getUsername());
        }

        tx.commit();
        em.close();
    }

    private static void testCriteriaCaseExpression() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Member> m = cq.from(Member.class);
        cq.multiselect(m.get("username"),
                        cb.selectCase()
                        .when(cb.ge(m.<Integer>get("age"), 50), 60)
                        .when(cb.le(m.<Integer>get("age"), 15), 500)
                        .otherwise(1000));

        List<Object[]> memberList = em.createQuery(cq).getResultList();

        for (Object[] obj : memberList) {
            String name = (String)obj[0];
            Integer age = (Integer) obj[1];

            System.out.println("name: "+name+", age="+age);
        }


        tx.commit();
        em.close();
    }

    private static void testCriteriaINExpression() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);

        Root<Member> m = cq.from(Member.class);
        cq.select(m)
                .where(cb.in(m.get("username"))
                        .value("회원1")
                        .value("회원2"));

        em.createQuery(cq)
                .getResultList();

        tx.commit();
        em.close();
    }

    private static void testCriteriaAssocicateSubQuery() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> mainQuery = cb.createQuery(Member.class);

        Root<Member> m = mainQuery.from(Member.class);

        Subquery<Team> subquery = mainQuery.subquery(Team.class);
        Root<Member> t = subquery.correlate(m);

        Join<Member, Team> join = t.join("team");
        subquery.select(join)
                .where(cb.equal(join.get("name"), "team1"));

        mainQuery.select(m)
                .where(cb.exists(subquery));

        List<Member> resultList = em.createQuery(mainQuery).getResultList();


        tx.commit();
        em.close();
    }

    private static void testCriteriaSubQuery() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> mainQuery = cb.createQuery(Member.class);

        Root<Member> m = mainQuery.from(Member.class);
        Subquery<Double> subquery = mainQuery.subquery(Double.class);

        Root<Member> subM = subquery.from(Member.class);
        subquery.select(cb.avg(subM.get("age")));

        mainQuery.select(m)
                .where(cb.ge(m.get("age"), subquery));

        TypedQuery<Member> query = em.createQuery(mainQuery);
        query.getResultList();

        tx.commit();
        em.close();
    }

    private static void testCriteriaJOIN() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);

        Root<Member> m = cq.from(Member.class);
        Join<Member, Team> t = m.join("team", JoinType.INNER);

        cq.select(m)
            .where(cb.equal(t.get("name"), "team1"));

        TypedQuery<Member> query = em.createQuery(cq);

        List<Member> members = query.getResultList();

        for (Member member : members) {
            System.out.println("criteria JOIN: " + member.getUsername());
        }

        tx.commit();
        em.close();
    }

    private static void testCriteria3() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Member> m = cq.from(Member.class);

        Expression<Integer> maxAge = cb.max(m.<Integer>get("age"));
        cq.select(cb.array(m.get("team").get("name"), maxAge))
            .groupBy(m.get("team").get("name"));

        List<Object[]> resultLsit = em.createQuery(cq).getResultList();

        for (Object[] obj : resultLsit) {
            String name = (String)obj[0];
            Integer age = (Integer) obj[1];

            System.out.println("name = "+name+", "+age);
        }


        tx.commit();
        em.close();
    }

    private static void testCriteria2() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MemberDto> cq = cb.createQuery(MemberDto.class);

        Root<Member> m = cq.from(Member.class);
        cq.select(cb.construct(MemberDto.class, m.get("username"), m.<Integer>get("age")));

        TypedQuery<MemberDto> query = em.createQuery(cq);
        List<MemberDto> memberDtos = query.getResultList();

        for (MemberDto memberDto : memberDtos) {
            System.out.println("member dto - " + memberDto.getName());
        }

        tx.commit();
        em.close();
    }

    private static void testCrieria1() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);

        Root<Member> m = cq.from(Member.class);
        Predicate ageGt = cb.greaterThan(m.<Integer>get("age"), 10);

        cq.select(m)
                .where(ageGt)
                .orderBy(cb.desc(m.get("age")));


        List<Member> members = em.createQuery(cq).getResultList();

        for (Member member : members) {
            System.out.println("criteria 2 " + member.getUsername()+", " + member.getAge());
        }


        tx.commit();
        em.close();
    }

    private static void testJPQL1() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        List<Team> teamList = em.createQuery("select distinct t from Team t JOIN fetch t.members where t.name = :teamName", Team.class)
                                .setParameter("teamName", "team1")
                                .getResultList();

        for (Team team : teamList) {
            System.out.println(team.getName());

            for (Member member : team.getMembers()) {
                System.out.println(member.getUsername());
            }
        }

        tx.commit();
        em.close();
    }

    private static void testQueryDSL() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        tx.commit();
        em.close();
    }

    private static void testCrieria() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);

        Root<Member> m = cq.from(Member.class);

        Predicate usernameEqual = cb.equal(m.get("username"), "회원1");
        Order ageDesc = cb.desc(m.get("username"));

        cq.select(m)
                .where(usernameEqual)
                .orderBy(ageDesc);

        TypedQuery<Member> query = em.createQuery(cq);
        List<Member> member = query.getResultList();

        for (Member member1 : member) {
            System.out.println("criteria " + member1.getUsername());
        }

        tx.commit();
        em.close();
    }

    private static void testRemoveWithCascade() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Team team = em.find(Team.class, "team1");

        em.remove(team);

        tx.commit();
        em.close();
    }

    private static void testSaveWithCascade() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Team team = new Team();
        team.setId("team1");
        team.setName("team1");

        Member member1 = new Member();
        member1.setId("member1");
        member1.setUsername("회원1");

        Member member2 = new Member();
        member2.setId("member2");
        member2.setUsername("회원2");

        member1.setTeam(team);
        member2.setTeam(team);
        team.getMembers().add(member1);
        team.getMembers().add(member2);

        em.persist(team);

        tx.commit();
        em.close();
    }

    private static void testORMbiDirection() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Team team4 = new Team("team4", "팀3");
        em.persist(team4);

        Member member7 = new Member("member7", "회원7", 10);
        member7.setTeam(team4);
        em.persist(member7);

        Member member8 = new Member("member8", "회원8", 20);
        member8.setTeam(team4);
        em.persist(member8);

        tx.commit();
        em.close();
    }

    private static void testSaveNonOwner() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Member member5 = new Member("member5", "회원5", 10);
        em.persist(member5);

        Member member6 = new Member("member6", "회원6", 10);
        em.persist(member6);

        Team team1 = em.find(Team.class, "team1");
        team1.getMembers().add(member5);
        team1.getMembers().add(member6);

        em.persist(team1);

        tx.commit();
        em.close();
    }

    private static void testSave2() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Team team3 = new Team("team3", "팀3");
        em.persist(team3);

        Member member3 = new Member("member3", "회원3", 10);
        member3.setTeam(team3);
        em.persist(member3);

        Member member4 = new Member("member4", "회원4", 20);
        member4.setTeam(team3);
        em.persist(member4);

        tx.commit();
        em.close();
    }

    private static void biDirection() {
        System.out.println("##############################################");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Team team = em.find(Team.class, "team1");
        List<Member> members = team.getMembers();

        for (Member member : members) {
            System.out.println("Member.username = " + member.getUsername());
        }

        tx.commit();
        em.close();
        System.out.println("##############################################");
    }

    private static void deleteRelation() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Member member1 = em.find(Member.class, "member1");
        member1.setTeam(null);

        tx.commit();
        em.close();
    }

    private static void updateRelation() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Team team2 = new Team("team2", "팀2");
        em.persist(team2);

        Member member = em.find(Member.class, "member1");
        member.setTeam(team2);

        tx.commit();
        em.close();
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
        System.out.println(member.getTeam().getName());

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

        for(int i = 0; i < 100; i++) {
            Member member = new Member();
            member.setId("member"+i);
            member.setUsername("회원"+i);
            member.setTeam(team);
            member.setAge(i);
            em.persist(member);
        }

        tx.commit();
        em.close();
    }
}
