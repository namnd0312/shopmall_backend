package nam.nd.shopmall.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author nam.nd
 * @created 27/06/2021 - 4:46 PM
 */

@Entity
@Table(name = "user_tb")
@Getter
@Setter
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", length = 100)
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number", length = 15, nullable = false)
    private String phoneNumber;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "address", length = 200, nullable = true)
    private String address;

    @Column(name = "is_active", nullable = false)
    private Boolean active = Boolean.FALSE;


    public User(String password, String phoneNumber) {
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
