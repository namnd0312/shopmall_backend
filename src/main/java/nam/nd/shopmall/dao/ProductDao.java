package nam.nd.shopmall.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import nam.nd.shopmall.model.Product;
import nam.nd.shopmall.service.dto.ProductPaginatorDto;

import java.io.Serializable;
import java.util.List;

/**
 * @author nam.nd
 * @created 16/06/2021 - 11:53 PM
 */
public interface ProductDao extends BaseDAO, Serializable {

    void deleteProductById(Long id);

    void changeProductStatus(Long id,  String productStatus);

    void finAllProductByProductStatus(ProductPaginatorDto dto) throws JsonProcessingException;
}
