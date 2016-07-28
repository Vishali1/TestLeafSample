package testngExamples;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenTaps extends TestngAnnotations {
	@BeforeMethod
	public void launchBrowser(){
		
		System.out.println("Launch browser and login to open taps and click on CRM/SFA ");
	}
	@Test
	public void createLead(){
		
		System.out.println("Click Leads Tab and perform Create Lead");
	}
	@Test(dependsOnMethods="createLead")
	public void editLead(){
		
		System.out.println("Click leads Tab and perform edit lead");
	}
	@Test(enabled=false)
	public void mergeLead(){
		
		System.out.println("Click Leads Tab and perform Merge Lead");
	}
	@AfterMethod
	public void closeBrowser(){
		
		System.out.println("Logout and close browser");
	}
	
}
