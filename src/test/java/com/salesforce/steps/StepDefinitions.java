package com.salesforce.steps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.salesforce.homepages.HomePage;
import com.salesforce.loginpages.ForgotPasswordPage;
import com.salesforce.loginpages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitions {

		 WebDriver driver;
		 WebDriverWait wait;
		 static LoginPage loginPage;
		 static HomePage homePage;
		 static ForgotPasswordPage forgotPwdPage;


		@Before
		public void setUp_1() {			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);					
		}
		
		@Given("User is on Salesforce Login page")
		public void open_salesforce_loginpage() {	
			driver.get("https://login.salesforce.com/");
		
		}	
			
		@When("User is on {string}")
		public void user_Loginpage_or_homepage_or_forgotPwd(String page) {	
			if(page.equalsIgnoreCase("loginpage"))
				loginPage = new LoginPage(driver);
			else if(page.equalsIgnoreCase("homepage"))
				homePage = new HomePage(driver);
			else if(page.equalsIgnoreCase("forgotpwdpage"))
				forgotPwdPage = new ForgotPasswordPage(driver);
		}
		
		@When("User enter username as {string}")
		public void user_enters_data(String username1) {
			loginPage.EnterUserName(username1);
			System.out.println("entered username");
		}

		@When("User enter password as {string}")
		public void user_enters_password(String password) {
			loginPage.EnterPassword(password);
			System.out.println("entered password");

		}
		
		@When("User clicks on Login button")
		public void click_on_login(){
			loginPage.ClickLogin();
			System.out.println("login button clicked");
		}
				
		@Then("Error message must be displayed as {string}")
		public void errorMsg() {
			String acterr = "Please enter your password.";
			Assert.assertEquals(loginPage.errorText(), acterr );		
		}
		
		@Then("verify home page is displayed")
		public void verify_home_page_is_displayed() {
			homePage.getTitleOfpage();			
		}

		@When("User selects the check remember me check box")
		public void user_selects_the_check_remember_me_check_box() {
		   loginPage.checkRememberMe();
		   System.out.println("remember me checkbox is checked");
		}

		@When("User clicks on usermenu drop down button")
		public void user_clicks_on_usermenu_drop_down_button() {
			homePage.clickUserMenu();
			System.out.println("user menu is clicked");
			
		}

		@When("User clicks on logout button")
		public void user_clicks_on_logout_button() {
		    homePage.logout();
		    System.out.println("logged out of homepage");
		}

		@Then("verify username in username text box")
		public void verify_username_in_username_text_box() {
		    loginPage.getUsername();
		    System.out.println("username is displayed in text box");
		}

		@When("User clicks on Forgot Your Password link")
		public void user_clicks_on_forgot_your_password_link() {
			loginPage.clickForgotPassword();
		}

		@When("User enters username as {string}")
		public void user_enters_username_as(String username1) {
			forgotPwdPage.enterUser(username1);
			System.out.println("entered username");
		}

		@When("User clicks on Continue button")
		public void user_clicks_on_continue_button() {
		    forgotPwdPage.clickContinue();
		}

		@Then("Password reset message page is displayed as {string}")
		public void password_reset_message_page_is_displayed_as(String title) {
			forgotPwdPage.titleChk(title);
		}

		@When("User enter wrong username as {string}")
		public void user_enter_wrong_username_as(String string) {
		    loginPage.EnterUserName(string);
		}

		@When("User enter wrong password as {string}")
		public void user_enter_wrong_password_as(String string) {
		    loginPage.EnterPassword(string);
		}

		@Then("Error message is displayed and validate the error message")
		public void error_message_is_displayed_and_validate_the_error_message() {
			loginPage.errorText(); 
		}
		
		
		@After
		public void tearDown() {
			driver.quit();
		}
}		
		
		
		
		