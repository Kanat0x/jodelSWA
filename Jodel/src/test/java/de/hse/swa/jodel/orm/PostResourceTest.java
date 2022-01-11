//Class for Testing Rest Post Functionality

package de.hse.swa.jodel.orm;

import de.hse.swa.jodel.orm.model.Post;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PostResourceTest
{
    //Gets every post independent of Position
    @Test
    @Order(10)
    public void GetAllPosts()
    {
        given()
                .when().get("/Post/getAllPosts")
                .then()

                .body(is("[{\"authorId\":1,\"id\":1,\"latitude\":1234.0,\"longitude\":1234.0,\"postedat\":\"2022-09-01T00:00:00Z[UTC]\",\"text\":\"Post1\"},{\"authorId\":2,\"id\":2,\"latitude\":1234.0,\"longitude\":1234.0,\"postedat\":\"2022-09-01T00:00:00Z[UTC]\",\"text\":\"Post2\"},{\"authorId\":1,\"id\":3,\"latitude\":123.0,\"longitude\":123.0,\"postedat\":\"2022-09-01T00:00:00Z[UTC]\",\"text\":\"Post3\"},{\"authorId\":2,\"id\":4,\"latitude\":123.0,\"longitude\":123.0,\"postedat\":\"2022-09-01T00:00:00Z[UTC]\",\"text\":\"Post4\"}]"));
    }


    //Depending on position
    @Test
    @Order(20)
    public void GetPosts()
    {
        given()
                .when().get("/Post/getPosts?lat=123&lon=123")
                .then()
                .body(is("[{\"authorId\":1,\"id\":3,\"latitude\":123.0,\"longitude\":123.0,\"postedat\":\"2022-09-01T00:00:00Z[UTC]\",\"text\":\"Post3\"},{\"authorId\":2,\"id\":4,\"latitude\":123.0,\"longitude\":123.0,\"postedat\":\"2022-09-01T00:00:00Z[UTC]\",\"text\":\"Post4\"}]"));
    }



}
