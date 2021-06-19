package nam.nd.shopmall.dao.impl;

import nam.nd.shopmall.dao.CommentDao;
import nam.nd.shopmall.model.Product;
import nam.nd.shopmall.service.dto.CommentDto;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

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
}
