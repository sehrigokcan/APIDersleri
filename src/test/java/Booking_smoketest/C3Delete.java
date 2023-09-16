package Booking_smoketest;

import baseUrls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static Booking_smoketest.A1Post.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C3Delete extends HerOkuAppBaseUrl {
      /*
    Given
        1. https://restful-booker.herokuapp.com/booking/id

    When
        Send delete request

    Then
        Status code should be 201
        Body should be "Created"


     */

    @Test
    public void delete(){
        spec.pathParams("first","booking","second",bookingId);

        Response response= given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

        assertEquals(201,response.statusCode());
        assertEquals("Created",response.asString());
    }
}
