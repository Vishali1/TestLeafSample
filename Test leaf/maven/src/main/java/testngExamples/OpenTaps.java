package testngExamples;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import wrapper.Opentaps_Wrapper;

public class OpenTaps extends Opentaps_Wrapper {
	@BeforeMethod
	public void launchBrowser(){
		
		login("Chrome", "DemoSalesManager", "crmsfa");
		clickbylinktext("CRM/SFA");
		System.out.println("Logged into the application");
	}
	@Test
	public void createLead(){
		
		clickbylinktext("Create Lead");
		enterTextbyID("createLeadForm_companyName","JJGUAVA");
		enterTextbyID("createLeadForm_firstName","Vishali");
		enterTextbyID("createLeadForm_lastName","Kadali");
		dropdownselectByIdbyVisibletext("createLeadForm_dataSourceId","Partner");
		dropdownselectByIdbyVisibletext("createLeadForm_marketingCampaignId","Automobile");
		enterTextbyID("createLeadForm_primaryEmail","vishali.kadali@gmail.com");
		enterTextbyID("createLeadForm_primaryPhoneNumber","9990008867");
		clickbyname("submitButton");
		System.out.println("Create Lead is executed");
	}
	@Test(dependsOnMethods="createLead",description="Edit Lead method")
	public void editLead(){
		
		System.out.println("Click leads Tab and perform edit lead");
	}
	@Test(enabled=false,description="Merge Lead method")
	public void mergeLead(){
		
		System.out.println("Click Leads Tab and perform Merge Lead");
	}
	@AfterMethod(alwaysRun=true,description="Closes the browser")
	public void closeBrowser(){
		
		System.out.println("Logout and close browser");
	}
	
}
