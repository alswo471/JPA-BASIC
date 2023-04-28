package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setUsername("HelloA");
            member.setRoleType(RoleType.GUEST);
            em.persist(member);

//            Member findMember = em.find(Member.class, 1);
//            System.out.println("Id : " + findMember.getId());
//            System.out.println("Name : " + findMember.getUsername());
//            System.out.println("Name : " + findMember.getRoleType());


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
