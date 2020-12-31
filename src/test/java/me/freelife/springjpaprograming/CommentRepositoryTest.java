package me.freelife.springjpaprograming;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud1() {
        commentRepository.save(null); //@NotNull 어노테이션으로
        //java.lang.IllegalArgumentException: Parameter entity in MyRepository.save must not be null!
    }

    @Test
    public void crud2() {
        Optional<Comment> byId = commentRepository.findById(100l);
        assertThat(byId).isEmpty();
        //Comment comment = byId.orElse(new Comment()); // Optional 객체가 비어있으면 Comment 만들어서 리턴
        Comment comment = byId.orElseThrow(() -> new IllegalArgumentException());

        List<Comment> comments = commentRepository.findAll();
        assertThat(comments).isEmpty();

        commentRepository.save(null);
    }
}