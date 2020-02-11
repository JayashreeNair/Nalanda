package com.freezone.nalanda.infrastructure.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column()
    private String firstName;

    @Column()
    private String middleName;

    @Column()
    private String lastName;

    @Column()
    private boolean superUser;
}
