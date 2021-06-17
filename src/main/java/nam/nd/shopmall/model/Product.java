package nam.nd.shopmall.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * @author nam.nd
 * @created 16/06/2021 - 9:37 PM
 */

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false, length = 100)
    private String productName;

    @Column(name = "price", nullable = false, length = 15)
    private Double price;

    @Column(name = "product_status", nullable = false, length = 50)
    private String productStatus;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Column(name = "supplier_id", nullable = false)
    private Long supplierId;

    @Column(name = "url_image", length = 200)
    private String urlImage;

    @Column(name = "description", length = 5000)
    private String description;

    @Column(name = "time_update", nullable = false)
    private Instant timeUpdate;

}
