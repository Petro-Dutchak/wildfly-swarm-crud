package ua.com.infopulse.demo.dto;

import lombok.Data;
import ua.com.infopulse.demo.entity.User;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class UserDto {
    private long id;
    private String firstName;
    private String surName;
    private LocalDate dateOfBirth;
    private User.Status status;
    private ProjectDto project;

    public static User toUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setFirstName(userDto.getFirstName());
        user.setSurName(userDto.getSurName());
        user.setStatus(userDto.getStatus());
        user.setProject(ProjectDto.toProject(userDto.getProject()));
        return user;
    }

    public static Set<User> toUsers(Set<UserDto> usersDto) {
        Set<User> users = new HashSet<>();
        for (UserDto userDto :usersDto) {
            users.add(toUser(userDto));
        }
        return users;
    }

    public static UserDto fromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setDateOfBirth(user.getDateOfBirth());
        userDto.setFirstName(user.getFirstName());
        userDto.setSurName(user.getSurName());
        userDto.setStatus(user.getStatus());
//        userDto.setProject(ProjectDto.fromProject(user.getProject()));
        return userDto;
    }

    public static Set<UserDto> fromUsers(Set<User> users) {
        Set<UserDto> usersDto = new HashSet<>();
        for (User user :users) {
            usersDto.add(fromUser(user));
        }
        return usersDto;
    }
}
