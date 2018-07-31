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

    public static ProjectDto fromProject(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(project.getId());
        projectDto.setName(project.getName());
        projectDto.setStartDate(project.getEndDate());
        projectDto.setEndDate(project.getEndDate());
        projectDto.setUsers(UserDto.fromUsers(project.getUsers()));
        return projectDto;
    }
}
