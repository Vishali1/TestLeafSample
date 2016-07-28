package week3_june;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class WrapperMethod {
RemoteWebDriver driver;
	@Test
	public void launchapplication()
	{
       System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		//launch chrome
		 driver=new ChromeDriver();

		// Open URL
		driver.get("http://demo1.opentaps.org/");
		
		//Mam FF
		driver.manage().window().maximize();
		
		//set time
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	public void loginbyIDandpass(String id, String value ){
		try {
			driver.findElementById(id).sendKeys(value);
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Error " + e);
		}
	
}
	
	public void passwordbyID(String id, String value){
		try {
			driver.findElementById(id).sendKeys(value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Error " + e);
		}
	}
	
	public void submitbyclass(String className)
	{
		try {
			driver.findElementByClassName(className).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Error " + e);
		}
	}
	
	public void selectbyvalue (String id, String value)
	{
		Select date=new Select(driver.findElementById(id));
		date.selectByValue(value);
	}
}
