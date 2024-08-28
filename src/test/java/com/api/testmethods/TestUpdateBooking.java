package com.api.testmethods;

import static  io.restassured.RestAssured.*;

import java.io.IOException;
import java.sql.Time;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.http.Header;
import static com.util.TestUtil.*;

public class TestUpdateBooking {
	@BeforeMethod(description = "setting up the base URL using properties file")
	public void setuup () throws IOException {
		baseURI=getqaProperties("qa.properties", "BASE_URL");	
	}

	@Test(description = "testing the update booking api with the given test Method", groups = {"e2e", "sanity","smoke"})
public void Test_Update_Booking() {
		given()
		.when()
				.log().all()
				.header(new Header("Content-Type", "application/json"))
				.header(new Header("Accept", "application/json"))
				.header(new Header("Cookie", "token="+getTokenforBooking()))
				.body(convertPOJOtoJSON(getFakeCreateBooking()))
				.put("booking/"+getBookingid())
				
		.then()
				
				.statusCode(200)
				.time(Matchers.lessThan(4000L))
				.extract().jsonPath().get("firstname"+"lastname");
			
				
		
	}
	

}
