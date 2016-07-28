package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.OpentapsWrappers;

import org.testng.annotations.BeforeClass;

public class TC001_Create extends OpentapsWrappers{
	@Test(dataProvider="fetchData")
	public void CreateLeadPage(String username, String password,String companyName,String firstName,String lastName, String AddSource, String AddMarketingCampaign) throws InterruptedException {

		new LoginPage()
		.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.clickCrmsfa()
		.clickLeads()
		.clickCreateLead()
		.enterCompanyName(companyName)
		.enterFirstName(firstName)
		.enterLastName(lastName)
		.sourceSelect(AddSource)
		.selectMarketingCampaign(AddMarketingCampaign)
		.clickCreateLead();
	}
	@BeforeClass
	public void beforeClass() {
		dataSheetName="TC001";
		browserName="firefox";
		testCaseName="Login to OpenTaps";
		testDescription="Login and Logout in Opentaps using POM framework";
	}

	
	
	
	
	
	
}
