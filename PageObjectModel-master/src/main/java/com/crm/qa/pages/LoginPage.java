package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BasePage;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//input[@placeholder='E-Mail Address']")
	private WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement txtPassword;
	
	@FindBy (xpath ="//input[@value='Login']")
	private WebElement btnLogin;
	
	
	/**
	 * enter email address
	 * @param emailAddress
	 */
	public void enterEmailAddress(String emailAddress) {
		sendKeys(txtEmailAddress, emailAddress);
	}
	
	/**
	 * enter email address
	 * @param emailAddress
	 */
	public void enterPassword(String password) {
		sendKeys(txtPassword, password);
	}
	
	/**
	 * Click on login button
	 */
	public void clickBtnLogin() {
		submit(btnLogin);
	}
}
