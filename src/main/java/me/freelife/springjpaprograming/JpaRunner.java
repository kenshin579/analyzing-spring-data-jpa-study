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
        Account account = new Account();
        account.setUsername("freelife");
        account.setPassword("hibernate");

	    account.setAddress(new Address("street", "city", "state", "1234"));

        entityManager.persist(account);

//        Session session = entityManager.unwrap(Session.class);
//        session.save(account);
    }
}
