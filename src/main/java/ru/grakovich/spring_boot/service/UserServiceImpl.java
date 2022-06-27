package ru.grakovich.spring_boot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.grakovich.spring_boot.models.User;
import ru.grakovich.spring_boot.repositories.UserDAO;


import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> allUser() {
        return userDAO.findAll();
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public User getUserById(long id) {
        Optional<User> optionalUser = userDAO.findById(id);
        return optionalUser.orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public void update(Long id, String name, String lastName, Integer age) {
        User user = getUserById(id);
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        userDAO.save(user);
    }

    @Override
    public void delete(Long id) {
        userDAO.delete(getUserById(id));
    }
}
