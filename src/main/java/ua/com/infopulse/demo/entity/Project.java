package ua.com.infopulse.demo.entity;

import lombok.Data;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import ua.com.infopulse.demo.dto.ProjectDto;
import ua.com.infopulse.demo.dto.UserDto;

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
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    private Set<User> users = new HashSet<>();

    public static ProjectDto projectDto(Project project) {
        if(project != null) {
            ProjectDto projectDto = new ProjectDto();
            projectDto.setId(project.getId());
            projectDto.setName(project.getName());
            projectDto.setStartDate(project.getEndDate());
            projectDto.setEndDate(project.getEndDate());
            projectDto.setUsers(User.toUsersDto(project.getUsers()));
            return projectDto;
        } return null;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        return new EqualsBuilder()
                .append(id, project.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }
}
