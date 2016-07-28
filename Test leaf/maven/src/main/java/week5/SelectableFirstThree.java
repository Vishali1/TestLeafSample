package week5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SelectableFirstThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Set the system properties
		// Set the system properties
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		// Launch Browser - Google Chrome
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

		// Maximize the browser
		driver.manage().window().maximize();

		// Navigate to URL
		driver.get("http://jqueryui.com/selectable/");
		
		driver.switchTo().frame(driver.findElementByClassName("demo-frame"));
		
		// find the first element
		WebElement Element1=driver.findElementByXPath("//*[@id='selectable']/li[1]");
		
		// find the third element
		WebElement Element2 = driver.findElementByXPath("//*[@id='selectable']/li[3]");
		
		Actions builder = new Actions(driver);
		builder.clickAndHold(Element1).release(Element2).build().perform();
		
	}

}
