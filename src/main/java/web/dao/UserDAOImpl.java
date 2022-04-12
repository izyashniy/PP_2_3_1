package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> index() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }


    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public void save(User user) {
        entityManager.persist(user);
    }


    @Override
    public void update(User updatedUser) {
        entityManager.merge(updatedUser);
    }


    @Override
    public void delete(int id) {
        entityManager.createQuery("delete from User where id=: id").setParameter("id", id).executeUpdate();
    }
}
