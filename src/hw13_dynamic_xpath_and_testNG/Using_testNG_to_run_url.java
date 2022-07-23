package hw13_dynamic_xpath_and_testNG;

import java.security.PublicKey;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Using_testNG_to_run_url {
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
		
		@Test
		public void urlTest() throws InterruptedException {
			driver.get("https://www.pfizer.com");
			Thread.sleep(5000);			
		}
		@AfterTest
		public void tearUp() {
			driver.quit();
		}
	
	}


