package hw14_testNG;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Use_of_click_method {
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.target.com");
		driver.get("https://www.bestbuy.com/");
		
	}
		
		@Test
		public void clickRegistryById() throws InterruptedException {
			driver.findElement(By.id("utilityNav-registries")).click();
			Thread.sleep(3000);
		}
		@Test
		public void clickHamburgerByClassName() throws InterruptedException {
			driver.findElement(By.className("c-button-unstyled hamburger-menu-button")).click();
			Thread.sleep(3000);			
		}
		@Test
		public void clickPickupAndDeliveryByLinkText() throws InterruptedException {
			driver.findElement(By.linkText("Pickup & Delivery"));
			Thread.sleep(5000);
			
		}
		@Test
		public void clickPickupAndDeliveryByPartialLinkText() throws InterruptedException {
			driver.findElement(By.partialLinkText("Pickup &"));
			Thread.sleep(5000);
			
		}
		@Test
		public void clickSearchByCssSelector() throws InterruptedException {		
		driver.findElement(By.cssSelector("input#search")).click();
			Thread.sleep(5000);			
		}		
		
		@AfterTest
		public void tearUp() {
			driver.quit();
		}
	
	}


