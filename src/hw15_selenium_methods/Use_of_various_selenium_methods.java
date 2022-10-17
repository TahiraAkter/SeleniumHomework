package hw15_selenium_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Use_of_various_selenium_methods {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		driver = new FirefoxDriver();
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
		Thread.sleep(3000);
	}

	@Test
	public void clickPickupAndDeliveryByPartialLinkText() throws InterruptedException {
		driver.findElement(By.partialLinkText("Pickup &"));
		Thread.sleep(3000);
	}

	@Test
	public void clickSearchByCssSelector() throws InterruptedException {
		driver.findElement(By.cssSelector("input#search")).click();
		Thread.sleep(3000);
	}

	@Test(enabled = true, priority = 1)
	public void isDisplayedTest() throws InterruptedException {
		boolean signInDisplayed = driver.findElement(By.xpath("//span[text()='Sign in']")).isDisplayed();
		System.out.println("Is Sign in displayed? Ans: " + signInDisplayed);
		Thread.sleep(3000);
	}

	@Test(enabled = true, priority = 2)
	public void isEnabledTest() throws InterruptedException {
		boolean signInEnabled = driver.findElement(By.xpath("span[text()= 'Sign in']")).isEnabled();
		System.out.println("Is Sign in button enabled? Ans: " + signInEnabled);
		Thread.sleep(3000);
	}

	@Test(enabled = true, priority = 3)
	public void isSelectedTest() throws InterruptedException {
		boolean isCheckboxSelected = driver
				.findElement(By.cssSelector("div.styles__CheckboxVisual-sc-1ekjv4k-5.cFLzIx")).isSelected();
		System.out.println("Is keep me signed in checkbox selected? Ans: " + isCheckboxSelected);
		Thread.sleep(3000);
	}

	@Test
	public void getTitleTest() throws InterruptedException {
		System.out.println("The title of the page is: " + driver.getTitle());
		Thread.sleep(3000);
	}

	@Test
	public void getCurrentUrlTest() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Sign in']")).click();
		driver.findElement(By.xpath("//span[contains(@class,'sc-diphzn-1 fVlQrE') and text()='Sign in']")).click();
		Thread.sleep(3000);
		System.out.println("The current page URL is: " + driver.getCurrentUrl());
	}

	@Test
	public void getTextTest() throws InterruptedException {
		WebElement title = driver.findElement(By.xpath("//span[text()='Sign into your Target account']"));
		System.out.println("The title of the page is: " + title.getText()); // has to be the text attribute value
		Thread.sleep(3000);
	}

	@Test
	public void getAttributeTest() throws InterruptedException {
		String value = driver.findElement(By.xpath("//h3[text()='All Categories']")).getAttribute("class");
		System.out.println("The value of Class attribute is: " + value);
		Thread.sleep(3000);
	}

	@Test
	public void sendKeysTest1() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("taha@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#password")).sendKeys("987453#$!");
		Thread.sleep(3000);
	}

	@Test
	public void clearTest() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='username']")).clear();
		Thread.sleep(3000);
	}

	@Test
	public void sendKeysTest2() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("taha@gmail.com", Keys.ENTER);
		Thread.sleep(3000);

	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
