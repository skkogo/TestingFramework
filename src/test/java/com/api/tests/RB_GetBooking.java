package com.api.tests;

import static io.restassured.RestAssured.*;

import io.restassured.http.Header;
import io.restassured.response.Response;

import static com.util.TestUtil.*;

public class RB_GetBooking {
     public static void main(String[] args) {
		baseURI="https://restful-booker.herokuapp.com";
		Response response=given()
					 .header(new Header("Accept", "application/json"))
					 .get("id");
		System.out.println(response);
				
	}

	}

}
