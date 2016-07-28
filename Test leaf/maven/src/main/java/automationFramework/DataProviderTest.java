package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	private static WebDriver driver;

	@DataProvider(name = "Authentication")
	public static Object[][] credentials() {

		// The number of times data is repeated, test will be executed the same
		// no. of times

		// Here it will execute two times

		return new Object[][] { { "DemoSalesManager", "crmsfa" }, { "DemoSalesManager", "crmsfa" } };

	}

	// Here we are calling the Data Provider object with its Name

	@Test(dataProvider = "Authentication",threadPoolSize=2)
	public void test(String sUsername, String sPassword) {

		driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://demo1.opentaps.org/");

		//driver.findElement(By.xpath(".//*[@id='account']/a")).click();

		// Argument passed will be used here as String Variable

		driver.findElement(By.id("username")).sendKeys(sUsername);

		driver.findElement(By.id("password")).sendKeys(sPassword);

		driver.findElement(By.className("decorativeSubmit")).click();

		//driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();

		driver.quit();

	}
}
