package de.hse.swa.jodel.orm;


//imports//

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;



import javax.inject.Inject;
import javax.persistence.*;
import javax.ws.rs.core.MediaType;

import de.hse.swa.jodel.jaxrs.resources.CommentResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
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


import de.hse.swa.jodel.orm.dao.UserDao;
import de.hse.swa.jodel.orm.model.User;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CommentResourceTest {

    //Post 1
    @Test
    @Order(10)
    public void GetComments() {
        given()

                .when().get("/Comments/getComments?postId=1")
                .then()
                .body(is("[{\"authorId\":1,\"id\":1,\"latitude\":123.0,\"longitude\":123.0,\"postId\":1,\"postedat\":\"2022-09-01T00:00:00Z[UTC]\",\"text\":\"1. Test Comment User 1\"}]"));
    }

    //Post 2
    @Test
    @Order(20)
    public void GetCommentsForPost2()
    {
        given()

                .when().get("/Comments/getComments?postId=2")
                .then()

                .body(is("[{\"authorId\":2,\"id\":2,\"latitude\":123.0,\"longitude\":123.0,\"postId\":2,\"postedat\":\"2022-09-01T00:00:00Z[UTC]\",\"text\":\"2. Test Comment User 1\"}]"));
    }

    //Post 3
    @Test
    @Order(30)
    public void GetCommentsForPost3()
    {
        given()

                .when().get("/Comments/getComments?postId=3")
                .then()

                .body(is("[{\"authorId\":2,\"id\":3,\"latitude\":123.0,\"longitude\":123.0,\"postId\":3,\"postedat\":\"2022-09-01T00:00:00Z[UTC]\",\"text\":\"1. Test Comment User 2\"}]"));
    }

    //Post 4
    @Test
    @Order(40)
    public void GetCommentsForPost4()
    {
        given()

                .when().get("/Comments/getComments?postId=4")
                .then()

                .body(is("[{\"authorId\":2,\"id\":4,\"latitude\":123.0,\"longitude\":123.0,\"postId\":4,\"postedat\":\"2022-09-01T00:00:00Z[UTC]\",\"text\":\"2. Test Comment User 2\"}]"));
    }
}



