package hw17_selenium_methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessBrowser {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.target.com");
		Thread.sleep(3000);
		System.out.println("The current URL is: " + driver.getCurrentUrl());
		System.out.println("Test execution has completed");
		driver.quit();

	}

}
