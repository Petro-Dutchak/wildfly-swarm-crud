package ua.com.infopulse.demo.entity;

import lombok.Data;
import ua.com.infopulse.demo.dto.UserDto;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "projectId")
    private Project project;

    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setDateOfBirth(user.getDateOfBirth());
        userDto.setFirstName(user.getFirstName());
        userDto.setSurName(user.getSurName());
        userDto.setStatus(user.getStatus());
        userDto.setProjectId(user.getProject().getId());
        return userDto;
    }
    public static Set<UserDto> toUsersDto(Set<User> users) {
        Set<UserDto> usersDto = new HashSet<>();
        for (User user :users) {
            usersDto.add(toUserDto(user));
        }
        return usersDto;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return new org.apache.commons.lang.builder.EqualsBuilder()
                .append(id, user.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang.builder.HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }
}
