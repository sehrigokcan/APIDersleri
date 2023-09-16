package Booking_smoketest;

import baseUrls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static Booking_smoketest.A1Post.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class D4Get extends HerOkuAppBaseUrl {

    @Test
    public void get(){
            /*
    Given
        https://restful-booker.herokuapp.com/booking/id

    When
    Send the Get request

      Then
        Status code should be 404

     */

        spec.pathParams("first","booking","second",bookingId);

        Response response= given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        assertEquals(404,response.statusCode());
        assertEquals("Not Found",response.asString());

    }
}
