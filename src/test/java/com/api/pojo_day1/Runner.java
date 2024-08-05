package com.api.pojo_day1;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.google.gson.Gson;

public class Runner {

	public static void main(String[] args) {
		LoginPOJO loginpojo = new LoginPOJO("albert09", "albertA80@");

		System.out.println(convertPOJOtoJSON(loginpojo));
	}

	public static String convertPOJOtoJSON(Object data) {

		Gson gson = new Gson();
		String gData = gson.toJson(data);
		return gData;
	}
	
	
}
