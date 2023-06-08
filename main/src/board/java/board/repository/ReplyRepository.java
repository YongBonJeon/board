package board.repository;

import board.domain.Reply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReplyRepository {

    private final EntityManager em;

    public void save(Reply Reply) {
        em.persist(Reply);
    }

    public Reply findById(Long id) {
        return em.find(Reply.class, id);
    }

    public List<Reply> findByName(String name) {
        return em.createQuery(
                        "select * from Reply r where r.ReplyName = :name", Reply.class
                ).setParameter("name", name)
                .getResultList();
    }

    public List<Reply> findAll() {
        return em.createQuery(
                "select * from Reply r", Reply.class
        ).getResultList();
    }
}
