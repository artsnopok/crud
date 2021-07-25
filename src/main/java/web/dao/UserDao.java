package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    List<User> index();

    User show(long id);

    boolean save(User user);

    void update(User user);

    void delete(long id);

    User findUserByEmail(String email);
}
