package nam.nd.shopmall.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import nam.nd.shopmall.dto.ProductPaginatorDto;
import nam.nd.shopmall.util.Util;
import nam.nd.shopmall.dao.ProductDao;
import nam.nd.shopmall.dto.ChangeProductStatusDto;
import nam.nd.shopmall.dto.ProductDto;
import nam.nd.shopmall.service.mapper.ProductMapper;
import nam.nd.shopmall.exception.LogicException;
import nam.nd.shopmall.model.Product;
import nam.nd.shopmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.time.Instant;
import java.util.Optional;

import static nam.nd.shopmall.enums.MessageEnum.*;

/**
 * @author nam.nd
 * @created 16/06/2021 - 11:51 PM
 */

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductDao productDao, ProductMapper productMapper) {
        this.productDao = productDao;
        this.productMapper = productMapper;
    }

    @Override
    public void create(ProductDto dto) {
        Product entity = productMapper.toEntity(dto);
        productDao.save(entity);
    }

    @Autowired
    private  EntityManager e;

    @Override
    public void update(ProductDto dto) throws LogicException {


        try {
            EntityManagerFactoryInfo factory = (EntityManagerFactoryInfo) e.getEntityManagerFactory();
            Connection connection = factory.getDataSource().getConnection();
            String sql = "{? = CALL public.product_insert(?,?,?)}";
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(2, "namnd1");
            statement.setString(3,"namnd2");
            statement.setString(4, "namnd3");
            statement.registerOutParameter(1, Types.VARCHAR);
            statement.executeQuery();
            ResultSet result = (ResultSet) statement.getObject(1);
            while (result.next()) {
            }
            result.close();
            System.out.println(result);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void deleteById(Long id) throws LogicException {

        Product product = productDao.findById(id, Product.class).orElse(null);

        if (product == null) {
            throw new LogicException(RECORD_NOT_EXIST);
        }

        productDao.deleteProductById(id);
    }

    @Override
    public void changeProductStatus(ChangeProductStatusDto dto) throws LogicException {


        Long idProduct = Util.stringToLong(dto.getId());
        Product product = productDao.findById(idProduct, Product.class).orElse(null);

        if (product == null) {
            throw new LogicException(RECORD_NOT_EXIST);
        }

        product.setTimeUpdate(Instant.now());
        productDao.changeProductStatus(idProduct, dto.getStatus());
    }

    @Override
    public Optional<ProductDto> findOne(String id) {
        return productDao.findById(Util.stringToLong(id), Product.class)
                .map(productMapper::toDto);
    }

    @Override
    public ProductDto findById(Long id) throws LogicException {
        Product product = productDao.findById(id, Product.class).orElse(null);

        if (product == null) {
            throw new LogicException(RECORD_NOT_EXIST);
        }

        return productMapper.toDto(product);
    }

    @Override
    public void finAllProductByProductStatus(ProductPaginatorDto dto) throws JsonProcessingException {
        productDao.finAllProductByProductStatus(dto);
    }
}
