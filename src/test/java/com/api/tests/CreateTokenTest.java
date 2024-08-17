package com.api.tests;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pojo_3.CreateToken;

import io.restassured.http.Header;

import static com.util.TestUtil.*;

public class CreateTokenTest {
	@BeforeMethod(description = "setting up the BaseURL for API using properties file")
	public void setup() throws IOException {
		baseURI= getqaProperties("qa.properties", "BASE_URL");
	}
	
	@Test(description = "verify that token has been created after run this API", groups = {"e2e", "smoke","sanity"})
	public void test_create_token_API() {
		given()
			.header(new Header("Content-Type", "application/json"))
			.body(convertPOJOtoJSON( new CreateToken("admin", "password123")))
		.when()
			.log().all()
			.post("auth")
		.then()
			.statusCode(200)
			.body(Matchers.containsString("token"));
		
		
		
		
	}
	
}
