package automationFramework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowser {

	public WebDriver driver;
	 
	  @Parameters({"browser","url"})
	 
	  @BeforeMethod
	 
	  // Passing Browser parameter from TestNG xml
	 
	  public void launchApp(String browser, String url) {
	 
	  // If the browser is Firefox, then do this
	 
	  if(browser.equalsIgnoreCase("Firefox")) {
	 
		 @SuppressWarnings("unused")
		FirefoxDriver driver = new FirefoxDriver();
	 
	  // If browser is IE, then do this	  
	 
	  }else if (browser.equalsIgnoreCase("Chrome")) { 
	 
		  // Here I am setting up the path for my IEDriver
	 
		  System.setProperty("webdriver.ie.driver", "./drivers/chromedriver.exe");
	 
		  @SuppressWarnings("unused")
		ChromeDriver driver = new ChromeDriver();
		  
		  driver.get(url);
		  
		
	 
	  } 
	 
	  // Doesn't the browser type, lauch the Website
	 
	 
	  }
	 
	  // Once Before method is completed, Test method will start
	 
	  @Test 
	  public void login() throws InterruptedException {
	 
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();
	 
	    driver.findElement(By.id("log")).sendKeys("testuser_1");
	 
	    driver.findElement(By.id("pwd")).sendKeys("Test@123");
	 
	    driver.findElement(By.id("login")).click();
	 
		}  
	 
	  @AfterMethod
	  public void afterTest() {
	 
			driver.quit();
	 
		}

}
