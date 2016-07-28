package testleaf;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Week2_Day2_hw_iframes {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://layout.jquery-dev.com/demos/iframes_many.html");
		
		//Maximise Chrome
		driver.manage().window().maximize();
		
		//Implicit wait(Default Timeout)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> totaliframes= driver.findElementsByTagName("iframe");
		
		System.out.println("total iframes "+totaliframes.size());
		
		driver.switchTo().frame(0);
		
		List<WebElement> totaliframes0= driver.findElementsByTagName("iframe");
		
		System.out.println("total iframes "+totaliframes0.size());
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(driver.findElementByXPath("/html/body/iframe[2]"));
		
		System.out.println("I switched to frame");
		
		driver.findElementByXPath("(//span[@class='categoryName'])[2]").click();
		
		System.out.println("I clicked on images");
		
	driver.findElementById("topSearchTextBox").sendKeys("dogpile");
	
	driver.findElementById("topSearchSubmit").click();
	
	Thread.sleep(3000);
	
	driver.close();
	
		
	}

}
