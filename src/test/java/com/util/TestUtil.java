package com.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.pojo_2.CreateJobPOJO;
import com.pojo_2.CustomerAdressPOJO;
import com.pojo_2.CustomerPOJO;
import com.pojo_2.CustomerProductPOJO;
import com.pojo_2.ProblemsPOJO;
import com.pojo_3.Bookingdates;
import com.pojo_3.CreateBooking;

public class TestUtil {
	public static String getqaProperties(String propertiesFileName, String key) throws IOException {
		File myfile = new File(System.getProperty("user.dir") + "\\config\\" + propertiesFileName);
		FileReader fileReader = new FileReader(myfile);
		Properties properties = new Properties();
		properties.load(fileReader);
		String value = properties.getProperty(key);
		return value;
	}

	public static CreateBooking getFakerCreateBooking() {
		Faker faker = new Faker();
		Bookingdates bookingdates = new Bookingdates("18-09-2024", "21-09-2024");
		CreateBooking createBooking = new CreateBooking(faker.name().firstName(), faker.name().lastName(), 10000, true,
				"Breakfast", bookingdates);
		return createBooking;
	}

	public static String getFakeCreateJOb() {
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
		return convertPOJOtoJSON(CreateJob);
	}

	public static String convertPOJOtoJSON(Object data) {
		Gson gson = new Gson();
		String gData = gson.toJson(data);
		return gData;
	}

}
