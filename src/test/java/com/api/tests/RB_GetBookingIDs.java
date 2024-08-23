package com.api.tests;

import static io.restassured.RestAssured.*;
import java.io.IOException;
import com.util.TestUtil;
import io.restassured.http.Header;
import io.restassured.response.Response;
import static com.util.TestUtil.*;

public class RB_GetBookingIDs {
	public static void main(String[] args) throws IOException {
		baseURI = getqaProperties("qa.properties", "BASE_URL");
		given()
						.when()
				.get("2698")
		.then()
				.statusCode(200);

	}

}
