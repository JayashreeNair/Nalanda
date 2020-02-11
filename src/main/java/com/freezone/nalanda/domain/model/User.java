package com.freezone.nalanda.domain.model;

import com.googlecode.jmapper.annotations.JMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @JMap
    private int id;

    @JMap("firstName")
    private String fName;

    @JMap("middleName")
    private String mName;

    @JMap("lastName")
    private String lName;

    @JMap
    private boolean superUser;

    public boolean addUser(User user){
        return false;
    }
}
