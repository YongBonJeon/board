package board.repository;

import board.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public User findById(Long id) {
        return em.find(User.class, id);
    }

    public List<User> findByName(String name) {
        return em.createQuery(
                        "select * from User u where u.userName = :name", User.class
                ).setParameter("name", name)
                .getResultList();
    }

    public List<User> findAll() {
        return em.createQuery(
                "select * from User u", User.class
        ).getResultList();
    }

    public void deleteById(Long id) {
        em.remove(findById(id));
    }
}
