package com.api.tests;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import static com.util.TestUtil.*;

import io.restassured.http.Header;
import io.restassured.response.Response;

public class CreateJOB {
	public static void main(String[] args) {
		baseURI="http://139.59.91.96:9000/v1";
Response response=		given()
				.header(new Header("Content-Type", "application/json"))
				.header(new Header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NCwiZmlyc3RfbmFtZSI6ImZkIiwibGFzdF9uYW1lIjoiZmQiLCJsb2dpbl9pZCI6ImlhbWZkIiwibW9iaWxlX251bWJlciI6Ijg4OTk3NzY2NTUiLCJlbWFpbF9pZCI6Im1hcmtAZ21haWwuY29tIiwicGFzc3dvcmQiOiI1ZjRkY2MzYjVhYTc2NWQ2MWQ4MzI3ZGViODgyY2Y5OSIsInJlc2V0X3Bhc3N3b3JkX2RhdGUiOm51bGwsImxvY2tfc3RhdHVzIjowLCJpc19hY3RpdmUiOjEsIm1zdF9yb2xlX2lkIjo1LCJtc3Rfc2VydmljZV9sb2NhdGlvbl9pZCI6MSwiY3JlYXRlZF9hdCI6IjIwMjEtMTEtMDNUMDg6MDY6MjMuMDAwWiIsIm1vZGlmaWVkX2F0IjoiMjAyMS0xMS0wM1QwODowNjoyMy4wMDBaIiwicm9sZV9uYW1lIjoiRnJvbnREZXNrIiwic2VydmljZV9sb2NhdGlvbiI6IlNlcnZpY2UgQ2VudGVyIEEiLCJpYXQiOjE3MjU0NzY4Nzd9.NcHTH7uSg4MVkJ01FIqvir3bix9I_2p7fA2ILp5Q0HI"))
				.body(convertPOJOtoJSON(getFakeCreateJOb()))
				.log().all()
				.post("/job/create");

System.out.println(response.asPrettyString());

}}

