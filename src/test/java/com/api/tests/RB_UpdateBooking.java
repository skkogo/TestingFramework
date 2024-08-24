package com.api.tests;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import com.util.TestUtil;

import io.restassured.http.Header;
import io.restassured.response.Response;

import static com.util.TestUtil.*;

public class RB_UpdateBooking {
public static void main(String[] args) throws IOException {
	baseURI=getqaProperties("qa.properties", "BASE_URL");
Response response=	given()
	.header(new Header("Content-Type", "application/json"))
	.header(new Header("Accept", "application/json"))
	.header(new Header("Cookie", "token=8f2244913a0324e"))
	.body(getFakeCreateBooking())
	.put("booking/964");

System.out.println(response.asPrettyString());
}
}
