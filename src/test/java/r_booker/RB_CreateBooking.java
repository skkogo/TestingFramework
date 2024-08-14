package r_booker;

import static io.restassured.RestAssured.*;

import com.pojo_3.CreateBooking;

import static com.util.TestUtil.*;

import io.restassured.http.Header;

public class RB_CreateBooking {
	public static void main(String[] args) {
	
		baseURI="https://restful-booker.herokuapp.com";
		given()
		.header(new Header("Content-Type", "application/json"))
		.body(convertPOJOtoJSON(new CreateBooking))
		
		
	}
	

}
