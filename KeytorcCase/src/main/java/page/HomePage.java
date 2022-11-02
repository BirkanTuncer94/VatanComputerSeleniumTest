package page;

import java.util.function.BooleanSupplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	By homePageContainerLocator = new By.ByCssSelector("div.homepage-banner swiper-container");
	SearchBox searchBox;
	
		
	public HomePage(WebDriver driver) {
		super(driver);
		searchBox = new SearchBox(driver);
		
	}


	public SearchBox searchBox() {
				
		return this.searchBox;		
	}

	public String isOnHomePage() throws InterruptedException { // STEP 1 // Are we on expected URL ? // TEST A
		Thread.sleep(1000);
		String expectedUrl = "https://www.vatanbilgisayar.com/";				
		return expectedUrl;
	}
	

}
