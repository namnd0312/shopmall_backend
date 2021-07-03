package nam.nd.shopmall.dto.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author nam.nd
 * @created 06/03/2021 - 11:55 PM
 */

@Getter
@Setter
public class SignUpRequest {

    @NotBlank
    @Size(max = 100)
    private String email;

    @NotEmpty
    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public SignUpRequest() {
    }
}
