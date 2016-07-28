package testcases;

import org.testng.annotations.Test;

import pages.EditLeadsPage;
import pages.LoginPage;
import wrappers.OpentapsWrappers;

import org.testng.annotations.BeforeClass;

public class TC002_Edit extends OpentapsWrappers{
	@Test(dataProvider="fetchData")
	public void EditLeadsPage(String username, String password,String companyName,String firstName,String lastName, String AddSource, String AddMarketingCampaign, String SelectSource, String MarketingCampaign) throws InterruptedException {

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
		.clickCreateLead()
		.clickEdit()
		.selectSource(SelectSource)
		.clickAddsource()
		.selectMarketingcampaign(MarketingCampaign)
		.clickAddmarketingCampaign()
		.clickUpdate();
	}
	@BeforeClass
	public void beforeClass() {
		dataSheetName="TC002";
		browserName="chrome";
		testCaseName="EditLeadsPage";
		testDescription="Edit the lead using POM framework";
	}
		
		
		
		
		
		
		
		
		

	
	
	
	
	
	
}
