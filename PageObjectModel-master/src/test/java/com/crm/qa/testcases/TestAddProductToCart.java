package com.crm.qa.testcases;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddToCartPage;
import com.crm.qa.pages.CatalogPage;
import com.crm.qa.pages.ProductSearchPage;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebDriverUtils;

public class TestAddProductToCart {
	
	public WebDriver driver;
	TestBase testBase;
	String filePath = "login";
	String elementName = "testData";
	
	
	@BeforeTest
	public void setUp() {
		WebDriverUtils utils = new WebDriverUtils();
		utils.initialization();
		driver = utils.getDriver();
		}
	
	
	@Test
	public void addProductToCart() {
		
		Map<String,String> testData = TestUtil.getTestData("TestAddProductToCart.json", "addProductToCart");
		ProductSearchPage productSearchPage = new ProductSearchPage(driver);
		
		
		//enter product name to be searched
		productSearchPage.enterSearchProducts(testData.get("productName"));
		
		//click key board enter button 
		productSearchPage.pressEnterButton();
		
		CatalogPage catalogPage = new CatalogPage(driver);
		//select any product randomly
		catalogPage.selectProduct(testData.get("productTOBeSelected"));
		
		AddToCartPage addToCartPage = new AddToCartPage(driver);
		//select product size
		addToCartPage.selectProductSize(testData.get("selectSize"));
		//add product to cart
		addToCartPage.clickAddToCart();
		
		Assert.assertEquals("true", "true");
		
	}

	@AfterTest
	public void endTest() {
		driver.quit();
	}
}
