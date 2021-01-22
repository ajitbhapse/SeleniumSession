package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BasePage;

public class ProductSearchPage extends BasePage{
	
	WebDriver driver;
	
	public 	ProductSearchPage (WebDriver driver) { 
		 super(driver);
		 PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath ="//input[@placeholder='Search']")
	private WebElement textSearchProducts;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement btnSearch;
	
	@FindBy(xpath="//a[text()='MacBook Pro']//ancestor::div[@class='caption']//following-sibling::div//child::button[@data-original-title='Add to Wish List']")
	private WebElement btnAddToWishList;
	
	@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']")
	private WebElement msgAlertSuccess;
	
	
	/**
	 * product search
	 */
	
	public void enterProductToBeSearch(String value) {
		sendKeys(textSearchProducts,value);
	}
	
	/**
	 * click on product search button
	 */
	
	public void clickOnProductSearch() {
		click(btnSearch);
	}
	
	/**
	 * add to wish list
	 */
	public void addProductToWishList() {
		click(btnAddToWishList);
	}
	
	/**
	 * get webElement text
	 * @return
	 */
	public String getText() {
		return msgAlertSuccess.getText();
	}
}
