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
class CommentDaoTest {

    @Inject
    PostDao postDao;
    @Inject
    CommentDao commentDao;
    @Inject
    UserDao userDao;


    // create test user
    private User createUser(String prefix) {
        User user = new User();
        user.setUsername(prefix);
        user.setPassword("12345");

        userDao.save(user);

        return user;
    }

    // create test post
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


    //voting print method
    private void printComment(Comment comment) {
        System.out.println("id: " + comment.getId());
        System.out.println("postId: " + comment.getPostId());
        System.out.println("text: " + comment.getText());
        System.out.println("authorId: " + comment.getAuthorId());
        System.out.println("postedat: " + comment.getPostedat());
        System.out.println("longitude: " + comment.getLongitude());
        System.out.println("latitude: " + comment.getLatitude());
    }



    //test comment
    @Test
    void addComment() {
        Comment comment = createComment("Kommentar hinzufügen", "Emre", "Das ist ein Post", "Halime");
        List<Comment> comments = commentDao.getAllComments();
        assertEquals(comments.size(),5);
        printComment(comments.get(0));
    }
}