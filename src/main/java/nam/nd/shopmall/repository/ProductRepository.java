package nam.nd.shopmall.repository;

import nam.nd.shopmall.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nam.nd
 * @created 12/09/2021 - 9:51 PM
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
