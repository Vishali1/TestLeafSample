package week5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardAndMouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Set the system properties
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

				// Launch Browser - Google Chrome
				ChromeDriver driver = new ChromeDriver();
				
				driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

				// Maximize the browser
				driver.manage().window().maximize();

				// Navigate to URL
				driver.get("http://jqueryui.com/droppable/");
				
				// Go to the frame
				driver.switchTo().frame(driver.findElementByClassName("demo-frame"));
				
				// Find the element to be dragged
				WebElement draggable = driver.findElement(By.id("draggable"));
				WebElement droppable = driver.findElement(By.id("droppable"));

				
				// Actions is the class used to interact with keyboard and mouse
				Actions builder = new Actions(driver);
				builder.dragAndDrop(draggable, droppable).build().perform();
				//builder.dragAndDropBy(draggable, 100, 100).build().perform();
				System.out.println("position" + draggable.getLocation());
				System.out.println(driver.findElementByXPath("//*[@id='droppable']/p").getText());
	}

}
