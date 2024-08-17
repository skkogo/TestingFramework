package com.api.tests;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.Header;

import static com.util.TestUtil.*;

public class TestCreateBooking {
	
	@BeforeMethod(description ="setting up BASE URL for API using propertis file" )
	public void setup() throws IOException {
		baseURI= getqaProperties("qa.properties", "BASE_URL");
	}
	
	@Test(description = "verifying that booking has been created using this API", groups = {"smoke", "e2e","sanity"})
public void Test_Create_Booking_API() {
		given()
				.header(new Header("Content-Type", "application/json"))
				.header(new Header("Accept", "application/json"))
				.body(convertPOJOtoJSON( getFakeCreateBooking()))
		.when()
				.log().all()
				.post("booking")		
		.then()
				.log().all()
				.statusCode(200)
				.body(Matchers.containsString("bookingid"))
				.time(Matchers.lessThan(3000L));
			
				
	}
}
