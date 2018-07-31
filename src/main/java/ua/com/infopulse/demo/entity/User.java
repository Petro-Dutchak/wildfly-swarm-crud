package ua.com.infopulse.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table
@Data
public class User implements Serializable {
    public enum Status {
        ACTIVE, INACTIVE, DELETED}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(length = 60)
    private String firstName;
    @Column(length = 60)
    private String surName;
    @Column
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne(cascade = CascadeType.ALL)
    private Project project;
}
