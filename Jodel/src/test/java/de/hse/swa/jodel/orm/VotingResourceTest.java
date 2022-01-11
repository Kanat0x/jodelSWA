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



import de.hse.swa.jodel.orm.dao.UserDao;
import de.hse.swa.jodel.orm.model.User;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class VotingResourceTest {

    @Test
    @Order(10)
    public void GetVotings2()
    {
        given()

                .when().get("/voteComment/getVotings?commentId=1")
                .then()
                .body(is(""));
    }


    @Test
    @Order(20)
    public void upvoteTest()
    {
        given()
                .when().post("/voteComment/upvote?userId=" + 1L + "&commentId="+ 1L)
                .then()
                .body(is(""));

    }

    @Test
    @Order(30)
    public void downvoteTest()
    {
        Long testlong = 1L;
        given()
                .when().post("/voteComment/downvote?userId="+ 1 + "&commentId="+ 1)
                .then()
                .body(is(""));

    }
}
