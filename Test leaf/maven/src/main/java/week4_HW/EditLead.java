package week4_HW;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testngExamples.RulesTestng;

public class EditLead extends RulesTestng{
	@Test(threadPoolSize=2)
	public void CreateLead(){
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
	@Test(dependsOnMethods={"CreateLead"},timeOut=10000)
	public void editLead() {
		clickbyxpath("//a[contains(text(),'Edit')]");
		clickbyname("submitButton");
		System.out.println("Edit Lead is executed");
	
	}

}
