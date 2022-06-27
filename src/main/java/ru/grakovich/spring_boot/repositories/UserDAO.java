package ru.grakovich.spring_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.grakovich.spring_boot.models.User;

public interface UserDAO extends JpaRepository<User,Long> {

}