package task242.service;

import task242.model.Role;
import task242.model.User;

import java.util.List;

public interface RoleService {
    List<Role> findAllRoles();
    Role getRoleById(Long id);
    void setRolesToUser(User user, Long[] roles);
}
