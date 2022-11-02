package test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
	
	WebDriver driver;
	
	@BeforeAll
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.vatanbilgisayar.com/");
		driver.manage().window().maximize();
				
	}
	
	
	@AfterAll
	public void tearDown() {
		//driver.quit();
	}

}
