package ua.com.infopulse.demo.services;

import ua.com.infopulse.demo.dao.ProjectDAO;
import ua.com.infopulse.demo.dao.UserDao;
import ua.com.infopulse.demo.dto.ProjectDto;
import ua.com.infopulse.demo.dto.ProjectFinishDto;
import ua.com.infopulse.demo.dto.ProjectSetUsers;
import ua.com.infopulse.demo.dto.ProjectStatusDto;
import ua.com.infopulse.demo.entity.Project;
import ua.com.infopulse.demo.entity.User;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ProjectService {
    @Inject
    ProjectDAO projectDAO;
    @Inject
    UserDao userDao;
   public ProjectDto createProject(ProjectDto projectDto) {
        return Project.projectDto(projectDAO.create(ProjectDto.toProject(projectDto)));
    }

    public ProjectDto updateProject(ProjectDto projectDto) {
        return Project.projectDto(projectDAO.update(ProjectDto.toProject(projectDto)));
    }

    public void deleteProject(long id) {
        projectDAO.delete(id);
    }

    public ProjectDto getProject(long id) {
        return Project.projectDto(projectDAO.get(id));
    }

    public ProjectDto finishProject(ProjectFinishDto projectFinishDto) {
        List<User> users = userDao.getUsersByProjectId(projectFinishDto.getId());
        for (User user:users) {
            user.setProject(null);
            user.setStatus(User.Status.INACTIVE);
        }
        return Project.projectDto(projectDAO.finishProject(projectFinishDto.getId(), projectFinishDto.getEndDate()));
    }
    public ProjectDto projectSetUsers(ProjectSetUsers projectSetUsers) {
       Project project = projectDAO.get(projectSetUsers.getProjectId());
       List<User> users = userDao.getUsers(projectSetUsers.getUsers());
        for (User user:users) {
            user.setProject(project);
            user.setStatus(User.Status.ACTIVE);
            userDao.update(user);
        }
        return Project.projectDto(projectDAO.get(projectSetUsers.getProjectId()));
    }

    public ProjectStatusDto getProjectsStatus(){
       return projectDAO.getProjectstatus();
    }

}
