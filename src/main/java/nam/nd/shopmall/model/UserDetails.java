package nam.nd.shopmall.model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.Collection;

/**
 * @author nam.nd
 * @created 27/06/2021 - 9:44 PM
 */

@Getter
@Setter
public class UserDetails extends User {

    nam.nd.shopmall.model.User user;
    public UserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
