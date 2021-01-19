package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPage {
	
	
	CatalogPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//p[contains(@class,'text-xs truncate')]")
	private List<WebElement> productNames;

	
	/**
	 * select product name
	 * @param productName
	 */
	public void selectProduct(String productName) {
		for (WebElement webElement : productNames) {
			String prdName = webElement.getText();
			if(prdName.equalsIgnoreCase(productName)) {
				webElement.click();
			}
		}
	}
}
