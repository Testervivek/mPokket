package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	@BeforeTest
	public void load(String endPoint) {
		driver.get("https://amazon.in");
	}

}
