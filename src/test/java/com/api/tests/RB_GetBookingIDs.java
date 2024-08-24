package com.api.tests;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.apache.commons.logging.Log;

import static com.util.TestUtil.*;

import io.restassured.http.Header;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class RB_GetBookingIDs {
	public static void main(String[] args) throws IOException {
		baseURI =getqaProperties("qa.properties", "BASE_URL");
		Response response = given()
				.header(new Header("Accept", "application/json"))
				.log().all()
				.get("booking/2231");
		System.out.println(response.asPrettyString());
		System.out.println(response.statusCode());
		
	
	}

}
