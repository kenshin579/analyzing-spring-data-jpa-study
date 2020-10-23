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
        단방향 관계
        - Study 테이블안에 Account 테이블의 PK를 참조하는 FK 컬럼을 생성해서 가지고 있게 됨
        - owner라고 줬지만 owner_id라고 생성이 되고 owner_id에 대한 constraints 가 foreign key로 잡힘
         */
        Account account = new Account();
        account.setUsername("freelife");
        account.setPassword("hibernate");

        Study study = new Study();
        study.setName("Spring Data JPA" + System.currentTimeMillis());
        study.setOwner(account);

        entityManager.persist(account);
        entityManager.persist(study);
    }
}
