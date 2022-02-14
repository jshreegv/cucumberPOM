package com.salesforce.loginpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesforce.cucumber.base.BasePage;

public class LoginPage extends BasePage {
			
		public LoginPage(WebDriver driver) {
			super(driver);
		}

		@FindBy(id = "username") WebElement email;
		@FindBy(id = "password") WebElement password;
		@FindBy(xpath = "//input[@id='Login']") WebElement login;
		@FindBy(id = "rememberUn") WebElement checkrememberme;
		@FindBy(id = "forgot_password_link") WebElement forgotpwd;
		@FindBy(xpath = "//img[@id='logo']") WebElement logo;
		@FindBy(id = "error") WebElement error;
		@FindBy(id = "idcard-identity") WebElement identity;

		
		public void EnterUserName(String emailId) {
	        enterText(email, emailId);
		}
		
		public void EnterPassword(String pass) {
	        enterText(password, pass);
		}
		
		public void ClickLogin() {
			clickElement(login);
		}

		public void checkRememberMe() {
			clickElement(checkrememberme);
		}

		public void clickForgotPassword() {
			clickElement(forgotpwd);
		}
		
		public String getLoginTitle() {
	        return logo.getText();
	    }
		
		public String errorText() {
			return error.getText();
		}
		
		public String getUsername() {
			return identity.getText();
		}
		
}
