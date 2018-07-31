package ua.com.infopulse.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Data
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column
    private LocalDate startDate;
    @Column
    private LocalDate endDate;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<User>();
}
