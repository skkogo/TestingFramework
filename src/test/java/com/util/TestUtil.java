package com.util;

import com.google.gson.Gson;

public class TestUtil {

	public static String convertPOJOtoJSON(Object data) {
		Gson gson = new Gson();
		String gData = gson.toJson(data);
		return gData;
	}
	
}
