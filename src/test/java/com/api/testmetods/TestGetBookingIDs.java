package com.api.testmetods;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.util.TestUtil;

import io.restassured.http.Header;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class TestGetBookingIDs {
	@BeforeMethod(description = "setting up the base URL for get Booking using properties file")
	public void setup () throws IOException {
		baseURI=TestUtil.getqaProperties("qa.properties", "BASE_URL");
	}
@Test(description = "testing the get booking API",groups = {"e2e", "sanity","smoke"})
public void Get_API_Booking() {
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
