package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.models.Role;
import web.models.User;

import java.util.List;
import java.util.Set;

public interface UserService extends UserDetailsService {
    List<User> index();
    User show(long id);
    boolean save(User user);
    boolean update(User user);
    void delete(long id);
    Role findRoleById(long id);
    Role findRoleByName(String name);
    User findUserByEmail(String email);

}

