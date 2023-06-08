package board.repository;

import board.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final EntityManager em;

    public void save(Comment Comment) {
        em.persist(Comment);
    }

    public Comment findById(Long id) {
        return em.find(Comment.class, id);
    }


    public List<Comment> findAll() {
        return em.createQuery(
                "select * from Comment c", Comment.class
        ).getResultList();
    }
}
