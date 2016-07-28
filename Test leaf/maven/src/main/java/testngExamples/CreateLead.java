package testngExamples;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import wrapper.Opentaps_Wrapper;

public class CreateLead extends Opentaps_Wrapper{
	@Test(threadPoolSize=2)
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
}
