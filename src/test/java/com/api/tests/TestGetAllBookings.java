package com.api.tests;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.util.TestUtil;

import io.restassured.http.Header;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class TestGetAllBookings {
@BeforeMethod(description="setting up base URL for the get booking test method ")
public void setup() throws IOException {
	baseURI=TestUtil.getqaProperties("qa.properties", "BASE_URL");
}
	@Test(description = "testing for get booking API", groups = {"e2e","sanity","regression"})
	public void Get_Booking_API() {
		given()
		.when()
				.log().all()
				.get("booking")
				
		.then()
				.log().all()
				.statusCode(200)
				.time(lessThan(4000L));
				
	}
}

