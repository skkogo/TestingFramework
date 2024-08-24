package com.api.tests;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import com.pojo_3.CreateTokenPOJO;

import static com.util.TestUtil.*;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class RB_CreateToken {
	public static void main(String[] args) throws IOException {
		baseURI =getqaProperties("qa.properties", "BASE_URL");
		Response response = given()
				.header(new Header("Content-Type", "application/json"))
				.body(convertPOJOtoJSON(new CreateTokenPOJO("admin", "password123")))
				.log().all()
				.post("auth");

		System.out.println(response.asPrettyString());
		System.out.println(response.statusCode());
		JsonPath jsonpath= new JsonPath(response.asPrettyString());
	String jsonpathdata= jsonpath.get("token");
	System.out.println(jsonpathdata);
	
	}

}
