package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.BasePage;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath="//input[@placeholder='E-Mail Address']")
	private WebElement txtEmailAddress;
	
	
	/**
	 * enter email address
	 * @param emailAddress
	 */
	public void enterEmailAddress(String emailAddress) {
	sendKeys(txtEmailAddress, emailAddress);
	}
}
