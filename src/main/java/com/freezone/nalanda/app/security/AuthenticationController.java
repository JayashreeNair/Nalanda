package com.freezone.nalanda.app.security;

import com.freezone.nalanda.infrastructure.persistence.jpaadaptor.H2UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@CrossOrigin
public class AuthenticationController {
    @Autowired
    private H2UserRepository repo;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody Credentials creds) throws Exception{

        final UserDetails userDetails = repo.findByUserNameAndPassword(creds.getUsername(), creds.getPassword());

        if (userDetails == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND );
        }
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
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
