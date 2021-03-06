package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {


    @PersistenceContext()
    EntityManager entityManager;


    @Override
    public List<User> allUser() {
        return entityManager.createQuery(
                "select user from User user ", User.class).getResultList();
    }


    @Override
    public void add(User user) {
        entityManager.persist(user);
    }


    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }


    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public void update(long id,User user) {
        User newUser = getById(id);
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setAge(user.getAge());
    }


    @Override
    public void remove(long id) {
        User user = getById(id);
        if (user != null) {
            entityManager.remove(user);
        } else {
            System.out.println("The users does not exist");
        }
    }
}