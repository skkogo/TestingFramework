package com.util;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.pojo_2.CreateJobPOJO;
import com.pojo_2.CustomerAdressPOJO;
import com.pojo_2.CustomerPOJO;
import com.pojo_2.CustomerProductPOJO;
import com.pojo_2.ProblemsPOJO;

public class TestUtil {

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

	
	public static String convertPOJOtoJSON(Object data) {
		Gson gson = new Gson();
		String gData = gson.toJson(data);
		return gData;
	}

}
