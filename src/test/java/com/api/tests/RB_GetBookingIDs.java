package com.api.tests;

import static io.restassured.RestAssured.*;
import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.util.TestUtil;

import io.restassured.http.Header;
import io.restassured.response.Response;

import static com.util.TestUtil.*;

public class RB_GetBookingIDs {
	@BeforeMethod(description = "settinup the base url " )
	public void setup() throws IOException {
		baseURI = TestUtil.getqaProperties("qa.properties", "BASE_URL");

	}
@Test(description = "test get booking ids using given API",groups = {"smoke", "e2e","sanity"})
	public void test_Get_Booking_IDs_API() {
		given()
				.header(new Header("Accept", "application/json"))
		.when()
				.get("4523")
		.then().statusCode(200);
		
		
				
	}
}
