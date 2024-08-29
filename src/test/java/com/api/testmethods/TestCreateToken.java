package com.api.testmethods;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pojo_3.CreateTokenPOJO;

import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;

import static com.util.TestUtil.*;

public class TestCreateToken {
	File jsonfileSchema= new File(System.getProperty("user.dir")+"//src//test//resources//responseSchema//createTokenResponseSchema.json");
	@BeforeMethod(description = "setting up the BaseURL for API using properties file")
	public void setup() throws IOException {
		baseURI= getqaProperties("qa.properties", "BASE_URL");
	}
	
	@Test(description = "verify that token has been created after run this API", groups = {"e2e", "smoke","sanity"})
	public void test_create_token_API() {
		given()
			.header(new Header("Content-Type", "application/json"))
			.body(convertPOJOtoJSON( new CreateTokenPOJO("admin", "password123")))
		.when()
			.log().all()
			.post("auth")
		.then()
			.log().all()
			.statusCode(200)
			.body(JsonSchemaValidator.matchesJsonSchema(jsonfileSchema))
			.body(Matchers.containsString("token"));
		
		
		
		
	}
	
}
