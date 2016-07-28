package week5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sortable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		// Launch Browser - Google Chrome
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

		// Maximize the browser
		driver.manage().window().maximize();

		// Navigate to URL
		driver.get("http://jqueryui.com/sortable/");
		
		driver.switchTo().frame(driver.findElementByClassName("demo-frame"));
		
		// find the first element
		WebElement draggable = driver.findElement(By.xpath("//*[@id='sortable']/li[1]"));
		WebElement droppable = driver.findElement(By.id("//*[@id='sortable']/li[6]"));
		
		Actions builder = new Actions(driver);
		builder.dragAndDrop(draggable, droppable).build().perform();

	}

}
