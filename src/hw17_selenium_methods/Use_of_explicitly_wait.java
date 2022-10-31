package hw17_selenium_methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Use_of_explicitly_wait {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecodriver", "./driver/geckodriver.exe");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https;//www.target.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@Test(enabled = true, priority = 1)
	public void searchHomeDecorTest01() throws InterruptedException {
		driver.findElement(By.cssSelector("input#search")).sendKeys("Home decor", Keys.ENTER);
		Thread.sleep(3000);
		WebElement searchButton = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'styles__SearchButton')]")));
		searchButton.click();
		Thread.sleep(3000);

	}

	@Test(enabled = true, priority = 2)
	public void searchHomeDecorTest02() throws InterruptedException {
		driver.findElement(By.cssSelector("input#search")).sendKeys("Home decor", Keys.ENTER);
		Thread.sleep(3000);
		WebElement searchButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[contains(@class, 'styles__SearchButton')]")));
		searchButton.click();
		Thread.sleep(3000);
	}

	@Test(enabled = true, priority = 3)
	public void searchHomeDecorTest03() throws InterruptedException {
		driver.findElement(By.cssSelector("input#search")).sendKeys("Home decor", Keys.RETURN);
		Thread.sleep(3000);
		WebElement searchButton = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[contains(@class, 'styles__SearchButton')]")));
		searchButton.click();
		Thread.sleep(3000);
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
