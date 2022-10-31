package hw17_selenium_methods;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UseOfWebDriverManager {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get("https://www.target.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@Test(enabled = true, priority = 1, threadPoolSize = 3, invocationCount = 10, timeOut = 10000)
	public void titleTest01() {
		String expected = "Target: Expect More. Pay Less";
		String actual = driver.getTitle();
		System.out.println("Home page title is: " + actual);
		Assert.assertEquals(actual, expected, "Home page title doesn't match.");
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL from priority 1 is: " + currentUrl);

	}

	@Test(enabled = true, priority = 2, threadPoolSize = 3, invocationCount = 10, timeOut = 10000)
	public void titleTest02() {
		String expected = "Target: Expect More. Pay Less";
		String actual = driver.getTitle();
		System.out.println("Home page title is: " + actual);
		SoftAssert assert1 = new SoftAssert();
		assert1.assertEquals(actual, expected, "Home page title doesn't match.");
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL from priority 1 is: " + currentUrl);
	}

	@Test(enabled = true, priority = 3)
	public void signIn01() { // this test will fail and show runtime exception: NoSuchElementException
		driver.findElement(By.xpath("//input[@class='signIn'")).click();
	}

	@Test(enabled = true, priority = 4, expectedExceptions = NoSuchElementException.class)
	public void signIn0() {
		driver.findElement(By.xpath("//input[@class='signIn'")).click();
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
