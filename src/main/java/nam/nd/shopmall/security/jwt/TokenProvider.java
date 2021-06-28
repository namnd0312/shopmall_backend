package nam.nd.shopmall.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import nam.nd.shopmall.model.UserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenProvider {

    private Logger logger = LoggerFactory.getLogger(TokenProvider.class);

    private final ObjectMapper objectMapper;

    @Value("${application.authentication.jwt.secret-key}")
    private String secretKey;

    @Value("${application.authentication.jwt.token-validity-milliseconds}")
    private long tokenValidityInMilliseconds;

    @Value("${application.authentication.jwt.token-validity-in-seconds-for-remember-me}")
    private long tokenValidityInSecondsForRememberMe;

    public TokenProvider(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String generateJwtToken(Authentication authentication, boolean rememberMe) {

        UserDetails userDetailsDTO = (UserDetails) authentication.getPrincipal();

        long now = (new Date()).getTime();
        Date expiredTime;
        if(rememberMe){
            expiredTime = new Date(tokenValidityInSecondsForRememberMe + now);
        } else {
            expiredTime = new Date(tokenValidityInMilliseconds + now);
        }

        return Jwts.builder()
                .setSubject((userDetailsDTO.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(expiredTime)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }


    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature -> Message: {} ", e);
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token -> Message: {}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: {}", e);
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token -> Message: {}", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty -> Message: {}", e);
        }

        return false;
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }
}
