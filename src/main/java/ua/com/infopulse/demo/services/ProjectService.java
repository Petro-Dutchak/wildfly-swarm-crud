package ua.com.infopulse.demo.services;

import ua.com.infopulse.demo.dao.ProjectDAO;
import ua.com.infopulse.demo.dto.ProjectDto;
import ua.com.infopulse.demo.dto.ProjectFinishDto;
import ua.com.infopulse.demo.dto.ProjectStatusDto;

import javax.inject.Inject;
import javax.transaction.Transactional;

@Transactional
public class ProjectService {
    @Inject
    ProjectDAO projectDAO;
   public ProjectDto createProject(ProjectDto projectDto) {
        return ProjectDto.fromProject(projectDAO.create(ProjectDto.toProject(projectDto)));
    }

    public ProjectDto updateProject(ProjectDto projectDto) {
        return ProjectDto.fromProject(projectDAO.update(ProjectDto.toProject(projectDto)));
    }

    public void deleteProject(long id) {
        projectDAO.delete(id);
    }

    public ProjectDto getProject(long id) {
        return ProjectDto.fromProject(projectDAO.get(id));
    }

    public ProjectDto finishProject(ProjectFinishDto projectFinishDto) {
        return ProjectDto.fromProject(projectDAO.finishProject(projectFinishDto.getId(), projectFinishDto.getEndDate()));
    }

    public ProjectStatusDto getProjectsStatus(){
       return projectDAO.getProjectstatus();
    }

}
