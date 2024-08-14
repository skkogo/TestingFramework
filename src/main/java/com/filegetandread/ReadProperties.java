package com.filegetandread;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	public static void main(String[] args) throws IOException {
		File myfile=new File(System.getProperty("user.dir")+"\\config\\qa.properties");
		FileReader fileReader= new FileReader(myfile);
		Properties properties= new Properties();
		properties.load(fileReader);
	String url=	properties.getProperty("BASE_URL");
		System.out.println(url);
	}

}
