package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class CreateLeadPage extends OpentapsWrappers {

	public CreateLeadPage() {
		if (!verifyTitle("Create Lead | opentaps CRM"))
			Reporter.reportStep("This is not Create Lead Page", "FAIL");

	}

	public CreateLeadPage enterCompanyName(String companyName) {
		enterById(prop.getProperty("CreateLeadPage.CompanyName.ID"), companyName);
		return this;

	}

	public CreateLeadPage enterFirstName(String firstName) {
		enterById(prop.getProperty("CreateLeadPage.FirstName.ID"), firstName);
		return this;

	}

	public CreateLeadPage enterLastName(String lastName) {
		enterById(prop.getProperty("CreateLeadPage.LastName.ID"), lastName);
		return this;

	}

	public CreateLeadPage sourceSelect(String AddSource) {
		selectById(prop.getProperty("CreateLeadPage.source.ID"),AddSource );
		return this;

	}

	public CreateLeadPage selectMarketingCampaign(String AddMarketingCampaign) {
		selectById(prop.getProperty("CreateLeadPage.marketingCampaign.Id"), AddMarketingCampaign);
		return this;

	}

	public ViewLead clickCreateLead() {
		clickByXpath(prop.getProperty("CreateLeadPage.Submit.Xpath"));
		return new ViewLead();

	}

}
