package Get_Requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get02 {
        /*
        Given
            https://restful-booker.herokuapp.com/booking/55
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
          */

    @Test
    public  void get02(){
        //Set the URL
        String url="https://restful-booker.herokuapp.com/booking/527";

        // Send the rewuest and get the response

        Response response= given().when().get(url);
        response.prettyPrint();

        //Do assertion
        assertEquals(200,response.statusCode());
        assertEquals("application/json; charset=utf-8",response.contentType());
        assertEquals("HTTP/1.1 200 OK",response.statusLine());

    }

}
