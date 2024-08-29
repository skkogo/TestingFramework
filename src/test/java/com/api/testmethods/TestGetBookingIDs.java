package com.api.testmethods;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.util.TestUtil;

import io.restassured.http.Header;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public final class TestGetBookingIDs extends TestBaseSetup {
	
@Test(description = "testing the get booking API",groups = {"e2e", "sanity","smoke"})
public void Get_Booking_API() {
	given()
	.when()
			.log().all()
			.header(new Header("Accept", "application/json"))
			.get("booking/" +TestUtil.getBookingid())
	.then()
			.log().all()
			.statusCode(200)
			.time(lessThan(4000L));
			
}
	
}
