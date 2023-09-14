package Get_Requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Get01 {
        /*
    1)Postman manuel API testi için kullanilir.
    2)API otomasyonu için Rest-Assured Library kullanacagiz.
    3)Otomasyon kodlarının yazımı için şu adımları izliyoruz:
       a) Gereksinimleri anlama
       b) Test case i yazma:
          -Test case i yazmak için "Gherkin Language" kullaniyoruz.
           x) Given: Ön koşullar  --> Endpoint, body
           y) When : İşlemler --> Get,Put,Delete...
           z) Then : Dönütler --> Assert
           t) And --> Çoklu işlemlerin art arda yazilacağı yerlerde kullanilir.
        c) Test kodunu yazarken şu adımları izleriz:
           i)    Set the URL
           ii)   Set the expected data (Post Put Patch)
           iii)  Send the request and get the response
           iv)   Do assertion

     */
    public static void main(String[] args){
        String url="https://restful-booker.herokuapp.com/booking/527";

        Response response= given().when().get(url);
        response.prettyPrint();

        System.out.println(" Status code: "+ response.statusCode());

        System.out.println(response.contentType());

        System.out.println(" Status Line" +response.statusLine());

        System.out.println(" Heade: " + response.header("Connection"));

        System.out.println(response.headers());

        System.out.println(response.getTime());





    }
}
