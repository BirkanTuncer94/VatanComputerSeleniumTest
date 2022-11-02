package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage {
	
	By searchBoxLocator = By.cssSelector("div.search__form input");
	By submitButton = By.cssSelector("button.search__button");
	
public SearchBox(WebDriver driver) {
		super(driver);
		
	}

public void search(String text) { // STEP 3
	type(searchBoxLocator, text);
	click(submitButton);
}

	
}
