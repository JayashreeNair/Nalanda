package com.freezone.nalanda.domain.model;

import com.googlecode.jmapper.annotations.JMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @JMap
    @Getter
    @Setter
    private int id;

    @JMap
    private String userName;

    @JMap
    private String password;

    @JMap("firstName")
    @Getter
    @Setter
    private String fName;

    @JMap("middleName")
    @Getter
    @Setter
    private String mName;

    @JMap("lastName")
    @Getter
    @Setter
    private String lName;

    @JMap
    @Getter
    @Setter
    private boolean superUser;

    public boolean addUser(User user) {
        return false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
