package nam.nd.shopmall.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author nam.nd
 * @created 27/06/2021 - 9:51 PM
 */
public class SecurityException extends AuthenticationException {

    public SecurityException(String msg) {
        super(msg);
    }
}
