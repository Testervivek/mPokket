package org.selenium;

import org.selenium.pom.base.BasePage;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 extends BaseTest{
	String product = "Prestige PKGSS 1.7L 1500W Electric Kettle (Stainless Steel)";

	@Test
	public void testScenerio() throws InterruptedException {
		AddToCartPage addtoCartPage = new AddToCartPage(driver);
		addtoCartPage.load(product);
		addtoCartPage.searchForProduct(product);
		addtoCartPage.clickAddToCartBtn();
		addtoCartPage.IncreaseQtyInQuanityFld();
		addtoCartPage.verifyIteminCart();
		addtoCartPage.deletetItmFromCart();
		
}
}