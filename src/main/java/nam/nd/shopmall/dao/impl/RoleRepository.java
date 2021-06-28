package nam.nd.shopmall.dao.impl;

import nam.nd.shopmall.enums.ERole;
import nam.nd.shopmall.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author nam.nd
 * @created 28/06/2021 - 12:56 AM
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
