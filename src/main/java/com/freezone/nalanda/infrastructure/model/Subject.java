package com.freezone.nalanda.infrastructure.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="subject")
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column
    private String code;

    @Column
    private int academicYear;

    @Column
    private String name;

    @Column
    private String room;

    @ManyToOne
    @JoinColumn(name="guru_id", nullable=false)
    private Guru guru;
}
