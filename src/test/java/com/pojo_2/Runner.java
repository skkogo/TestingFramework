package com.pojo_2;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.google.gson.Gson;
import com.util.TestUtil;

public class Runner {
	public static void main(String[] args) {
		CreateJobPOJO createJobPOJO = TestUtil.getFakeCreateJOb();

		String createJOBJSON = TestUtil.convertPOJOtoJSON(createJobPOJO);
		System.out.println(createJOBJSON);
	}

}
