package week3_june;

import org.junit.Test;

public class Opentapsusing_Wrap1 extends Wrap1{
	
	@Test
	public void main(String[] args)
	{
//		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
//		
//		//launch chrome
//		ChromeDriver driver=new ChromeDriver();
//
//		// Open URL
//		driver.get("http://demo1.opentaps.org/");
//		
//		//Mam FF
//		driver.manage().window().maximize();
//		
//		//set time
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		launchapplication();
		
		//Enter Username
		loginbyIDandpass("username", "DemoSalesManager");
		
		//Enter Password
		//driver.findElementById("password").sendKeys("crmsfa");
		loginbyIDandpass("password", "crmsfa");
		
		//Login
		//driver.findElementByClassName("decorativeSubmit").click();
		submitbyclass("decorativeSubmit");
		
		//ClickCRM/SFA
		driver.findElementByLinkText("CRM/SFA").click();
		
		//Clicl Create Lead
		driver.findElementByLinkText("Create Lead").click();
		
		//Username PAssword
		//driver.findEl
		
		//Enter Copany Name
		driver.findElementById("createLeadForm_companyName").sendKeys("Test Leaf");
		
		//Enter First Name
		driver.findElementById("createLeadForm_firstName").sendKeys("Prabakaran");
		
		//Enter Last Name
		driver.findElementById("createLeadForm_lastName").sendKeys("Eswaramoorthi");
		
		//Click Submit
		driver.findElementByClassName("smallSubmit").click();
		
		//Print Title
		//System.out.println("This is Title "+driver.getTitle());
		
		//Logout
				//driver.findElementByLinkText("Logout").click();
		
		//Close
		//driver.close();
		
		
		
			
			
	}

}
