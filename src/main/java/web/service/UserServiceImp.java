package web.service;

import org.springframework.stereotype.Service;
import web.dao.*;
import web.models.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserDao userDao = new UserDaoImp();

    @Override
    public List<User> index() {
        return userDao.index();
    }

    @Override
    public User show(int id) {
        return userDao.show(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }
}
