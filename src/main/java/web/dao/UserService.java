package web.dao;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> index();

    User show(long id);

    void save(User user);

    void update(User user);

    void delete(long id);
}
