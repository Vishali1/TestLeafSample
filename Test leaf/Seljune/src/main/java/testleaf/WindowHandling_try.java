package testleaf;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling_try {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		 
		
		// Open URL
				driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
				
				//Mam FF
				driver.manage().window().maximize();
				
				//set time
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//Parent window
			
			String parentWindow=driver.getWindowHandle();
				
				driver.findElementByLinkText("Contact Us").click();
				
				//get all the windows
				
				Set<String> handles=driver.getWindowHandles();
				
				
for ( String handle : handles)
{
	driver.switchTo().window(handle);
}
//Switched to child window 
System.out.println(driver.getCurrentUrl());
driver.close();

//Switching to parent window
driver.switchTo().window(parentWindow);
System.out.println(driver.getCurrentUrl());
driver.close();


	}

}
