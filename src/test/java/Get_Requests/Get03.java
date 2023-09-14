package Get_Requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

public class Get03 {
    //    Given
//    https://jsonplaceholder.typicode.com/todos/23
//    When
//    User send GET Request to the URL
//            Then
//    HTTP Status Code should be 200
//    And
//    Response format should be “application/json”
//    And
//		    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
//    And
//		    “completed” is false
//    And
//		    “userId” is 2

    @Test
    public  void get03(){
        //Set the URL
        String url="https://jsonplaceholder.typicode.com/todos/23";

        // Send the request and get the response

        Response response= given().when().get(url);
        response.prettyPrint();

        //Do assertion
        assertEquals(200,response.statusCode());
        assertEquals("application/json; charset=utf-8",response.contentType());
        assertEquals("HTTP/1.1 200 OK",response.statusLine());

        //2. yol

        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"))
                .body("completed",equalTo(false))
                .body("userId",equalTo(2));

        //3. yol
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),
                        "userId",equalTo(2));





    }
}
