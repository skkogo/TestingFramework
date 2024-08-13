package r_booker;

import static io.restassured.RestAssured.*;

import com.pojo_3.CreateToken;

import static com.util.TestUtil.*;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class RB_CreateToken {
	public static void main(String[] args) {
		baseURI = "https://restful-booker.herokuapp.com";
		Response response = given()
				.header(new Header("Content-Type", "application/json"))
				.body(convertPOJOtoJSON(new CreateToken("admin", "password123")))
				.post("auth");

		System.out.println(response.asPrettyString());
		System.out.println(response.statusCode());
		JsonPath jsonpath= new JsonPath(response.asPrettyString());
	String jsonpathdata= jsonpath.get("token");
	System.out.println(jsonpathdata);
	
	}

}
