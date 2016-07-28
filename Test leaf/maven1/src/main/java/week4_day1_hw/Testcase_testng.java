package week4_day1_hw;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Testcase_testng extends week4_day1_hw.Opentaps_Wrapper {
@BeforeTest
	public void Login()
	{
	login("Chrome", "DemoSalesManager", "crmsfa");
	}
	@Test(invocationCount=2)
	public void  createlead()
	{
		clickbylinktext("CRM/SFA");	
			clickbylinktext("Create Lead");
			enterTextbyID("createLeadForm_companyName","JJGUAVA");
			enterTextbyID("createLeadForm_firstName","vishali");
			enterTextbyID("createLeadForm_lastName","kadali");
			dropdownselectByIdbyVisibletext("createLeadForm_dataSourceId","Partner");
			dropdownselectByIdbyVisibletext("createLeadForm_marketingCampaignId","Automobile");
			enterTextbyID("createLeadForm_primaryEmail","jjguava@testleaf.com");
			enterTextbyID("createLeadForm_primaryPhoneNumber","9999900000");
			clickbyname("submitButton");
			
	String companyName=getTextbyId("viewLead_companyName_sp");
	int strlength=companyName.length();
		String leadid=companyName.substring(strlength-6,strlength-1);
		System.out.println(leadid);
	}
	@Test(enabled=false)
	public void DeleteLead(){
		System.out.println("Delete the lead");
	}
	
	@Test
	public void EditLead(){
		System.out.println("Edit the lead");
	}
	@Test
	public void MergeLead(){
		System.out.println("MergeLead");
	}
	@AfterTest
	public void closeapp(){
	System.out.println("logout of the application and close the browser");
	}

}
