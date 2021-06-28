package nam.nd.shopmall.controller;

import nam.nd.shopmall.dao.UserDao;
import nam.nd.shopmall.dao.impl.RoleRepository;
import nam.nd.shopmall.dto.requests.SignUpRequest;
import nam.nd.shopmall.enums.ERole;
import nam.nd.shopmall.model.Role;
import nam.nd.shopmall.model.User;
import nam.nd.shopmall.security.jwt.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

/**
 * @author nam.nd
 * @created 06/03/2021 - 11:09 PM
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {



    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private TokenProvider tokenProvider;

//    @PostMapping("/login")
//    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
////       try{
//           Authentication authentication = authenticationManager.authenticate(
//                   new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
//
//           SecurityContextHolder.getContext().setAuthentication(authentication);
//           String jwt = tokenProvider.generateJwtToken(authentication);
//
//           UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//
//           List<String> roles = userDetails.getAuthorities()
//                   .stream()
//                   .map(GrantedAuthority::getAuthority)
//                   .collect(Collectors.toList());
//
//           JwtResponse jwtResponse = new JwtResponse(jwt,
//                   userDetails.getId(),
//                   userDetails.getEmail(),
//                   roles);
//
//           return new ResponseEntity<>(Response.ok(jwtResponse), HttpStatus.OK);
////       }catch (Exception ex){
////           return handleError(ex);
////       }
//    }
//
//
//    private ResponseEntity<Object> handleError(Exception ex) {
//        Throwable cause = ex.getCause();
//
//         if(ex instanceof UserMissingRoleException) {
//            return new ResponseEntity<>(Response.error(USER_MISSING_ROLE), HttpStatus.OK);
//        } else if(ex instanceof UserTokenInvalidException) {
//            return new ResponseEntity<>(Response.error(USER_TOKEN_INVALID), HttpStatus.UNAUTHORIZED);
//        }
//        return new ResponseEntity<>(Response.error(UN_AUTHORIZE), HttpStatus.UNAUTHORIZED);
//    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
//        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//            return new ResponseEntity(Response.error(EMAIL_ALREADY_IN_USE), HttpStatus.BAD_REQUEST);
//        }

        // Create new user's account
        User user = new User(
                encoder.encode(signUpRequest.getPassword()),signUpRequest.getPhoneNumber());

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;

                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

//        user.setRoles(roles);
        userDao.save(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
