package ua.com.infopulse.demo.rest;

import ua.com.infopulse.demo.dto.ProjectDto;
import ua.com.infopulse.demo.dto.ProjectFinishDto;
import ua.com.infopulse.demo.dto.ProjectSetUsers;
import ua.com.infopulse.demo.dto.ProjectStatusDto;
import ua.com.infopulse.demo.services.ProjectService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/projects")
@RequestScoped
public class ProjectsRest {
    @Inject
    private ProjectService projectService;

    @GET
    @Produces("application/json")
    public ProjectDto getProject(@QueryParam("id") long id) {
        return projectService.getProject(id);
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public ProjectDto create(ProjectDto project) {
        return projectService.createProject(project);
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public ProjectDto update(ProjectDto project) {
        return projectService.updateProject(project);
    }

    @DELETE
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response delete(@PathParam("id") long id) {
        projectService.deleteProject(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/finish")
    @Consumes("application/json")
    @Produces("application/json")
    public ProjectDto finishProject(ProjectFinishDto projectFinishDto) {
        return projectService.finishProject(projectFinishDto);
    }

    @GET
    @Path("/status")
    @Produces("application/json")
    public ProjectStatusDto getProjectsStatus() {
        return projectService.getProjectsStatus();
    }

    @POST
    @Path("/setUsers")
    @Consumes("application/json")
    @Produces("application/json")
    public ProjectDto projectSetUsers(ProjectSetUsers projectSetUsers) {
        return projectService.projectSetUsers(projectSetUsers);
    }
}
