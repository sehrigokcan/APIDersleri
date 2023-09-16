package baseUrls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static util.AuthenticationBookingApp.generateToken;

public class HerOkuAppBaseUrl {
    protected RequestSpecification spec;

    @Before
    public void setUp(){
        spec = new RequestSpecBuilder().
                setContentType(ContentType.JSON).addHeader("Cookie","token="+ generateToken()).setBaseUri("https://restful-booker.herokuapp.com").build();

    }
}
