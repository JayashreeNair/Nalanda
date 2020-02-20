package com.freezone.nalanda.app.security;

import com.freezone.nalanda.infrastructure.persistence.jpaadaptor.H2UserRepository;
import com.freezone.nalanda.infrastructure.security.UserDetailsServiceImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Objects;

@RestController
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl customUserDetailsService;

    @Autowired
    private H2UserRepository repo;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody Credentials creds) throws Exception{
//        try {
//            authenticate(creds.getUsername(), creds.getPassword());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        final UserDetails userDetails = customUserDetailsService
//                .loadUserByUsername(creds.getUsername());

        final UserDetails userDetails = repo.findByUserNameAndPassword(creds.getUsername(), creds.getPassword());

        if (userDetails == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}


@Getter
@Setter
class Credentials {
    String username;
    String password;
}

class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }
}
