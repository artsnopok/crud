package web.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import web.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Collections;


@Component
public class DataLoader {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public DataLoader(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostConstruct
    public void loadData() {
        userService.save(new User("admin", "fakeadmin", 0, "admin@admin.in",
                "admin", Collections.singleton(new Role("ROLE_ADMIN"))));

        userService.save(new User("user", "fakeuser", 0, "user@user.in",
                "user", Collections.singleton(new Role("ROLE_USER"))));
    }
}




