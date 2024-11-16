package com.ui.examples;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BrowserUtil {
	private WebDriver wd;
	private WebDriverWait wait;
	
	public BrowserUtil(WebDriver wd, WebDriverWait wait) {
		super();
		this.wd = wd;
		wait = new WebDriverWait(wd, Duration.ofSeconds(30));
	}
	
	public void acceptAlert() {
		Alert myAlert= wd.switchTo().alert();
		myAlert.accept();
	}
	
	public void dismissAlert() {
		Alert myAlert= wd.switchTo().alert();
		myAlert.dismiss();
	}

	public void getAlerttext() {
		Alert myAlert= wd.switchTo().alert();
		myAlert.getText();
	}
}
