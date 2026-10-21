
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class EchoApiTest {

    private static final String BASE_URL = "https://postman-echo.com";

    // ========== 1. GET запрос ==========
    @Test
    public void testGetMethod() {
        // Отправляем GET запрос с параметром foo1=bar1
        given()
                .baseUri(BASE_URL)
                .when()
                .get("/get?foo1=bar1")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1"));
    }

    // ========== 2. POST запрос ==========
    @Test
    public void testPostMethod() {
        String requestBody = "{\"name\": \"Alex\", \"role\": \"QA\"}";

        given()
                .baseUri(BASE_URL)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("json.name", equalTo("Alex"))
                .body("json.role", equalTo("QA"));
    }

    // ========== 3. PUT запрос ==========
    @Test
    public void testPutMethod() {
        String requestBody = "{\"status\": \"updated\"}";

        given()
                .baseUri(BASE_URL)
                .contentType(ContentType.TEXT)
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", containsString("updated"));
    }

    // ========== 4. PATCH запрос ==========
    @Test
    public void testPatchMethod() {
        String requestBody = "{\"field\": \"patched\"}";

        given()
                .baseUri(BASE_URL)
                .contentType(ContentType.TEXT)
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", containsString("patched"));
    }

    // ========== 5. DELETE запрос ==========
    @Test
    public void testDeleteMethod() {
        given()
                .baseUri(BASE_URL)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("ok", nullValue());
    }
}