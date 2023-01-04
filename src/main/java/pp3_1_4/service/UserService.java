package pp3_1_4.service;

import pp3_1_4.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findUserById(int id);

    void save(User user);

    void update(User user);

    void delete(int id);

    User findByUsername(String name);
}

