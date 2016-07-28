package testleaf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Week1_Day1_Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirefoxDriver driver= new FirefoxDriver();
		driver.get("http://demo1.opentaps.org");
		//Maximise Firefox
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
		
	//Click on 'Create Lead' on the side panel(Use link text)
		driver.findElement(By.linkText("Create Lead")).click();
		
	//Fill all the mandatory fields	
		
	//Enter the company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("RNTBCI");
	
	//Enter the First name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Vishali");
	//Enter the Last name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Kadali");
    //Click 'Create Lead' 
	driver.findElement(By.name("submitButton")).click();

	//Print title of the page
		String title = driver.getTitle();
		System.out.println(title);
		System.out.println(driver.getTitle());
	
	//Print the Company Name ID of the Created Lead
		System.out.println(driver.findElementById("viewLead_companyName_sp").getText());
	}

}
