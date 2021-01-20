package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	
	
	public AddToCartPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//button[@color='red' and @type='button']")
	private List<WebElement> btnproductSize;
	
	@FindBy(xpath ="//button[text()='Add to Cart']")
	private WebElement btnAddToCart;
	
	
	/**
	 * select product size. s,m,l,xl
	 */
	public void selectProductSize(String size) {
		for (WebElement webElement : btnproductSize) {
			String sizeValue = webElement.getText().trim();
			if(sizeValue.equalsIgnoreCase(size)) {
				webElement.click();
				break;
			}
		}
	}
	
	/**
	 * click on Add to cart button
	 */
	public void clickAddToCart() {
		btnAddToCart.click();
	}
	
}
