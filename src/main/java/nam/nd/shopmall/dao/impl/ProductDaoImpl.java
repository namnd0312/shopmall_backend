package nam.nd.shopmall.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nam.nd.shopmall.dao.ProductDao;
import nam.nd.shopmall.model.Product;
import nam.nd.shopmall.service.dto.BaseSearch;
import nam.nd.shopmall.service.dto.ProductDto;
import nam.nd.shopmall.service.dto.ProductPaginatorDto;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nam.nd
 * @created 16/06/2021 - 11:54 PM
 */

@Repository
public class ProductDaoImpl extends AbstractBaseDAO implements ProductDao {

    public void deleteProductById(Long id) {
        String hql = "DELETE FROM Product p WHERE p.id=:id";
        Query<Product> query = getSession().createQuery(hql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void changeProductStatus(Long id, String productStatus) {
        Session currentSession = getSession();
        Query<Product> query = currentSession.createQuery("UPDATE Product AS P SET P.productStatus =:productStatus where P.id=:id", Product.class);
        query.setParameter("id", id);
        query.setParameter("productStatus", productStatus);
        query.executeUpdate();
    }

    @Override
    public void finAllProductByProductStatus(ProductPaginatorDto dto) throws JsonProcessingException {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("select ");
        sqlBuilder.append("p.id, ");
        sqlBuilder.append("p.product_name as productName, ");
        sqlBuilder.append("p.price as price, ");
        sqlBuilder.append("p.product_status as productStatus, ");
        sqlBuilder.append("p.category_id as categoryId, ");
        sqlBuilder.append("p.supplier_id as supplierId, ");
        sqlBuilder.append("p.url_image as urlImage, ");
        sqlBuilder.append("p.description as description, ");
        sqlBuilder.append("p.time_update as timeUpdate ");
        sqlBuilder.append("from product as p ");
        sqlBuilder.append("where 1=1");

        Map<String, Object> parameters = new HashMap<>();

        if (!StringUtils.isEmpty(dto.getStatus()) && !"ALL".equalsIgnoreCase(dto.getStatus())) {
            sqlBuilder.append(" and p.product_status = :status ");
            parameters.put("status", dto.getStatus().toUpperCase());
        }

        sqlBuilder.append(" order by ");

        if (!CollectionUtils.isEmpty(dto.getOrders())) {
            dto.getOrders().forEach(order -> {
                String orderProperty = StringUtils.trimToEmpty(order.getProperty());

                switch (orderProperty) {
                    case "productName":
                        sqlBuilder.append(" p.product_name ").append(getOrderBy(order.isAscending())).append(",");
                        break;

                    case "timeUpdate":
                        sqlBuilder.append(" p.time_update ").append(getOrderBy(order.isAscending())).append(",");

                    default:
                }
            });
            sqlBuilder.deleteCharAt(sqlBuilder.length() - 1);

        } else {
            sqlBuilder.append(" product_name");
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValueAsString(sqlBuilder.toString());


        searchAndCountTotal(dto, sqlBuilder.toString(), parameters, ProductDto.class);

    }
}
