package week3_hw;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WrapperMethod_Xpath {
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
		public void enterTextByxpath(String xpath, String keyValue) throws IOException{
			
			try {
				driver.findElementByXPath(xpath).sendKeys(keyValue);
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println("The Element with id :"+xpath+"is not available");
			}
			finally{
				CaptureScreenshot();
			}
		
	}
		
		public void enterTextByxpath1(String xpath, String value){
			try {
				driver.findElementByXPath(xpath).sendKeys(value);
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println("Error " + e);
			}
		}
		public void CaptureScreenshot() throws IOException
		{
			File snap = driver.getScreenshotAs(OutputType.FILE);
			
			//The below method will save the screen shot in d drive with name "screenshot.png"
		    FileUtils.copyFile(snap, new File("./Screenshot/Print1.jpeg"));
		}
	}

