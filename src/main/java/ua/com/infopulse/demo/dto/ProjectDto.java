package ua.com.infopulse.demo.dto;

import lombok.Data;
import ua.com.infopulse.demo.entity.Project;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class ProjectDto {

    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Set<UserDto> users = new HashSet<UserDto>();

    public static Project toProject(ProjectDto projectDto) {
        Project project = new Project();
        project.setId(projectDto.getId());
        project.setName(projectDto.getName());
        project.setStartDate(projectDto.getEndDate());
        project.setEndDate(projectDto.getEndDate());
        project.setUsers(UserDto.toUsers(projectDto.getUsers()));
        return project;
    }


}
