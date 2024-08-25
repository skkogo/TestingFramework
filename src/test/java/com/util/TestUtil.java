package com.util;

import static com.util.TestUtil.convertPOJOtoJSON;
import static com.util.TestUtil.getFakeCreateBooking;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.hamcrest.Matchers;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.pojo_2.CreateJobPOJO;
import com.pojo_2.CustomerAdressPOJO;
import com.pojo_2.CustomerPOJO;
import com.pojo_2.CustomerProductPOJO;
import com.pojo_2.ProblemsPOJO;
import com.pojo_3.BookingdatesPOJO;
import com.pojo_3.CreateBookingPOJO;
import com.pojo_3.CreateTokenPOJO;
import com.pojo_3.PartialBookingPOJO;

import io.restassured.http.Header;

public class TestUtil {
	
	
	
	
	
	//get booking id
	public static Number getBookingid() {
		CreateBookingPOJO createBookingPOJO= null;
		Number booking=		given()
		.header(new Header("Content-Type", "application/json"))
		.header(new Header("Accept", "application/json"))
		.body(convertPOJOtoJSON( getFakeCreateBooking()))
.when()
		.log().all()
		.post("booking")		
.then()
		
		.extract().jsonPath().getInt("bookingid") ;
		return booking;
	}
	
	
	
	
	
	
	//get token
	public static String getTokenforBooking() {
		CreateTokenPOJO createtoken=null;
String token=   given()
						.header(new Header("Content-Type", "application/json"))
						.body(convertPOJOtoJSON( new CreateTokenPOJO("admin", "password123")))
						.when()
								.log().all()
								.post("auth")
						.then()
							.extract().jsonPath().get("token");	
							
		return token;
				
					
	}
	
	
//POJO to JSON
	public static String convertPOJOtoJSON(Object data) {
		Gson gson = new Gson();
		String gData = gson.toJson(data);
		return gData;
	}
	
	
	
// properties file reader
	public static String getqaProperties(String propertiesFileName, String key) throws IOException {
		File myfile = new File(System.getProperty("user.dir") + "\\config\\" + propertiesFileName);
		FileReader fileReader = new FileReader(myfile);
		Properties properties = new Properties();
		properties.load(fileReader);
		String value = properties.getProperty(key);
		return value;
	}
	
	
	
	//partial  fake booking
	public static PartialBookingPOJO getFakePartialBooking() {
		Faker faker= new Faker();
		PartialBookingPOJO paritialBooking= new PartialBookingPOJO(faker.name().firstName(), faker.name().lastName());
		return paritialBooking;
	}

	//fake Create booking
	public static CreateBookingPOJO getFakeCreateBooking() {
		Faker faker = new Faker();
		BookingdatesPOJO bookingdates = new BookingdatesPOJO("18-10-2024", "21-10-2024");

		CreateBookingPOJO createBooking = new CreateBookingPOJO(faker.name().firstName(), faker.name().lastName(), 10000, true,
				 bookingdates,"Lunch");
		return createBooking;
	}
	
	
	
	
//fake create job 
	public static CreateJobPOJO getFakeCreateJOb() {
		Faker faker = new Faker();
		ProblemsPOJO[] Problem = new ProblemsPOJO[3];
		Problem[0] = new ProblemsPOJO(1, "Overheating");
		Problem[1] = new ProblemsPOJO(2, "Audio jack is not working");
		Problem[2] = new ProblemsPOJO(3, "Screen is damaged");
		CustomerProductPOJO Product = new CustomerProductPOJO(faker.numerify("######"), faker.numerify("######"),
				faker.numerify("##############"), faker.numerify("##############"), faker.numerify("##############"), 5,
				6);
		CustomerAdressPOJO Adress = new CustomerAdressPOJO(faker.address().buildingNumber(),
				faker.address().secondaryAddress(), faker.address().streetAddress(), faker.address().streetAddress(),
				faker.address().city(), faker.numerify("######"), faker.address().country(), faker.address().state());
		CustomerPOJO Customer = new CustomerPOJO(faker.name().firstName(), faker.name().lastName(),
				faker.numerify("##########"), faker.numerify("##########"), faker.internet().emailAddress(),
				faker.internet().emailAddress());
		CreateJobPOJO CreateJob = new CreateJobPOJO(65, 655, 556, 3455, Customer, Adress, Product, Problem);
		return CreateJob;
	}

}
