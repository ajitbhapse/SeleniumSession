package com.crm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSearchPage {
	
	
	ProductSearchPage (WebDriver driver){
		PageFactory.initElements(driver, ProductSearchPage.class);
	}
	
	
	@FindBy(xpath ="//input[@placeholder='Search Products']")
	private WebElement textSearchProducts;
	
	
	/**
	 * Enter value in search product text box
	 * @param text
	 */
	public void enterSearchProducts(String text) {
		textSearchProducts.click();
		textSearchProducts.clear();
		textSearchProducts.sendKeys(text);
	}
	/**
	 * perform click on keyboard Enter key
	 */
	public void pressEnterButton() {
		textSearchProducts.sendKeys(Keys.ENTER);		
	}
	
	

}
