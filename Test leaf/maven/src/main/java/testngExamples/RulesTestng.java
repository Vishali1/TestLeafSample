package testngExamples;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import wrapper.Opentaps_Wrapper;

public class RulesTestng extends Opentaps_Wrapper{

	@BeforeSuite
	public void Login(){
		
		login("Chrome", "DemoSalesManager", "crmsfa");
		clickbylinktext("CRM/SFA");
		System.out.println("Logged into the application");
	}
	
	@AfterSuite(enabled=true)
	public void Logout(){
		
		System.out.println("Logout and close the browser");
	}
}
