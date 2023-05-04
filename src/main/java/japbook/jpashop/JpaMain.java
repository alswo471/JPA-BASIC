package japbook.jpashop;

import japbook.jpashop.domain.Book;
import japbook.jpashop.domain.Member;
import japbook.jpashop.domain.Movie;

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
           Member member1 = new Member();
           member1.setName("지민재");
           em.persist(member1);

           em.flush();
           em.clear();

            Member ref = em.getReference(Member.class, member1.getId());
            System.out.println("ref = " + ref.getClass());

            em.detach(ref);

            System.out.println("ref :" + ref.getName());


            tx.commit();
        } catch (Exception e) {
            System.out.println("e = " + e);
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
