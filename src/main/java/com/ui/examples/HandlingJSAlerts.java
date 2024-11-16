package com.ui.examples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingJSAlerts {
	public static void main(String[] args) {
		WebDriver wd= new ChromeDriver();
		wd.manage().window().fullscreen();
		wd.get("http://139.59.91.96:5001/selenium-workbook/popups.html");
		By alertButtonLocator=By.id("alert");
		WebElement alertButtonElement =wd.findElement(alertButtonLocator);
		alertButtonElement.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert myalert= wd.switchTo().alert();
		String data=myalert.getText();
		System.out.println(data);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myalert.accept();
		
	}

}
