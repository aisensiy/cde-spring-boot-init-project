package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
public class GreetingControllerTest {
    @Test
    public void should_get_status_200_and_get_right_message() throws Exception {
        given().standaloneSetup(new GreetingController())
                .param("name", "test")
                .when().get("/greeting")
                .then().statusCode(200)
                .body("id", equalTo(1))
                .body("message", equalTo("Hello, test"));
    }
}
