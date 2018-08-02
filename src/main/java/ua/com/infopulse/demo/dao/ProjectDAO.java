package ua.com.infopulse.demo.dao;

import ua.com.infopulse.demo.dto.ProjectStatusDto;
import ua.com.infopulse.demo.entity.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.time.LocalDate;



@ApplicationScoped
public class ProjectDAO {
    @PersistenceContext
    EntityManager em;

    public Project get(long id) {
        return em.find(Project.class, id);
    }

    public Project create(Project project) {
        em.persist(project);
        return project;
    }

    public Project update(Project project) {
        em.merge(project);
        return project;
    }

    public void delete(long id) {
        em.remove(get(id));

    }

    public Project finishProject(long id, LocalDate endDate) {
        Project project = get(id);
        project.setEndDate(endDate);
        em.merge(project);
        return project;
    }

    public ProjectStatusDto getProjectstatus() {
        ProjectStatusDto projectStatusDto = new ProjectStatusDto();
        projectStatusDto.setActiveProjects((BigInteger) em.createNativeQuery(
            "SELECT count(*) FROM Project  p WHERE p.ENDDATE IS NULL ").getSingleResult());
        projectStatusDto.setFinishedProjects((BigInteger) em.createNativeQuery(
            "SELECT count(*) FROM Project p WHERE p.ENDDATE IS NOT NULL ").getSingleResult());
        return projectStatusDto;

    }

}
