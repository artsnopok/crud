package web.dao;

import org.springframework.stereotype.Component;
import web.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImp implements UserDao {
    private long USERS_COUNT;
    private List<User> users;


    {
        users = new ArrayList<>();
        users.add(new User(++USERS_COUNT, "Дима", "Дима", 32));
        users.add(new User(++USERS_COUNT, "Артем", "Артем", 26));
        users.add(new User(++USERS_COUNT, "Настя", "Настя", 25));
        users.add(new User(++USERS_COUNT, "Гена", "Гена", 60));

    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++USERS_COUNT);
        users.add(user);
    }

    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setSurname(updatedUser.getSurname());
        userToBeUpdated.setAge(updatedUser.getAge());
    }


    public void delete(long id) {
        users.removeIf(p -> p.getId()==id);
    }
}
