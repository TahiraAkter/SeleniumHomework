package PracticeTahira;


import java.util.function.ToDoubleBiFunction;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class Use_of_find_elements_java {
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver=new ChromeDriver();
		js=(JavascriptExecutor) driver;
		
	
	}
	
	
	
	
	
	
	
	
	

}
