package com.freezone.nalanda.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class User {
    private int id;
    private String fName;
    private String mName;
    private String lName;
}
