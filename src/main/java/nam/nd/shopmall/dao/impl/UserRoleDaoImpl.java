package nam.nd.shopmall.dao.impl;

import nam.nd.shopmall.dao.UserRoleDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author nam.nd
 * @created 27/06/2021 - 7:32 PM
 */

@Repository
public class UserRoleDaoImpl extends AbstractBaseDAO implements UserRoleDao {

    @Override
    public List<String> findAllRoleByUserId(Long userId) {
        StringBuilder sql = new StringBuilder();
        sql.append("select r.name, ");
        sql.append("from user_role u ");
        sql.append("join role r on u.user_id=r.id ");
        sql.append("where u.user_id =:user_id ");
        Map<String, Object> parameter = Collections.singletonMap("user_id", userId);
        return getNamedParameterJdbcTemplate().query(sql.toString(), parameter, BeanPropertyRowMapper.newInstance(String.class));

    }
}
