package de.hse.swa.jodel.orm;

//imports//

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import de.hse.swa.jodel.orm.model.Post;
import de.hse.swa.jodel.orm.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.hse.swa.jodel.orm.dao.UserDao;
import de.hse.swa.jodel.orm.dao.PostDao;
import io.quarkus.test.junit.QuarkusTest;

//required objects from types:
// 1 user
// 1 post from user

@QuarkusTest
class PostDaoTest {

    @Inject
    UserDao userDao;

    @Inject
    PostDao postDao;

    // create user
    private User createUser(String name) {
        User user = new User();
        user.setUsername(name);
        user.setPassword("password");
        userDao.save(user);
        return user;
    }

    // create post
    private Post createPost(User user, String text) {
        Post post = new Post();
        post.setText(text);
        post.setAuthorId(user.getId());
        post.setPostedat(new Date());
        post.setLongitude(10);
        post.setLatitude(20);
        postDao.save(post);
        return post;
    }

    //print post
    private void printPost(Post post) {
        System.out.println("id: " + post.getId());
        System.out.println("text: " + post.getText());
        System.out.println("authorId: " + post.getAuthorId());
        System.out.println("postedat: " + post.getPostedat());
        System.out.println("longitude: " + post.getLongitude());
        System.out.println("latitude: " + post.getLatitude());
    }

    @Test
    void addPostTest() {

        // create test user and test post
        User user = createUser("Herbert");
        Post post = createPost(user, "Marcel hat keine Katzenbabies!!!1!11!!!");

        List<Post> posts = postDao.getAllPosts();
        assertEquals(posts.size(), 5);
        printPost(post);
    }
}