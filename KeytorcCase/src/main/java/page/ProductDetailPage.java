package page;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import page.NavBar;
public class ProductDetailPage extends BasePage{

	By addFavoriteSymbolLocator = By.id("fav_Icon");
	By closeFavPopUpLocator = By.cssSelector("button.fancybox-close-small");
	By nameOfTheProductLocator = By.cssSelector("h1.product-list__product-name");
	By infoOfTheProductInFavoritesLocator = By.cssSelector("div.basket-cart__table-row div.info");
	By removableItemsLocator = By.cssSelector("i.icon-times-circle");
	
	NavBar navBar;
	
	
	public ProductDetailPage(WebDriver driver) {
		super(driver);
		navBar = new NavBar(driver);
		
	}

	
	
	public String addToFavorites() throws InterruptedException { // STEP 6-7 // after add process, pop up shows up and it should be closed.
		
		String nameOfTheProduct = find(nameOfTheProductLocator).getText();
		click(addFavoriteSymbolLocator);
		exitPopUpAfterAddFavorites(); // closing the pop up 
		navBar.goToMyAccount();
		navBar.goToMyFavorites();
		
		return nameOfTheProduct;
		
		
	}
	
	public boolean checkTheItemInFavorites(String name) { // STEP 8 --> is the item in there? Checking with name // TEST D
		
		for(int i = 0; i<getAllProducts().size(); i++) { 
			
			if(getAllProducts().get(i).getText().contains(name)) { // Checking the item from the name of the product
				return true;
			}						
		}
						
		return false;
	}
		
	
	public void exitPopUpAfterAddFavorites() throws InterruptedException {
		
		Thread.sleep(1000);
		click(closeFavPopUpLocator);
	}
		

	public void deleteFromFavorites() throws InterruptedException {	 // STEP 9 
		Thread.sleep(300);
		click(removableItemsLocator);		
	}
	
	public boolean deleteFromFavoritesControl() { // STEP 10 --> delete the item in favorites // TEST E
		if(getAllRemovableProducts().size() == 0) {
			return true;
		}
		return false;
	}
	
		
	
	private List<WebElement> getAllProducts(){
		List productList = findAll(infoOfTheProductInFavoritesLocator);		
		return productList;
		
	}

	private List<WebElement> getAllRemovableProducts(){
		List removableItemList = findAll(removableItemsLocator);
		return removableItemList;
		
	}

	
	
	
	
	

}
