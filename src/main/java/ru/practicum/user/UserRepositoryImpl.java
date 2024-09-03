package ru.practicum.user;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserRepositoryImpl implements UserRepository {

    private final Map<Long, User> users = new HashMap();

    @Override
    public List<User> findAll() {
        return users.values().stream().toList();
    }

    @Override
    public User save(final User user) {
        user.setId(getId());
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User getUser(Long userId) {
        return users.get(userId);
    }

    private long getId() {
        Long currentMaxId = users.keySet()
                .stream()
                .mapToLong(id -> id)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}