package com.freezone.nalanda.infrastructure.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "guru")
@Getter
@Setter
public class Guru extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    @OneToMany(mappedBy = "guru")
    private Set<Subject> subjects;

}
