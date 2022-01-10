package de.hse.swa.jodel.jaxrs.resources;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import de.hse.swa.jodel.orm.dao.PostDao;
import de.hse.swa.jodel.orm.model.Post;
import de.hse.swa.jodel.orm.model.User;
import io.vertx.core.http.HttpServerRequest;

@RequestScoped
@Path("/Post")
public class PostResource {

    @Inject
    PostDao postDao;

    @Context
    HttpServerRequest request;

    @GET
    @Path("getPosts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getPosts(@QueryParam("lat") double lat,@QueryParam("lon") double lon)
    {
        return postDao.getPosts(lat, lon);
    }

    @GET
    @Path("getAllPosts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getAllPosts()
    {
        return postDao.getAllPosts();
    }

    @GET
    @Path("getOne")
    @Produces(MediaType.APPLICATION_JSON)
    public int getOne()
    {
        return 1111;
    }


    @GET
    @Path("getOnePost")
    @Produces(MediaType.APPLICATION_JSON)
    public Post getOnePost()
    {
        User user = new User();
        user.setUsername("Ulrich");
        user.setPassword("1234");
        Post post = new Post();
        post.setPostedat(new Date());
        post.setText("First Post");
        post.setLatitude(0);
        post.setLongitude(0);
        post.setAuthorId(user.getId());

        return post;
    }


    @POST
    @Path("createPost")
    @Produces(MediaType.APPLICATION_JSON)
    public Post createPost(@QueryParam("text") String text, @QueryParam("lon") double longitude, @QueryParam("lat") double latitude, @QueryParam("authorId") Long authorId ){

        Post post = new Post(text, longitude, latitude, authorId);
        return postDao.save(post);
    }

}