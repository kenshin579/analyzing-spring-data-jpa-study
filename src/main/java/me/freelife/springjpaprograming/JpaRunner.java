package me.freelife.springjpaprograming;

import org.hibernate.Session;
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
		Session session = entityManager.unwrap(Session.class);
		createPostAndComments(session, 3, 4);

		// JPQL Example
//		TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post As p", Post.class);
//		List<Post> posts = query.getResultList();

		// Criteria
        /*
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> criteria = builder.createQuery(Post.class);
        Root<Post> root = criteria.from(Post.class);
        criteria.select(root);

        List<Post> posts = entityManager.createQuery(criteria).getResultList();
        */

		//        // Native Query
		//        List<Post> posts = entityManager
		//                .createNativeQuery("SELECT * FROM post", Post.class)
		//                .getResultList();
		//
//		posts.forEach(System.out::println);
	}

	private void createPostAndComments(Session session, int maxPost, int maxComment) {
		Post post;
		Comment comment;

		for (int i = 0; i < maxPost; i++) {
			post = new Post();
			post.setTitle(i + " title");

			for (int j = 0; j < maxComment; j++) {
				comment = new Comment();
				comment.setComment(i + "_" + j + " command");
				post.addComment(comment);
			}

			session.save(post);
		}
	}
}
