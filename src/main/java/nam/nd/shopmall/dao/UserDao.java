package nam.nd.shopmall.dao;

import nam.nd.shopmall.model.User;

import java.io.Serializable;

/**
 * @author nam.nd
 * @created 27/06/2021 - 6:16 PM
 */
public interface UserDao extends BaseDAO, Serializable {

    User getUserByPhoneNumber(String phoneNumber);
}
