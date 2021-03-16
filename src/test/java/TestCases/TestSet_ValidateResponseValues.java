package TestCases;

import ResponseMethods.AddBookResponse;
import ResponseMethods.GetBookResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utils.ListenersTest.class)

public class TestSet_ValidateResponseValues {



    @Test(priority = 0)
    public void verifyAddBookPOSTMethodResponseValues() throws JsonProcessingException {

        RestAssured.baseURI = "http://216.10.245.166";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Agile1");
        requestParams.put("isbn", "12224");
        requestParams.put("aisle", "12AA4");
        requestParams.put("author", "Rowling123");
        request.body(requestParams.toJSONString());

        Response response = request.post("/Library/Addbook.php");

        int statusCode = response.getStatusCode();

        System.out.println("POST - AddBook Response Status: "+statusCode);
        String json = response.asString();


        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        AddBookResponse[] addBookResponses = mapper.readValue(json, AddBookResponse[].class);

        String actualID = addBookResponses[0].getID();
        Assert.assertEquals(actualID, "1222412AA4");
        System.out.println("Response ID: "+actualID);

    }

    @Test(priority = 1)
    public void verifyGetBookByIdGETMethodResponseValues(){
        RestAssured.baseURI = "http://216.10.245.166";

        RequestSpecification request = RestAssured.given().queryParam("ID", "78");

        Response response = request.get("/Library/GetBook.php");

        GetBookResponse[] getBookResponses = response.as(GetBookResponse[].class);

        String actual = getBookResponses[0].getAuthor();

        Assert.assertEquals(actual, "pooja");
        System.out.println("GetBook GET Method Status returned: "+response.getStatusCode());
    }


    @Test (priority = 2)
    public void verifyAddBookAndGetBookDetails() throws JsonProcessingException {

        RestAssured.baseURI = "http://216.10.245.166";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Agile1");
        requestParams.put("isbn", "12239");
        requestParams.put("aisle", "1200");
        requestParams.put("author", "Rowling123");
        request.body(requestParams.toJSONString());

        Response response = request.post("/Library/Addbook.php");

        int statusCode = response.getStatusCode();

        System.out.println("POST - AddBook Response Status: "+statusCode);
        String json = response.asString();


        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        AddBookResponse[] addBookResponses = mapper.readValue(json, AddBookResponse[].class);

        String actualID = addBookResponses[0].getID();

        //System.out.println("Response ID: "+actualID);

        RequestSpecification request1 = RestAssured.given().queryParam("ID", actualID);

        Response response1 = request1.get("/Library/GetBook.php");

        String json2 = response1.asString();

        ObjectMapper mapper2 = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        GetBookResponse[] getBookResponses = mapper2.readValue(json2, GetBookResponse[].class);

        String actualAuthor = getBookResponses[0].getAuthor();

        //System.out.println(actualAuthor);
        Assert.assertEquals(actualAuthor, "Rowling123");
        System.out.println("GetBook GET Method Status returned: "+response.getStatusCode());

    }
}

