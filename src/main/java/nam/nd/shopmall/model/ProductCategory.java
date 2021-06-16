package nam.nd.shopmall.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author nam.nd
 * @created 16/06/2021 - 10:42 PM
 */

@Getter
@Setter
@Entity
@Table(name = "product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name", length = 100, nullable = false)
    private String categoryName;

    @Column(name = "description", length = 200)
    private String description;
}
