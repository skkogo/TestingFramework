package com.api.testmetods;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import static org.hamcrest.Matchers.*;
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
				.body(containsString("bookingid"))
				.time(lessThan(4000L))
				.body("bookingid", notNullValue())
				.body("booking.firstname", notNullValue())
				.body("booking.lastname", notNullValue())
				.body("booking.totalprice", notNullValue())
				.body("booking.depositpaid", equalTo(true))
				.body("booking.bookingdates.checkin", notNullValue())
				.body("booking.bookingdates.checkout", notNullValue())
				.extract().jsonPath().getInt("bookingid") ;
			
				
	}
}
