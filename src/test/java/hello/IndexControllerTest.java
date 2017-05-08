package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class IndexControllerTest {
    @Test
    public void should_get_index_content() throws Exception {
        given().standaloneSetup(new IndexController())
            .when().get("/")
            .then().statusCode(200)
            .body(equalTo("it works"));

    }
}