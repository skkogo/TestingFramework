package com.api.testmethods;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.util.TestUtil.*;

import io.restassured.http.Header;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public final class TestPartialUpdateBooking extends TestBaseSetup {

	@Test(description = "testing the partial bookin API with given test method", groups = {"e2e", "sanity","smoke"})
	public void Partial_Updat_Booking() {
		given()
		.when()
				.log().all()
				.header(new Header("Content-Type", "application/json"))
				.header(new Header("Content-Type", "application/json"))
				.header(new Header("Cookie", "token="+getTokenforBooking()))
				.body(convertPOJOtoJSON(getFakePartialBooking()))
				.patch("booking/"+getBookingid())
		.then()
				.log().all()
				.statusCode(200)
				.time(Matchers.lessThan(4000L))
				.extract().jsonPath().get("firstname"+"lastname");
				
	}
	
	
}
