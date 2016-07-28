package testleaf;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Week2_ClosePopUp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://popuptest.com/");    
        driver.findElementByLinkText("Multi-PopUp Test #2").click();
        String parent = driver.getWindowHandle();
        Set<String> allwindows= driver.getWindowHandles();
        
        for (String eachwin : allwindows) {
        	driver.switchTo().window(eachwin);
        	
        	if(parent.equals(eachwin)){
        		continue;
        		        	}
        	        	else
        	{
        		        	driver.close();
        	}
					}
                driver.switchTo().window(parent);
		System.out.println("Page Title of parent : "+driver.getTitle());
        
	}
	}

