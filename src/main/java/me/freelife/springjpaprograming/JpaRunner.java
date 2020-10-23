package me.freelife.springjpaprograming;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        /*
        양방향 관계
        - 반드시 주인이 되는 쪽에 관계를 설정하는 로직을 해야함
        - 주인이 되는 쪽만 설정해줘도 되지만 객체지향적으로 서로서로 관계를 반드시 설정해줘야함
         */
        Account account = new Account();
        account.setUsername("freelife");
        account.setPassword("hibernate");

        Study study = new Study();
        study.setName("Spring Data JPA" + System.currentTimeMillis());

        account.getStudies().add(study); //종속관계 관계 설정 (객체에서도 용의함)
        study.setOwner(account); //주인이 되는 쪽 관계 설정

        entityManager.persist(account);
        entityManager.persist(study);
    }
}
