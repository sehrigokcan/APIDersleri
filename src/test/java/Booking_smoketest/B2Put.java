package Booking_smoketest;

import baseUrls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;
import pojos.bookingdatespojo;

import static Booking_smoketest.A1Post.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class B2Put extends HerOkuAppBaseUrl {
     /*
    Given   1. https://restful-booker.herokuapp.com/booking/id

2.{
    "firstname" : "Sehri",
    "lastname" : "Gokcan",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}'
When
    Set put request

    Then
    Status code should be 200
    And
    {
    "firstname" : "Sehri",
    "lastname" : "Gokcan",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}'
     */

    @Test
    public void put() {
        //Set the url
        spec.pathParams("first", "booking", "second", bookingId);

        //Set the expected data
        bookingdatespojo bookingDatesPojo = new bookingdatespojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData = new BookingPojo("Sehri", "Gokcan", 111, true, bookingDatesPojo, "Breakfast");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).body(expectedData).put("/{first}/{second}");

        response.prettyPrint();

        //Do Assertion
        BookingPojo actualData = response.as(BookingPojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200, response.statusCode());

        assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        assertEquals(expectedData.isDepositpaid(), actualData.isDepositpaid());

        assertEquals(bookingDatesPojo.getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(), actualData.getBookingdates().getCheckout());

        assertEquals(expectedData.getAdditionalneeds(), actualData.getAdditionalneeds());

    }
}
