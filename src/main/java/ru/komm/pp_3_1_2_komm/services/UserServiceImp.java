package ru.komm.pp_3_1_2_komm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.komm.pp_3_1_2_komm.dao.UserDAO;
import ru.komm.pp_3_1_2_komm.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private UserDAO userDAO;

    public UserServiceImp() {

    }

    @Autowired
    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void editUser(int id, User user) {
        userDAO.editUser(id, user);
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}
