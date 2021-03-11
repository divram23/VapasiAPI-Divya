package TestCases;

import RequestMethods.AddBookRequest;
import ResponseMethods.GetBookResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utils.ListenersTest.class)

public class TestSet_ValidateStatusCode {



@Test
    public void verifyAddBookPOSTMethod(){
    RestAssured.baseURI = "http://216.10.245.166";

    AddBookRequest addBookRequest = new AddBookRequest();
    addBookRequest.setName("Agile Development");
    addBookRequest.setIsbn("10013");
    addBookRequest.setAisle("1A");
    addBookRequest.setAuthor("Rowling");

    Response response = null;

    try {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(addBookRequest)
                .post("/Library/Addbook.php");
    } catch (Exception e) {
        e.printStackTrace();
    }

    System.out.println("POST - AddBook Response Status: "+response.getStatusCode());
    Assert.assertEquals(response.getStatusCode(), 200);

}

@Test
    public void verifyPOSTWithJSONParameters(){

    RestAssured.baseURI = "http://216.10.245.166";
    RequestSpecification request = RestAssured.given();

    JSONObject requestParams = new JSONObject();
    requestParams.put("name", "Agile1"); // Cast
    requestParams.put("isbn", "12004");
    requestParams.put("aisle", "12AA4");
    requestParams.put("author", "Rowling123");
    request.body(requestParams.toJSONString());

    Response response = request.post("/Library/Addbook.php");

    int statusCode = response.getStatusCode();
    Assert.assertEquals(response.getStatusCode(), 200);
    System.out.println("POST - AddBook Response Status: "+statusCode);

}

@Test
    public void verifyGetBookByIdGETMethod(){
    RestAssured.baseURI = "http://216.10.245.166";

    RequestSpecification request = RestAssured.given().queryParam("ID", "1200412AA4");

    Response response = request.get("/Library/GetBook.php");

    Assert.assertEquals(response.getStatusCode(), 200);
    System.out.println("GetBook GET Method Status returned: "+response.getStatusCode());
}

}
