package org.selenium.pom.pages;

import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.selenium.pom.base.BasePage;
import org.testng.Assert;

import java.util.*;
public class AddToCartPage extends BasePage {

	private final By searchFld = By.xpath("//input[@id='twotabsearchtextbox']");
	private final By searchBtn = By.xpath("//input[@id='nav-search-submit-button']");
	private final By quantityFld = By.xpath("//span[@id='a-autoid-0-announce']");
	private final By deletebtn = By.xpath("//input[@value='Delete']");
	private final By productbtn = By
			.xpath("//a/span[contains(text(),'Prestige PKGSS 1.7L 1500W Electric Kettle (Stainless Steel)')]");
	private final By cartBtn = By.xpath("//form[@id='addToCart']//input[@id='add-to-cart-button']");
	private final By skipBtn = By.xpath("//span[contains(text(),'Skip')]");
	private final By goToCartBtn = By.id("nav-cart");
	private final By qtytextFld = By.xpath("");
	private final By updateBtn = By.xpath("");
	
	
	String product = "Prestige PKGSS 1.7L 1500W Electric Kettle (Stainless Steel)";
	String parentwindow;

	public AddToCartPage(WebDriver driver) {
		super(driver);
	}

	public void searchForProduct(String txt) {
		driver.findElement(searchFld).clear();
		driver.findElement(searchFld).sendKeys(txt);
		driver.findElement(searchBtn).click();
		WebElement element = driver.findElement(productbtn);
		element.click();
		parentwindow = driver.getWindowHandle();
	}

	public void clickAddToCartBtn() throws InterruptedException {
		// driver.switchTo().activeElement();
		// Thread.sleep(4000);
		// driver.findElement(cartBtn).click();
		// driver.findElement(By.xpath("//span[contains(text(),'Skip')]")).click();
		// driver.findElement(By.xpath("//a[contains(text(),'Go To Cart')]")).click();

		Set<String> window = driver.getWindowHandles();
		
		//Iterator<String> I1 = window.iterator();
		java.util.Iterator<String> I1= window.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parentwindow.equals(child_window))
				driver.switchTo().window(child_window);
		}

		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement addToCartButton = driver.findElement(cartBtn);
		js.executeScript("arguments[0].click();", addToCartButton);

		WebElement skipButton = driver.findElement(skipBtn);
		js.executeScript("arguments[0].click();", skipButton);

		Thread.sleep(3000);
		driver.findElement(goToCartBtn).click();
		

	}

	public void IncreaseQtyInQuanityFld() throws InterruptedException {

//		WebElement selectElement = driver.findElement(quantityFld);
//		Select select = new Select(selectElement);
//		select.selectByVisibleText("10+");
//
//		driver.findElement(qtytextFld).clear();
//		driver.findElement(qtytextFld).sendKeys("10");
//
//		driver.findElement(updateBtn).click();
		
		WebElement selectElement = driver.findElement(By.name("quantity"));
		Select select = new Select(selectElement);
		select.selectByVisibleText("10+");
		
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement cartValue = driver.findElement(By.xpath("//input[@name='quantityBox']"));
		js.executeScript("arguments[0].value='10';",cartValue);
		driver.findElement(By.xpath("//a[contains(text(),'Update')]")).click();
	}
	public void verifyIteminCart() throws InterruptedException {
		Thread.sleep(3000);
		WebElement subTotal = driver.findElement(By.id("sc-subtotal-label-activecart"));
		String subTotalText = subTotal.getText();
		System.out.println("SubTotal Text --->>> "+subTotalText);
		if(!subTotalText.contains("10")) {
			Assert.assertTrue(false,subTotalText);
		}
		else {
			Assert.assertTrue(true,subTotalText);
			System.out.println("Validated Successfully --->>> "+subTotalText);
		}
		
		Thread.sleep(3000);
	}
	
	public void deletetItmFromCart() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement deleteButton = driver.findElement(deletebtn);
		js.executeScript("arguments[0].click();",deleteButton);
	}

}
