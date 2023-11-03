package ru.komm.pp_3_1_2_komm.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.komm.pp_3_1_2_komm.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    public User getUser(int id) {
        User user = (User) entityManager.find(User.class, id);
        return user;
    }

    public void addUser(User user) {
        entityManager.persist(user);
    }

    public void editUser(int id, User updatedUser) {
        User userToBeUpdated = getUser(id);
        userToBeUpdated.setHeight(updatedUser.getHeight());
        userToBeUpdated.setName(updatedUser.getName());
        entityManager.merge(userToBeUpdated);
    }

    public void deleteUser(int id) {
        entityManager.remove(getUser(id));
    }
}
