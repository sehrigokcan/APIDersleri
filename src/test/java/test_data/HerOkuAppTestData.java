package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {
//    {
//        "firstname": "Ali",
//            "lastname": "Can",
//            "totalprice": 999,
//            "depositpaid": true,
//            "bookingdates": {
//        "checkin": "2021-09-21",
//         "checkout": "2021-12-21"
//    },
//        "additionalneeds": "Breakfast"
//    }
    public Map<String, String> bookingdatesMapMethod(String checkin, String checkout){
        Map<String, String> bookingdatesMap= new HashMap<>();
        bookingdatesMap.put("checkin",checkin);
        bookingdatesMap.put("checkout",checkout);
        return bookingdatesMap;
    }

    public Map<String , Object> expectedDataMethod(String firstname,String lastname,int totalprice,boolean depositpaid,Map<String, String> bookingdatesMapMethod,String additionalneeds){
        Map<String , Object> expectedDataMethod= new HashMap<>();
        expectedDataMethod.put("firstname",firstname);
        expectedDataMethod.put("lastname",lastname);
        expectedDataMethod.put("totalprice",totalprice);
        expectedDataMethod.put("depositpaid",depositpaid);
        expectedDataMethod.put("bookingdates",bookingdatesMapMethod);
        expectedDataMethod.put("additionalneeds",additionalneeds);

        return expectedDataMethod;
    }

}
