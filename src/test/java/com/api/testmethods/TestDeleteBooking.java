package com.api.testmethods;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.Header;

import  static com.util.TestUtil.*;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class TestDeleteBooking {
	
	@BeforeMethod(description = "setting up the base URL for the Delete Booking API")
	public void setup () throws IOException {
		baseURI= getqaProperties("qa.properties", "BASE_URL");
	}
	
@Test(description = "testing the delete booking API with given test method", groups = {"e2e", "smoke","sanity"})
public void Test_Delete_Booking() {
	given()
	.when()
			.log().all()
			.header(new Header("Cookie", "token="+getTokenforBooking()))
			.delete("booking/"+getBookingid())
	.then()
			.log().all()
			.statusCode(201)
			.time(Matchers.lessThan(4000L));
			
	
	
}

}
