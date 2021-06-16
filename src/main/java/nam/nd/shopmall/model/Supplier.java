package nam.nd.shopmall.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author nam.nd
 * @created 16/06/2021 - 11:37 PM
 */

@Getter
@Setter
@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "short_name", length = 100, nullable = false)
    private String shortName;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "address", length = 200)
    private String address;

    @Column(name = "tax_code", length = 50)
    private String taxCode;

    @Column(name = "fax", length = 50)
    private String fax;

    @Column(name = "status", length = 50, nullable = false)
    private String status;
}
