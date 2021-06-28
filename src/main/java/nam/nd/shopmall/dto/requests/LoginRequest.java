package nam.nd.shopmall.dto.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author nam.nd
 * @created 06/03/2021 - 11:54 PM
 */

@Getter
@Setter
public class LoginRequest implements Serializable {

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String password;

    public LoginRequest() {
    }
}
