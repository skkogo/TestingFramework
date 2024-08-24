package com.pojo_3;

import com.util.TestUtil;

public class Runner {

	public static void main(String[] args) {
		CreateTokenPOJO createToken = new CreateTokenPOJO("admin", "password123");

		String creatToken = TestUtil.convertPOJOtoJSON(createToken);
		System.out.println(creatToken);
	}

}
