package com.api.tests;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.hamcrest.Matchers;

import io.restassured.response.Response;

import static org.hamcrest.Matcher.*;

import static com.util.TestUtil.*;

public class RB_GetAllBookings {
public static void main(String[] args) throws IOException {
	baseURI=getqaProperties("qa.properties", "BASE_URL");
Response response=	given()
					.get("booking");
System.out.println(response.asPrettyString());
			
					
}
}
