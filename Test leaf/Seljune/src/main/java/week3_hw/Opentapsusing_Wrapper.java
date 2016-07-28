package week3_hw;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

public class Opentapsusing_Wrapper extends WrapperMethod{
	@Test
	public void main() throws IOException
	{
//		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
//		
//		//launch chrome
//		ChromeDriver driver=new ChromeDriver();
//
//		// Open URL
//		driver.get("http://demo1.opentaps.org/");
//		
//		//Mam FF
//		driver.manage().window().maximize();
//		
//		//set time
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		launchapplication();
		
		//Enter Username
		enterTextByName("USERNAME", "DemoSalesManager");
		
		//Enter Password
		//driver.findElementById("password").sendKeys("crmsfa");
		enterTextByName("PASSWORD", "crmsfa");
			
		
		// TODO Auto-generated method stub
		
	}
public void enterTextByClassName(String name, String keyValue) throws IOException{
		
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
	

}
