package com.salesforce.homepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.salesforce.cucumber.base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[@id='userNavLabel']") WebElement usermenu;
	@FindBy(xpath = "//a[contains(text(),'Logout')]") WebElement logout;

	public String getTitleOfpage() {
		String title = getTitle();
		System.out.println("The page title is : " +title);
		return title;
	}
	
	public void clickUserMenu() {
		clickElement(usermenu);
	}

	public void logout() {
		clickElement(logout);
	}

}