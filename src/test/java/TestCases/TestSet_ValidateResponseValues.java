package TestCases;

import ResponseMethods.AddBookResponse;
import ResponseMethods.GetBookResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import io.restassured.RestAssured;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLOutput;

@Listeners(Utils.ListenersTest.class)

public class TestSet_ValidateResponseValues {

    @Test
    public void verifyAddBookPOSTMethodResponseValues() throws JsonProcessingException {

        RestAssured.baseURI = "http://216.10.245.166";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Agile1"); // Cast
        requestParams.put("isbn", "12209");
        requestParams.put("aisle", "12AA4");
        requestParams.put("author", "Rowling123");
        request.body(requestParams.toJSONString());

        Response response = request.post("/Library/Addbook.php");
        /*Response responseAddBook = request.header("Content-Type", "application/json").body(requestParams).
                when().post("Library/Addbook.php").then().log().all().
                assertThat().statusCode(200).extract().response();
*/
        int statusCode = response.getStatusCode();
        //Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("POST - AddBook Response Status: "+statusCode);
      String json = response.asString();
        System.out.println(json);

        /*String AddBookResponse = response.
        System.out.println(AddBookResponse);
        System.out.println(response);*/


            ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            //Convereted to Type as array
            AddBookResponse[] addBookResponses = mapper.readValue(json, AddBookResponse[].class);






        /*AddBookResponse[] addBookResponses = response.as(AddBookResponse[].class);*/
        String Msg = addBookResponses[0].getMsg();
        String ID = addBookResponses[0].getID();
        System.out.println(Msg);
        System.out.println(ID);


        /*Assert.assertEquals(actual, "1200512AA4");
        System.out.println(actual);*/
    }

    @Test
    public void verifyGetBookByIdGETMethodResponseValues(){
        RestAssured.baseURI = "http://216.10.245.166";

        RequestSpecification request = RestAssured.given().queryParam("ID", "7901");

        Response response = request.get("/Library/GetBook.php");

        GetBookResponse[] getBookResponses = response.as(GetBookResponse[].class);

        String actual = getBookResponses[0].getAuthor();
        System.out.println(actual);
        Assert.assertEquals(actual, "pooja");

        //Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("GetBook GET Method Status returned: "+response.getStatusCode());
    }

}

