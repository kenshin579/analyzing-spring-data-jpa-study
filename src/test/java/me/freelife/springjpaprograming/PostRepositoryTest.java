package me.freelife.springjpaprograming;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest //@Transactional 어노테이션이 포함되어 있ㅇ므
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void crud() {
        Post post = new Post();
        post.setTitle("hibernate");
        postRepository.save(post);
        postRepository.findMyPost();

//        Hibernate의 경우 ROLLBACK 트랜잭션의 경우 필요없는 Query는 아예 날리지 않음
//        강제로 flush() 하면 delete Query를 날림
        postRepository.delete(post);
        postRepository.flush();
    }
}
