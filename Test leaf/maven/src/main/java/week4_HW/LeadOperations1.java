package week4_HW;

import org.testng.annotations.Test;

public class LeadOperations1 extends wraperOpentaps{
	
	public  String[] leadid = new String[2];
	public  int i=0;
	public String str;
	@Test(description = "To verify that logged in user is able to Create Lead", dataProvider = "createleaddata", threadPoolSize = 2)
	public void TC_01_CreateLead(String company, String firstName, String lastName) {

		// System.out.println("Click Leads Tab and created lead with "+company+"
		// "+firstName+" "+lastName);
		
		
		clickByLinkText("Create Lead");
		enterTextbyID("createLeadForm_companyName", company);
		enterTextbyID("createLeadForm_firstName", firstName);
		enterTextbyID("createLeadForm_lastName", lastName);
		clickbyname("submitButton");
		str=getTextById("viewLead_companyName_sp");
		leadid[i] = str.substring(str.indexOf("(")+1, str.indexOf(")"));
		System.out.println(leadid[i]);
		i++;
		
	}
	
	@Test(description = "To verify that logged in user is able to Edit Lead", timeOut = 10000, dependsOnMethods="TC_01_CreateLead")
	public void TC_03_EditLead() {

		// System.out.println("Click leads Tab and perform edit lead");

		clickByLinkText("Find Leads");
		enterTextByName("id", leadid[1]);
		clickByXpath("//button[text()='Find Leads']");
		clickByLinkText(leadid[1]);
		clickByLinkText("Edit");
		enterTextbyID("updateLeadForm_generalProfTitle", "TestNG");
		clickbyname("submitButton");
	}
	
	@Test(description = "To verify that logged in user is able to Merge Lead",enabled=false)
	public void TC_02_MergeLead() {

		// System.out.println("Click Leads Tab and perform Merge Lead");
		//String[] leadid = { "10046", "10054" };

		clickByLinkText("Merge Leads");
		clickByXpath("(//img[@src='/images/fieldlookup.gif'])[1]");
		switchtolastwindow();
		enterTextByName("id", leadid[0]);
		clickByXpath("//button[text()='Find Leads']");
		clickByLinkTextWithoutScreenshot(leadid[0]);
		switchToParentwindow();
		clickByXpath("(//img[@src='/images/fieldlookup.gif'])[2]");
		switchtolastwindow();
		enterTextByName("id", leadid[1]);
		clickByXpath("//button[text()='Find Leads']");
		clickByLinkTextWithoutScreenshot(leadid[1]);
		switchToParentwindow();
		clickByClassWithoutScreenshot("buttonDangerous");
		switchToAlert("accept");
		clickByLinkText("Find Leads");
		enterTextByName("id", leadid[0]);
		clickByXpath("//button[text()='Find Leads']");
		if (!clickByLinkText(leadid[0]))
			System.out.println("Leads Merged successfully");
		else {
			System.err.println("Merge not successful");
		}

	}

}
