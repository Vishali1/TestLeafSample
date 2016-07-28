package week3_hw;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

public void enterTextByName(String name, String keyValue) throws IOException{
		
		try {
			driver.findElementByName(name).sendKeys(keyValue);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("The Element with id :"+name+"is not available");
		}
		finally{
			CaptureScreenshot();
		}
	
}
	
	public void passwordbyName(String name, String value){
		try {
			driver.findElementByClassName(name).sendKeys(value);
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
	
public void CaptureScreenshot() throws IOException
{
	File snap = driver.getScreenshotAs(OutputType.FILE);
	
	//The below method will save the screen shot in d drive with name "screenshot.png"
    FileUtils.copyFile(snap, new File("./Screenshot/Print1.jpeg"));
}
   
}
