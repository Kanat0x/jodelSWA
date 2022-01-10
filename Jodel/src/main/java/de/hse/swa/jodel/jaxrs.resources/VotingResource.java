package de.hse.swa.jodel.jaxrs.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import javax.inject.Inject;
import javax.ws.rs.core.Context;

import de.hse.swa.jodel.orm.model.User;
import de.hse.swa.jodel.orm.model.Voting;
import de.hse.swa.jodel.orm.model.Comment;
import io.vertx.core.http.HttpServerRequest;
import de.hse.swa.jodel.orm.dao.VotingDao;

import java.util.List;

@Path("/voteComment")
public class VotingResource {

    @Inject
    VotingDao voteDao;

    @Context
    HttpServerRequest request;

    @GET
    @Path("getVotings")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Voting> getVotings(Long commentId)
    {
        return voteDao.getVotings(commentId);
    }


    @GET
    @Path("getLikes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Voting> getLikes(@QueryParam("commentId") Long commentId)
    {
        return voteDao.getLikes(commentId);
    }


    @GET
    @Path("getDislikes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Voting> getDislikes(@QueryParam("commentId") Long commentId)
    {
        return voteDao.getDislikes(commentId);
    }

    @POST
    @Path("upvote")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Voting upvote(@QueryParam("authorId") Long userId,@QueryParam("commentId")  Long commentId)
    {
        return voteDao.upvote(userId, commentId);
    }

    @POST
    @Path("downvote")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Voting downvote(@QueryParam("authorId") Long userId,@QueryParam("commentId")  Long commentId)
    {
        return voteDao.downvote(userId, commentId);
    }

}