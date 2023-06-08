package board.repository;

import board.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {

    private final EntityManager em;

    /**
     * 저장
     */
    public void save(Post post) {
        em.persist(post);
    }

    /**
     * 게시글 Id로 조회
     */
    public Post findById(Long id) {
        return em.find(Post.class, id);
    }

    /**
     * 게시글 이름으로 조회
     */
    public List<Post> findByName(String name) {
        return em.createQuery(
                        "select * from Post p where p.postName = :name", Post.class
                ).setParameter("name", name)
                .getResultList();
    }

    /**
     * 모든 게시글 조회
     */
    public List<Post> findAll() {
        return em.createQuery(
                "select * from Post p", Post.class
        ).getResultList();
    }

    /**
     * 게시글 삭제
     */
    public void deleteById(Long id) {
        em.remove(findById(id));
    }
}
