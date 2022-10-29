package hw16_selenium_methods;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HW16_more_selenium_methods {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Test(enabled = true, priority = 1)
	public void sendKeysTest1() throws InterruptedException {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.target.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("taha@gmail.com");
		Thread.sleep(3000);
	}

	@Test(enabled = true, priority = 2)
	public void clearTest() throws InterruptedException {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.target.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@name='username']")).clear();
		Thread.sleep(3000);
	}

	@Test(enabled = false, priority = 3)
	public void sendKeysTest2() throws InterruptedException {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.target.com");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("taha@gmail.com", Keys.ENTER);
		Thread.sleep(3000);
	}

	@Test(enabled = true, priority = 4)
	public void navigationTest() throws InterruptedException {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.target.com");
		Thread.sleep(3000);
		driver.navigate().to("https://amazon.com");
		Thread.sleep(3000);
		driver.navigate().back(); // target
		Thread.sleep(3000);
		driver.navigate().forward(); // amazon
		Thread.sleep(3000);
		driver.navigate().refresh(); // refresh amazon
		Thread.sleep(3000);
	}

	@Test(enabled = false, priority = 5)
	public void fullscreenWindowTest() throws InterruptedException {
		driver.manage().window().fullscreen();
		driver.get("https://www.amazon.com/");
		Thread.sleep(3000);
	}

	@Test(enabled = false, priority = 6)
	public void deleteAllCookiesTest() throws InterruptedException {
		driver.get("https://www.bestbuy.com/");
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
	}

	@Test(enabled = false, priority = 7)
	public void setSizeTest() throws InterruptedException {
		Dimension dimension = new Dimension(800, 500);
		driver.manage().window().setSize(dimension);
		driver.manage().deleteAllCookies();
		driver.get("https://www.bestbuy.com/");
		Thread.sleep(3000);
		System.out.println("The size of the screen is: " + driver.manage().window().getSize());
	}

	@Test(enabled = false, priority = 8)
	public void getSizeTest() throws InterruptedException {
		driver.manage().window().fullscreen();
		driver.get("https://www.bestbuy.com/");
		Thread.sleep(3000);
		System.out.println("The size of the screen is: " + driver.manage().window().getSize());
	}

	@Test(enabled = false, priority = 9)
	public void dropdownSelectByIndexTest() throws InterruptedException {
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com/");
		WebElement dropdownElement = driver.findElement(By.xpath("//select[contains(@class, 'nav-search-dropdown')]"));
		Select select = new Select(dropdownElement);
		select.selectByIndex(5);
		Thread.sleep(3000);
	}

	@Test(enabled = false, priority = 10)
	public void dropdownSelectByValue() throws InterruptedException {
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com/");
		WebElement dropdownElement = driver.findElement(By.xpath("//select[contains(@class, 'nav-search-dropdown')]"));
		Select select = new Select(dropdownElement);
		select.selectByValue("search-alias=alexa-skills");
		Thread.sleep(3000);
	}

	@Test(enabled = false, priority = 11)
	public void dropdownSelectByVisibleText() throws InterruptedException {
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com/");
		WebElement dropdownElement = driver.findElement(By.xpath("//select[contains(@class, 'nav-search-dropdown')]"));
		Select select = new Select(dropdownElement);
		select.selectByVisibleText("Amazon Fresh");
		Thread.sleep(3000);
	}

	@Test(enabled = false, priority = 12)
	public void manageMethodTest() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.target.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // pageLoadTimeout()
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // implictlyWait()
	}

	@Test(enabled = true, priority = 13)
	public void mouseHoverActionTest() throws InterruptedException {
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get("https://www.mountsinai.org/");
		Actions actions = new Actions(driver);
		WebElement ourLocationsElement = driver.findElement(By.xpath("//a[normalize-space(text())='Our Locations' and contains(@class, 'hidden')]"));
		Thread.sleep(3000);
		actions.moveToElement(ourLocationsElement).build().perform();
		Thread.sleep(3000);
		System.out.println("\nThe text of this web element is: " + ourLocationsElement.getText());
	}

	@Test(enabled = true, priority = 14)
	public void acceptingWebBasedAlertTest() throws InterruptedException {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://enthrallit.com/selenium/");
		driver.findElement(By.xpath("//button[normalize-space(text())='Click for JS Confirm']")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert(); // Alert interface is instantiated by driver.switchTo().alert()
		Thread.sleep(3000);
		System.out.println("\nThe text of this alert is: " + alert.getText()); // just to see what the alert says
		alert.accept();
	}

	@Test(enabled = true, priority = 15)
	public void cancelingWebBasedAlertTest() throws InterruptedException {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://enthrallit.com/selenium/");
		driver.findElement(By.xpath("//button[normalize-space(text())='Click for JS Confirm']")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert(); // Alert interface is instantiated by driver.switchTo().alert()
		Thread.sleep(3000);
		System.out.println("\nThe text of this alert is: " + alert.getText()); // just to see what the alert says
		alert.dismiss();
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
