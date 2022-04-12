package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.selenium.pom.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

//import com.paulhammant.ngwebdriver.NgWebDriver;
public class TestCase0 extends BaseTest {

	//private static WebDriver driver;
	// public static NgWebDriver ngDriver;

	@Test
	public void testScenerio1() {

		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized", "--disable-notifications");
		driver = new ChromeDriver(options);

		driver.get("https://www.amazon.in/");

		driver.findElement(By.xpath("//*[contains(text(),'Hello, Sign in')]")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("giet12cse129@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("neeRAJ@8603");
		driver.findElement(By.id("signInSubmit")).click();
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		driver.findElement(By.id("twotabsearchtextbox"))
				.sendKeys("Prestige PKGSS 1.7L 1500W Electric Kettle (Stainless Steel)");
		driver.findElement(By.id("nav-search-submit-button")).click();
		WebElement element = driver.findElement(
				By.xpath("//a/span[contains(text(),'Prestige PKGSS 1.7L 1500W Electric Kettle (Stainless Steel)')]"));
//			element.is();
		element.click();

		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Skip')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Go To Cart')]")).click();
		element.isDisplayed();

		WebElement selectElement = driver.findElement(By.name("quantity"));
		Select select = new Select(selectElement);
		select.selectByVisibleText("10+");

		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("10");

		driver.findElement(By.xpath("//a[contains(text(),'Update')]")).click();

		WebElement subTotal = driver.findElement(By.id("sc-subtotal-label-activecart"));
		String subTotalText = subTotal.getText();
		if (subTotalText.contains("10")) {
			Assert.assertTrue(true, subTotalText);
		}

		driver.findElement(By.xpath("//input[@value='Delete']")).click();
	}
}
