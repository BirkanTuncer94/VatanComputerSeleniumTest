package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import page.HomePage;
import page.NavBar;
import page.ProductDetailPage;
import page.ProductsPage;

@TestMethodOrder(MethodOrderer.MethodName.class)

public class Tests extends BaseTest{
	
	
	
	HomePage homePage;
	ProductsPage productsPage;
	ProductDetailPage productDetailPage;
	NavBar navBar;
	
	
		@Test
		public void A_test_open_homepage_and_control() throws InterruptedException { // CASE 1
			homePage = new HomePage(driver);
			Assertions.assertEquals(homePage.isOnHomePage(),driver.getCurrentUrl());
		}
		
		@Test
		public void B_test_search_product_and_control() throws InterruptedException { // CASE 2 3 4
			productsPage = new ProductsPage(driver);
			navBar = new NavBar(driver);
			navBar.login("birkantuncertest@gmail.com", "12345.abcde");			
			homePage.searchBox().search("samsung");			
			Assertions.assertTrue(productsPage.isNotEmpty(),"There is no product"); // if size of the products on the page greater then 0, then test passes.
		}
		
		@Test		
		public void C_test_select_second_page_and_control() throws InterruptedException { // CASE 5
			productsPage = new ProductsPage(driver);			
			productsPage.goToSecondPage();			
			Assertions.assertTrue(productsPage.isOnSecondProductPage(driver.getCurrentUrl()),"Not in the second page!");
		}
		
		@Test
		public void D_test_select_product_for_favorites() throws InterruptedException { // CASE 6 7 8
			productDetailPage = new ProductDetailPage(driver);
			productsPage.selectProduct(2);			
			Assertions.assertTrue(productDetailPage.checkTheItemInFavorites(productDetailPage.addToFavorites()),"Item not in favorites"); // 
		}
		
		@Test
		public void E_test_product_not_in_favorites() throws InterruptedException { // CASE 9 10
			productDetailPage.deleteFromFavorites();
			Assertions.assertTrue(productDetailPage.deleteFromFavoritesControl(),"Not deleted");
		}

	
	
}
