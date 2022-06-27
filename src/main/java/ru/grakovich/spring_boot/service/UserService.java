package ru.grakovich.spring_boot.service;


import ru.grakovich.spring_boot.models.User;

import java.util.List;

public interface UserService {
    List<User> allUser();

    void save(User user);

    User getUserById(long id);

    void update(Long id, String name, String lastName, Integer age);

    void delete(Long id);
}
