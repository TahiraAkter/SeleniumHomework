package hw17_selenium_methods;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Web_based_alert {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://enthrallit.com/selenium/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@Test(enabled = true, priority = 14)
	public void acceptWebBasedAlertTest() throws InterruptedException {
		driver.findElement(By.xpath("//button[normalize-space(text())='Click for JS Confirm']")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert(); // Alert interface is instantiated by driver.switchTo().alert()
		Thread.sleep(3000);
		System.out.println("\nThe text of this alert is: " + alert.getText()); // just to see what the alert says
		alert.accept();
	}

	@Test(enabled = true, priority = 15)
	public void cancelWebBasedAlertTest() throws InterruptedException {
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
