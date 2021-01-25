package com.crm.qa.testcases;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ProductSearchPage;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebDriverUtils;

public class TestSerachProduct {
	public WebDriver driver;
	String filePath = "login";
	String elementName = "testData";
	
	@BeforeMethod
	public void setUp() {
		WebDriverUtils utils = new WebDriverUtils();
		utils.initialization();
		driver = utils.getDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(WebDriverUtils.prop.getProperty("username"));
		loginPage.enterPassword(WebDriverUtils.prop.getProperty("password"));
		loginPage.clickBtnLogin();
	}
	
	@Test
	public void testAddProductToWishList() {
		Map<String,String> testData = TestUtil.getTestData("TestSerachProduct.json", "testAddProductToWishList");
		
		ProductSearchPage productSearchPage = new ProductSearchPage(driver);
		
		//enter product to search 
		productSearchPage.enterProductToBeSearch(testData.get("productName"));
		
		//click on search button 
		productSearchPage.clickOnProductSearch();
		
		//click on add to wish list button
		productSearchPage.addProductToWishList();
		
		//get message
		String msgSuccess = productSearchPage.getText().replace("×", "");
		
		//verify success message 
		Assert.assertEquals(msgSuccess, testData.get("successMessage"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
