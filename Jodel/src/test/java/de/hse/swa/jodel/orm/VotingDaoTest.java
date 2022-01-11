package de.hse.swa.jodel.orm;

//imports//

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;

import de.hse.swa.jodel.orm.model.Voting;
import de.hse.swa.jodel.orm.model.Comment;
import de.hse.swa.jodel.orm.model.Post;
import de.hse.swa.jodel.orm.model.User;

import de.hse.swa.jodel.orm.dao.VotingDao;
import de.hse.swa.jodel.orm.dao.CommentDao;
import de.hse.swa.jodel.orm.dao.PostDao;
import de.hse.swa.jodel.orm.dao.UserDao;


@QuarkusTest
class VotingDaoTest {

    @Inject
    VotingDao votingDao;
    @Inject
    PostDao postDao;
    @Inject
    CommentDao commentDao;
    @Inject
    UserDao userDao;


    private User createUser(String prefix) {
        User user = new User();
        user.setUsername(prefix);
        user.setPassword("12345");

        userDao.save(user);

        return user;
    }

    private Post createPost(String postText, String user) {
        Post post = new Post();
        post.setText(postText);
        post.setLongitude(10);
        post.setLatitude(10);

        Date date = new Date();
        post.setPostedat(date);

        post.setAuthorId(createUser(user).getId());

        postDao.save(post);

        return post;
    }

    // testing comment
    private Comment createComment(String commentText, String comWriteUser, String postText, String postWriteUser) {
        Comment comment = new Comment();
        comment.setAuthorId(createUser(comWriteUser).getId());
        comment.setLatitude(10);
        comment.setLongitude(10);
        comment.setPostId(createPost(postText,postWriteUser).getId());
        comment.setText(commentText);

        commentDao.save(comment);

        return comment;
    }

    //voting creation
    private Voting createUpvote(String voterName, String commentText ) {

        Voting voting = votingDao.upvote(createUser(voterName).getId(), createComment(commentText, "Emre", "Testpost", "Halime").getId());

        votingDao.save(voting);

        return voting;
    }


    private Voting createDownvote(String voterName, String commentText ) {

        Voting voting = votingDao.downvote(createUser(voterName).getId(), createComment(commentText, "Halime", "Test", "Das ist ein Post").getId());

        votingDao.save(voting);

        return voting;
    }


    //voting print method
    private void printVoting(Voting voting) {
        System.out.println("id: " + voting.getId());
        System.out.println("Value: " + voting.getValue());
        System.out.println("AuthorId: " + voting.getAuthorId());
        System.out.println("CommentId: " + voting.getCommentId());
    }

    //test upvote
    @Test
    void addUpvote() {
        Voting upvote = createUpvote("Emre", "Das ist Comment");
        List<Voting> votings = votingDao.getAllVoting();
        assertEquals(votings.get(0).getValue(),1);
        printVoting(votings.get(0));
    }

    //test upvote
    @Test
    void addDownvote() {


        Voting downvote = createDownvote("Mike", "Harter Arbeitstag");
        List<Voting> votings = votingDao.getAllVoting();

        assertEquals(votings.get(1).getValue(),-1);

        printVoting(votings.get(1));
    }
}