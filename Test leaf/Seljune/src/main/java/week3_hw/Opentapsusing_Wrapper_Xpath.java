package week3_hw;

import java.io.IOException;

import org.junit.Test;

public class Opentapsusing_Wrapper_Xpath extends WrapperMethod_Xpath{
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
		enterTextByxpath("//*[@id='username']", "DemoSalesManager");
		
		//Enter Password
		//driver.findElementById("password").sendKeys("crmsfa");
		enterTextByxpath("//*[@id='password']", "crmsfa");
			
		
		// TODO Auto-generated method stub
		
	}

}
