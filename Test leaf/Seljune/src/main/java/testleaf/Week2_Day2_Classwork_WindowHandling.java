package testleaf;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Week2_Day2_Classwork_WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		 
		
		// Open URL
				driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
				
				//Mam FF
				
			driver.manage().window().maximize();
				
				//set time
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				String parentwindow = driver.getWindowHandle();
				
				driver.findElementByLinkText("Contact Us").click();
				//driver.switchTo().window(WinHandle)
				
			Set<String> handles = driver.getWindowHandles();
			
	for (String handle : handles) {
		
		driver.switchTo().window(handle);		
	}	
	
	System.out.println(driver.getCurrentUrl());
	driver.close();
	
	driver.switchTo().window(parentwindow);
	System.out.println(driver.getCurrentUrl());
	
	Thread.sleep(3000);
	
	driver.close();
	}

}
