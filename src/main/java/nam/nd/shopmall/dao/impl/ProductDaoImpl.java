package nam.nd.shopmall.dao.impl;

import nam.nd.shopmall.dao.ProductDao;
import nam.nd.shopmall.model.Product;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @author nam.nd
 * @created 16/06/2021 - 11:54 PM
 */

@Repository
public class ProductDaoImpl extends AbstractBaseDAO  implements ProductDao {

    public void deleteProductById(Long id) {
        String hql= "DELETE FROM Product p WHERE p.id=:id";
        Query<Product> query= getSession().createQuery(hql);
        query.setParameter("id",id);
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
}
