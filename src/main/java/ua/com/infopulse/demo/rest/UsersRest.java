package ua.com.infopulse.demo.rest;


import ua.com.infopulse.demo.dto.UserChangeStatusDto;
import ua.com.infopulse.demo.dto.UserDto;
import ua.com.infopulse.demo.services.UserService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;


@Path("/users")
@RequestScoped
public class UsersRest {
    @Inject
    private UserService userService;

    @GET
    @Produces("application/json")
    public UserDto getUser(@QueryParam("id") long id) {
        return userService.get(id);
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public UserDto create(UserDto user) {
        return userService.create(user);
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public UserDto update(UserDto user) {

        return userService.update(user);
    }

    @DELETE
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response delete(@PathParam("id") long id) {
        userService.delete(id);
        return Response.ok().build();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public UserDto changeStatus(UserChangeStatusDto userChangeStatusDto) {
        return userService.changeStatus(userChangeStatusDto);
    }
}
