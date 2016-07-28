package testleaf;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Week2_ClosePopUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        driver.get("http://popuptest.com/");    
        
        driver.findElementByLinkText("Multi-PopUp Test #2").click();
        
        Thread.sleep(1000);
        String parentwindow = driver.getWindowHandle();
        Set<String> windoWs = driver.getWindowHandles();
        
for (String winOne : windoWs) {
	
	driver.switchTo().window(winOne);	
	
	if (driver.getCurrentUrl().equalsIgnoreCase("http://popuptest.com/popuptest12.html")) {
	    continue;
	} else {
		System.out.println("2" + driver.getCurrentUrl());
	    driver.close();
	}
	
}

driver.switchTo().window(parentwindow);
System.out.println(driver.getCurrentUrl());
driver.close();


	}
}