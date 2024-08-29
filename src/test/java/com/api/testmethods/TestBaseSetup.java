package com.api.testmethods;

import static com.util.TestUtil.getqaProperties;
import static io.restassured.RestAssured.baseURI;

import java.io.IOException;

import org.testng.annotations.BeforeClass;

public abstract class TestBaseSetup {
	@BeforeClass(description ="setting up BASE URL for API using propertis file" )
	public void setup() throws IOException {
		baseURI= getqaProperties("qa.properties", "BASE_URL");
	}

}
