package testleaf;

import java.util.List;
import java.util.concurrent.TimeUnit;





import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Week2_Day1_Edit_Fields {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://demo1.opentaps.org");
		
		//Maximise Chrome
		driver.manage().window().maximize();
		
		//Implicit wait(Default Timeout)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> textboxes= driver.findElementsByXPath("//input[@type='text']");
		
		System.out.println("Total no of textboxes " +textboxes.size());
		
	
	
	
		
		
	}

}
