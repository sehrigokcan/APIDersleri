package Booking_smoketest;

import baseUrls.HerOkuAppBaseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;
import pojos.bookingdatespojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class A1Post extends HerOkuAppBaseUrl {
    static  int bookingId;
    /*
 Given
     1. https://restful-booker.herokuapp.com/booking

2.{
 "firstname" : "Jim",
 "lastname" : "Brown",
 "totalprice" : 111,
 "depositpaid" : true,
 "bookingdates" : {
     "checkin" : "2018-01-01",
     "checkout" : "2019-01-01"
 },
 "additionalneeds" : "Breakfast"
}'
 When
     Send post request

 Then
     Status code should be 200
     Body should be like:
{
         "bookingid": 9268,
         "booking": {
             "firstname": "Jim",
             "lastname": "Brown",
             "totalprice": 111,
             "depositpaid": true,
             "bookingdates": {
                 "checkin": "2018-01-01",
                 "checkout": "2019-01-01"
             },
             "additionalneeds": "Breakfast"
         }
     }


  */
    @Test
    public void post() {
        //Set the Url
        spec.pathParam("first", "booking");

        //Send the expected data
        bookingdatespojo bookingDates = new bookingdatespojo("2018-01-01", "2019-01-01");
        BookingPojo exceptedData = new BookingPojo("Jim", "Brown", 111, true, bookingDates, "Breakfast");

        // get the request send the response
        Response response = given().spec(spec).body(exceptedData).post("{first}");
        response.prettyPrint();

        // do assertion
        BookingResponsePojo actualData = response.as(BookingResponsePojo.class);
        assertEquals(200, response.statusCode());
        assertEquals(exceptedData.getBookingdates().getCheckin(), actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(exceptedData.getBookingdates().getCheckout(), actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(exceptedData.getFirstname(), actualData.getBooking().getFirstname());
        assertEquals(exceptedData.getLastname(), actualData.getBooking().getLastname());
        assertEquals(exceptedData.getAdditionalneeds(), actualData.getBooking().getAdditionalneeds());
        assertEquals(exceptedData.getTotalprice(), actualData.getBooking().getTotalprice());

        bookingId= actualData.getBookingid();
    }
}
