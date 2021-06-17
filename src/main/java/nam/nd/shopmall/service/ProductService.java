package nam.nd.shopmall.service;

import nam.nd.shopmall.service.dto.ChangeProductStatusDto;
import nam.nd.shopmall.service.dto.ProductDto;
import nam.nd.shopmall.exception.LogicException;

import java.util.Optional;

/**
 * @author nam.nd
 * @created 16/06/2021 - 11:50 PM
 */
public interface ProductService {

    void create(ProductDto dto) throws LogicException;

    void update(ProductDto dto) throws LogicException;

    void deleteById(String id) throws LogicException;

    void changeProductStatus(ChangeProductStatusDto dto) throws LogicException;

    Optional<ProductDto> findOne(String id);
}
