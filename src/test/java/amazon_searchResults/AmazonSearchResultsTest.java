package amazon_searchResults;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonSearchResultsTest {
	
	
	 WebDriver driver;
	
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/mehediredoy/eclipse-workspace/AmazonSearch/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(3000);
		
		
	}
	
	@Test
	public void searchResuktDisplayed() {
		
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("iphone 15");
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		
		Assert.assertTrue(driver.getTitle().contains("iphone 15"));
		
//		driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
//		
//		Assert.assertTrue(driver.getTitle().contains("iphone 15"));
//		
//		driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_UP);
//		
//		Assert.assertTrue(driver.getTitle().contains("iphone 15"));
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -1000)");
		
		
		Assert.assertTrue(driver.getTitle().contains("iphone 15"));
		
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000)");
		
		Assert.assertTrue(driver.getTitle().contains("iphone 15"));
		
		
		
	}
	
	@AfterTest
	public void tearDown(){
		
		driver.close();
		driver.quit();
	
	}
	
	
	
	
	

}
