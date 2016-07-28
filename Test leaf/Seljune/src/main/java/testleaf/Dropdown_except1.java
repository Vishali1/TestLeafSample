package testleaf;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Dropdown_except1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://temre701.intra.renault.fr/tem/home.do?return=true");
		driver.findElement(By.name("j_username")).sendKeys("z010884");
		driver.findElement(By.name("j_password")).sendKeys("june2016");
		driver.findElement(By.xpath(".//*[@id='RnoPageLevelButtonsBottom']/ul/li/a")).click();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("HM_Item1_2")).click();
		driver.findElement(By.id("HM_Item1_2_1")).click();
		Select dropdown= new Select(driver.findElementById("typeOfDate"));
		
		 List<WebElement> allOptions= dropdown.getOptions();
		 
		System.out.println("Print the no of options " +allOptions.size());
		
		
		
	for(int i=1; i<=allOptions.size()-1; i++)
		
		System.out.println(allOptions.get(i).getText());
					
	}

}
