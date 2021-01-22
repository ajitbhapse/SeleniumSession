package com.crm.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
	}

	
	/**
	 * Wait till element is clickable.
	 * @param elem
	 */
	public void waitTillElementIsClickable(WebElement elem) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(elem));
	}
	
	
	/**
	 * wait till element is visible
	 */
	
	public void waitTillElementIsVisible(WebElement elem) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(elem));
	}
	
	/**
	 * click on webElement
	 */
	
	public void click(WebElement elem) {
		waitTillElementIsVisible(elem);
		waitTillElementIsClickable(elem);
		elem.click();
	}
	
	
	/**
	 * enter text in textbox
	 */
	
	public void sendKeys(WebElement elem,String value) {
		waitTillElementIsVisible(elem);
		waitTillElementIsClickable(elem);
		elem.clear();
		elem.sendKeys(value);
	}
}
