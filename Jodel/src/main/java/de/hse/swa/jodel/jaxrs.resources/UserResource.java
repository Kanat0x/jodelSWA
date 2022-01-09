package de.hse.swa.jodel.jaxrs.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import javax.inject.Inject;
import javax.ws.rs.core.Context;

import de.hse.swa.jodel.orm.dao.UserDao;
import de.hse.swa.jodel.orm.model.User;
import io.vertx.core.http.HttpServerRequest;

import java.util.List;


@Path("/Users")
public class UserResource {


    @Inject
    UserDao userDao;

    @Context
    HttpServerRequest request;

    @POST
    @Path("login")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public User login(User user) {
        return this.userDao.login(user.getUsername(), user.getPassword());
    }

    @GET
    @Path("getAllUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUser()
    {
        return userDao.getUsers();
    }

    @GET
    @Path("getUser")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User getUsername(@QueryParam("userId") Long userId)
    {
        return userDao.getUser(userId);
    }

}

