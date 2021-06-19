package nam.nd.shopmall.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nam.nd.shopmall.dao.CommentDao;
import nam.nd.shopmall.model.Product;
import nam.nd.shopmall.service.dto.CommentDto;
import nam.nd.shopmall.service.dto.CommentPaginatorDto;
import nam.nd.shopmall.service.dto.ProductDto;
import nam.nd.shopmall.util.Util;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nam.nd
 * @created 16/06/2021 - 11:49 PM
 */

@Repository
public class CommentDaoImpl extends AbstractBaseDAO implements CommentDao {


    @Override
    public void deleteByParentId(Long parentId) {
        String hql = "DELETE FROM Comment c WHERE c.parentId=:parent_id";
        Query<Product> query = getSession().createQuery(hql);
        query.setParameter("parent_id", parentId);
        query.executeUpdate();
    }

    @Override
    public void deleteById(Long id) {
        String hql = "DELETE FROM Comment c WHERE c.id=:id";
        Query<Product> query = getSession().createQuery(hql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void getAllCommentByProductId(CommentPaginatorDto dto) {
        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append("select ");
        sqlBuilder.append("c.id, ");
        sqlBuilder.append("c.user_id as userId, ");
        sqlBuilder.append("c.time_update as timeUpdate, ");
        sqlBuilder.append("c.time_create as timeCreate, ");
        sqlBuilder.append("c.content as content, ");
        sqlBuilder.append("c.product_id as productId, ");
        sqlBuilder.append("c.parent_id as parentId ");
        sqlBuilder.append("from comment as c ");
        sqlBuilder.append("where 1 = 1 ");

        Map<String, Object> parameters = new HashMap<>();

        if(!StringUtils.isEmpty(dto.getProductId())){
            sqlBuilder.append("and c.product_id = :productId ");
            parameters.put("productId", Util.stringToLong(dto.getProductId()));
        }

        sqlBuilder.append("order by c.time_create desc");

        searchAndCountTotal(dto, sqlBuilder.toString(), parameters, CommentDto.class);

    }
}
