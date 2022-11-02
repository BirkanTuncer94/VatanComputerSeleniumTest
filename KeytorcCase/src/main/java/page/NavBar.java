package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavBar extends BasePage {

	SearchBox searchBox;
	
	
	By loginButton = By.id("btnMyAccount");
	By loginSelect = By.cssSelector("a[href*='signin']");
	By emailLocator = By.id("email");
	By passwordLocator = By.id("pass");
	By loginLocator = By.id("login-button");
	By myAccountButtonLocator = By.id("btnMyAccount");
	By myFavorites = By.cssSelector("li a[href*='favorilistem']");
	
	
	public NavBar(WebDriver driver) {
		super(driver);
		searchBox = new SearchBox(driver);
		
	}
	
	public void login(String userNameText, String passwordText) throws InterruptedException { // STEP 2 
		
		click(loginButton);
		Thread.sleep(500);
		click(loginSelect);
		Thread.sleep(500);
		type(emailLocator,userNameText);
		type(passwordLocator,passwordText);
		Thread.sleep(750);
		click(loginLocator);
		Thread.sleep(500);
		
	}

	public void goToMyAccount() throws InterruptedException {
		Thread.sleep(250);
		click(myAccountButtonLocator);
		
	}

	public void goToMyFavorites() throws InterruptedException {
		Thread.sleep(250);
		click(myFavorites);
		
	}
	
	
	
	
	
	
	
	

}
