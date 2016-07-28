package testleaf;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Week2_opentaps_hw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://demo1.opentaps.org");
		
		//Maximise Chrome
		driver.manage().window().maximize();
		
		//Implicit wait(Default Timeout)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Enter Username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		//Enter Password
		driver.findElementById("password").sendKeys("crmsfa");
		
		//Click LoginButton
		driver.findElementByClassName("decorativeSubmit").click();	
		
	//Click on link CRM/SFA (below the big orange button/image)
		driver.findElement(By.linkText("CRM/SFA")).click();
		
	//Click on leads link
		driver.findElementByLinkText("Leads").click();
		
	//Click on Merge leads
		driver.findElementByLinkText("Merge Leads").click();
		
String parentWindow=driver.getWindowHandle();
		
	//Click From lead icon
		driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[1]").click();
	
	//Switch to new window1
		Set<String> handles =driver.getWindowHandles();
		
		for(String childwindow : handles)
		{		
	driver.switchTo().window(childwindow);
		
	}
		
	//Type Lead ID
driver.findElementByXPath("(//input[@type='text'])").sendKeys("1000");

//Click find leads

driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();

//Click on the first lead (note: automatically the second window will close)

//driver.findElementByXPath("//*class[@linktext='10000']").click();

driver.findElementByXPath("(//a[@class='linktext'])").click();

//Switches to parent window
driver.switchTo().window(parentWindow);

//Click on merge button
driver.findElementByLinkText("Merge").click();

System.out.println(driver.switchTo().alert().getText());



}
}

