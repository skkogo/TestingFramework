package com.api.tests;

import static io.restassured.RestAssured.*;

import com.pojo_3.CreateBookingPOJO;

import static com.util.TestUtil.*;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RB_CreateBooking {
	public static void main(String[] args) {
	
		baseURI="https://restful-booker.herokuapp.com";
Response response=		given()
		.header(new Header("Content-Type", "application/json"))
		.header(new Header("Accept", "application/json"))
		.body(getFakeCreateBooking())
		.log().all()
		.post("booking");

System.out.println(response.asPrettyString());

		
		
	}
	

}
