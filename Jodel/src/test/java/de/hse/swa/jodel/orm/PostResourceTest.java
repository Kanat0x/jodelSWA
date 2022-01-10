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

                .body(is("[{\"authorId\":1,\"id\":1,\"latitude\":24.0,\"longitude\":25345.0,\"postedat\":\"2020-09-09T00:00:00Z[UTC]\",\"text\":\"Das ist ein Post\"},{\"authorId\":2,\"id\":2,\"latitude\":32265.0,\"longitude\":2324.0,\"postedat\":\"2020-09-09T00:00:00Z[UTC]\",\"text\":\"Und das ist der zweite Post\"},{\"authorId\":1,\"id\":3,\"latitude\":24.0,\"longitude\":25345.0,\"postedat\":\"2020-09-09T00:00:00Z[UTC]\",\"text\":\"Ich habe keine lust mehr\"},{\"authorId\":2,\"id\":4,\"latitude\":32265.0,\"longitude\":2324.0,\"postedat\":\"2020-09-09T00:00:00Z[UTC]\",\"text\":\"Das ist eaber schönes wetter\"}]"));
    }


    //Depending on position
    @Test
    @Order(20)
    public void GetPosts()
    {
        given()
                .when().get("/Post/getPosts?lat=24&lon=25345")
                .then()
                .body(is("[{\"authorId\":1,\"id\":1,\"latitude\":24.0,\"longitude\":25345.0,\"postedat\":\"2020-09-09T00:00:00Z[UTC]\",\"text\":\"Das ist ein Post\"},{\"authorId\":1,\"id\":3,\"latitude\":24.0,\"longitude\":25345.0,\"postedat\":\"2020-09-09T00:00:00Z[UTC]\",\"text\":\"Ich habe keine lust mehr\"}]"));
    }



}
