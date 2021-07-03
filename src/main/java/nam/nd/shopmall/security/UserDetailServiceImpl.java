package nam.nd.shopmall.security;

import nam.nd.shopmall.dao.UserDao;
import nam.nd.shopmall.dao.UserRoleDao;
import nam.nd.shopmall.model.User;
import nam.nd.shopmall.model.UserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author nam.nd
 * @created 27/06/2021 - 4:48 PM
 */
public class UserDetailServiceImpl implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UserDetailServiceImpl.class);

    private final UserDao userDao;

    private final UserRoleDao userRoleDao;

    public UserDetailServiceImpl(UserDao userDao, UserRoleDao userRoleDao) {
        this.userDao = userDao;
        this.userRoleDao = userRoleDao;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.trace("Service authenticate: {}", email);

        try {
            User user = userDao.getUserByEmail(email);

            List<String> roles = userRoleDao.findAllRoleByUserId(user.getId());

            List<GrantedAuthority> grantedAuthorities = roles.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());

            UserDetails userDetails = new UserDetails(user.getPhoneNumber(), user.getPassword(), grantedAuthorities);
            user.setPassword(null);
            userDetails.setUser(user);
            return userDetails;
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            throw new UsernameNotFoundException("User with phone number " + email + " not found in the database");
        }
    }
}
