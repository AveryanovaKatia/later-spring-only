package ru.practicum.user;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    User save(final User user);

    User getUser(final Long userId);
}