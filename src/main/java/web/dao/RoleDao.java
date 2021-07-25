package web.dao;

import web.models.Role;

import java.util.List;

public interface RoleDao {
    List<Role> index();

    Role findRoleById(long id);

    boolean save(Role role);

    void update(Role role);

    void delete(long id);

    Role findRoleByName(String name);
}
