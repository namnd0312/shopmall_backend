package nam.nd.shopmall.model;

import lombok.Getter;
import lombok.Setter;
import nam.nd.shopmall.enums.ERole;

import javax.persistence.*;

/**
 * @author nam.nd
 * @created 27/06/2021 - 4:46 PM
 */

@Entity
@Table(name = "role")
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;
}
