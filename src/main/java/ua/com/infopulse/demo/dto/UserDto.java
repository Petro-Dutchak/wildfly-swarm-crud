package ua.com.infopulse.demo.dto;

import lombok.Data;
import ua.com.infopulse.demo.entity.User;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String surName;
    private LocalDate dateOfBirth;
    private User.Status status;
    private Long projectId;

    public static User toUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setFirstName(userDto.getFirstName());
        user.setSurName(userDto.getSurName());
        user.setStatus(userDto.getStatus());
        return user;
    }

    public static Set<User> toUsers(Set<UserDto> usersDto) {
        Set<User> users = new HashSet<>();
        for (UserDto userDto :usersDto) {
            users.add(toUser(userDto));
        }
        return users;
    }




}
