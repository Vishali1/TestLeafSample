package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestngParameters {
	public static WebDriver driver=null;
	@Test
	@Parameters({"sUsername","sPassword"})

	public void test(String sUsername, String sPassword) {

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://demo1.opentaps.org/");

		//driver.findElement(By.xpath(".//*[@id='account']/a")).click();

		driver.findElement(By.id("username")).sendKeys(sUsername);

		driver.findElement(By.id("password")).sendKeys(sPassword);

		driver.findElement(By.className("decorativeSubmit")).click();

		//driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();

		driver.quit();

	}
}
