package nam.nd.shopmall.service.impl;

import nam.nd.shopmall.dao.UserRoleDao;
import nam.nd.shopmall.model.UserRole;
import nam.nd.shopmall.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * @author nam.nd
 * @created 30/06/2021 - 12:14 AM
 */

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleDao userRoleDao;

    public UserRoleServiceImpl(UserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    @Override
    public void saveUserRole(Long userId, Long roleId) {
        UserRole userRole = new UserRole();
        userRole.setRoleId(roleId);
        userRole.setUserId(userId);
        this.userRoleDao.save(userRole);
    }
}
