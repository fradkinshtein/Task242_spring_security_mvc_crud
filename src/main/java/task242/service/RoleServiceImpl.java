package task242.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task242.model.Role;
import task242.model.User;
import task242.repositories.RoleRepository;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {

        this.roleRepository = roleRepository;

    }

    @Override
    @Transactional
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public Role getRoleById(Long id) {
        return roleRepository.getOne(id);
    }

    @Override
    @Transactional
    public void setRolesToUser(User user, Long[] roles) {
        Set<Role> roleList = new HashSet<>();
        for (Long id : roles) {
            roleList.add(roleRepository.findById(id).orElse(null));
        }
        user.setRoles(roleList);
    }
}
