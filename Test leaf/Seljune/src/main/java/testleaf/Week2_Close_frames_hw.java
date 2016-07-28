package testleaf;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Week2_Close_frames_hw {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://layout.jquery-dev.com/demos/iframe_local.html");
		
		//Maximise Chrome
		driver.manage().window().maximize();
		
		//Implicit wait(Default Timeout)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> totaliframes= driver.findElementsByTagName("iframe");
		
		System.out.println("total iframes "+totaliframes.size());
		
		driver.switchTo().frame("childIframe");
		
		//Close Iframe west
		
				driver.findElementByXPath("/html/body/div[2]/p/button").click();
			
		//Close Iframe east 
				driver.findElementByXPath("/html/body/div[3]/p/button").click();
				
		//Come out of frame
				driver.switchTo().defaultContent();
				
		//Close west
				driver.findElementByXPath("/html/body/div[1]/p[1]/button").click();
		
		//Close east 
		driver.findElementByXPath("/html/body/div[2]/p/button").click();
		
	
		
		//driver.close();
		
		
		
		
		
		
	}

}
