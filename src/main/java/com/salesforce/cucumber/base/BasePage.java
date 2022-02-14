package com.salesforce.cucumber.base;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected static Actions action;
	
	public BasePage(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
	}
	
	public static void closeDriver() {
		driver.close();
	}
	
	public static void closeAllDriver() {
		driver.quit();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public static void enterText(WebElement element,String text) {
		waitUntilVisible(element);
		if(element.isDisplayed()) {
			element.clear();
			element.sendKeys(text);
			System.out.println("Text entered");
		}
		else {
			System.out.println("Element not Displayed= " +element);
		}
	}
	
	public String getText(WebElement element) {
		try {
			waitUntilVisible(element);
			return element.getText();
		} catch (Exception ex) {
			System.out.println("waiting for element= " +element);
			return null;
		}
	}
	
	public Select getDropDown(WebElement element) {
		Select select = new Select(element);
		return select;
	}

	public static void clickElement(WebElement element) {
		waitUntilVisible(element);
		if(element.isDisplayed()) {
			element.click();
			System.out.println("Text entered");
		}
		else {
			System.out.println("click not possible= " +element);
		}
	}
	
	public static void waitUntilVisible(WebElement element) {
		wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOf(element));
		System.out.println("waiting for element= " +element);

	}
	
	public static void waitUntilAlertIsPresent() {
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void mouseOver(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public static void mouseOver1(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click(element).build().perform();
	}
	
	public static void droppable(WebElement source, WebElement target, WebElement target1) {
		Actions action = new Actions(driver);
		action.clickAndHold(source).moveToElement(target).release(target1).build().perform();
	
	}
	
	public static String AcceptAlert() {
		//waitUntilAlertIsPresent();		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("alert text="+alert.getText());
		alert.accept();	
		return text;
	}
	
	public static void selectByTextData(WebElement element,String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public static void selectByIndexData(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public static void selectByValueData(WebElement element,String text) {
		Select select = new Select(element);
		select.selectByValue(text);
	}
	
	public void switchToFrameByName(WebElement element) {
		waitUntilVisible(element);
		driver.switchTo().frame(element);
	}
	
	public void switchBackToDefault() {
		driver.switchTo().defaultContent();
	}
	
	public boolean waitUntilTitleContains(String title) {
		try {
			return wait.until(ExpectedConditions.titleContains(title));
		} catch(Exception e) {
			System.out.println("waiting for page to load= " + title);
			return false;
		}
	}
	
	public boolean checkOptionPresentSelect(WebElement element,String text) {
		Select option = new Select(element);
		List<WebElement> options = option.getOptions();
		boolean flag = false;
		for(WebElement ele : options) {
			if(ele.getText().equalsIgnoreCase(text)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public String switchWindow() {
		String currentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for(String window : windows) {
			if(!window.equals(currentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		return currentWindow;
	}
}	