
import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class RestAssuredTest {

    String url = "http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador";

    @Test
    public void getId(){

        get(url).then().body("id", equalTo(1));

    }

    @Test
    public void getMeses(){

        List<String> list1 = Arrays.asList("112", "124", "136", "148");


        get(url).then().body("meses", equalTo(list1));

    }

    @Test
    public void getValor(){
        List<String> valor = Arrays.asList("2.802","3.174","3.564","3.971");
        get(url).then().body("valor", equalTo(valor));
        
        ////Read more: https://www.java67.com/2016/10/3-ways-to-convert-string-to-json-object-in-java.html#ixzz6O9jVssWv
        //https://www.toolsqa.com/rest-assured/read-json-response-body-using-rest-assured/
        //visite isso https://www.baeldung.com/rest-assured-response
        //
        
        String responseString = get(url).then()
            .assertThat()
            .statusCode(200)
            .extract()
            .asString();
        try {
            JSONParser parser = new JSONParser(); 
            JSONObject json = (JSONObject) parser.parse(responseString);
            System.out.println("r "+json.toJSONString());
            
        } catch (Exception e) {
            
        }
        

        

        

    }


//    @Test
//    public void getPageOne(){
//
//        given().
//                param("page", "1").
//                when().
//                get(url).
//                then().
//                statusCode(200).
//                body("page", equalTo(1));
//    }

//    @Test
//    public void getTotal(){
//
//        given().
//                param("page", "1").
//                when().
//                get(url).
//                then().
//                statusCode(200).
//                body("total", equalTo(12));
//    }

    //@Test
    //public void getUser() {
    //    get(url + "/2").then().body("data.id", equalTo(2));
    //}
}