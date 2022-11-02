package page;

import java.util.List;
import java.util.function.BooleanSupplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage{

	By productCodeLocator = new By.ByCssSelector("div.product-list__product-code");	
	By secondPageLocator = By.cssSelector("a.pagination__content span.icon-angle-right");
	By productsLocator = By.cssSelector("div.product-list--list-page div.product-list__image-safe a");
	
	
	
	public ProductsPage(WebDriver driver) {
		super(driver);
		
	}

	public Boolean isOnProductPage() {
		
		
		return false;
	}

	public String selectProduct(int i) { // STEP 6 -> int i = 2 ( Third item ) 
		
		String selectedProduct = getAllProducts().get(i).getText();
		getAllProducts().get(i).click();
		
		return selectedProduct;
	}

	public boolean isNotEmpty() { // STEP 4 // is there any items in the page ? APPROVE TEST B
		if(getAllProducts().size()>0) {
			return true;
		}
		
		return false;
	}

	private List<WebElement> getAllProducts(){
		List productList = findAll(productCodeLocator);
		return productList;
		
	}
	public boolean isOnSecondProductPage(String currentUrl) { // STEP 5 // Are we in the second page ? Controlled with expected URL // TEST C 
		

		if(currentUrl.equals("https://www.vatanbilgisayar.com/arama/samsung/?page=2")) { 
			return true;
		}
		
		
		return false;
	}

	public void goToSecondPage() throws InterruptedException {
		Thread.sleep(2000);
		click(secondPageLocator);
		Thread.sleep(200);
	}
	
	
	
	
	
	
	
}
