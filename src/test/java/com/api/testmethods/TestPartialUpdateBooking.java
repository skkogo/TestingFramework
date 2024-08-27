package com.api.testmethods;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.util.TestUtil;

import io.restassured.http.Header;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class TestPartialUpdateBooking {
	@BeforeMethod(description = "setting up the baseURI for partial update booking with the help of propertis file")
	public void setup () throws IOException {
		baseURI=TestUtil.getqaProperties("qa.properties", "BAE_URL");
	}

	@Test(description = "testing the partial bookin API with given test method", groups = {"e2e", "sanity","smoke"})
	public void Partial_Updat_Booking() {
		given()
		.when()
				.header(new Header("Content-Type", "application/json"))
				.header(new Header("Content-Type", "application/json"))
				
	}
	
	
}
