package nam.nd.shopmall.dao;

import java.io.Serializable;

/**
 * @author nam.nd
 * @created 16/06/2021 - 11:53 PM
 */
public interface ProductDao extends BaseDAO, Serializable {

    void deleteProductById(Long id);

    void changeProductStatus(Long id,  String productStatus);
}
