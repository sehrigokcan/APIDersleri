package Post_Requests;

import baseUrls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class post01 extends JsonPlaceHolderBaseUrl {
     /*
         Given
           1)  https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
                }
        When
         I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */
 /*
}

  */@Test
public void post01() {
    //Set the url
spec.pathParam("first","todos");

// set the expected data
    JSONObject expectedData= new JSONObject();
    expectedData.put("userId",55);
    expectedData.put("title","Tidy your room");
    expectedData.put("completed",false);


    Map<String,Object> expectedData2= new HashMap<>();
    expectedData2.put("userId",55);
    expectedData2.put("title","Tidy your room");
    expectedData2.put("completed",false);


    // send the request get the response

    Response response= given().spec(spec).when().body(expectedData.toString()).post("/{first}");
    response.prettyPrint();

    // do assertion

    JsonPath actualData= response.jsonPath();
    assertEquals(expectedData.get("userId"),actualData.get("userId"));
    assertEquals(expectedData.get("title"),actualData.get("title"));
    assertEquals(expectedData.get("completed"),actualData.get("completed"));

    Map<String,Object> actualData2=response.as(HashMap.class);
    assertEquals(expectedData2.get("userId"),actualData2.get("userId"));
    assertEquals(expectedData2.get("title"),actualData2.get("title"));
    assertEquals(expectedData2.get("completed"),actualData2.get("completed"));

}
}