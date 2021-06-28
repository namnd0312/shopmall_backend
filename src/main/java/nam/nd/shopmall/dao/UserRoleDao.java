package nam.nd.shopmall.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author nam.nd
 * @created 27/06/2021 - 7:31 PM
 */
public interface UserRoleDao extends BaseDAO, Serializable {

    List<String> findAllRoleByUserId(Long userId);
}
