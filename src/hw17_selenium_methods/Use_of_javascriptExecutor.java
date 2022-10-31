package hw17_selenium_methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Use_of_javascriptExecutor {
	WebDriver driver;
	JavascriptExecutor jsEx;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		driver = new FirefoxDriver();
		jsEx = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.target.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test(enabled = true, priority = 1)
	public void ClicksignInTest() throws InterruptedException {
		WebElement signInelement01 = driver.findElement(By.xpath("//span[text()='Sign in']"));
		WebElement signInelement02 = driver.findElement(By.xpath("//span[contains(@class,'sc-diphzn-1 fVlQrE') and text()='Sign in']"));
		jsEx.executeScript("arguments[0].click()", signInelement01);
		Thread.sleep(3000);
		jsEx.executeScript("arguments[0].click()", signInelement02);
		Thread.sleep(3000);
	}

	@Test(enabled = true, priority = 2)
	public void sendKeysTest() throws InterruptedException {
		WebElement searchField = driver.findElement(By.cssSelector("input#search"));
		WebElement searchButton = driver.findElement(By.xpath("//button[contains(@class, 'styles__SearchButton')]"));
		jsEx.executeScript("arguments[0], value='Home decor'", searchField);
		Thread.sleep(3000);
		jsEx.executeScript("arguments[0], click()", searchButton);
		Thread.sleep(3000);
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
