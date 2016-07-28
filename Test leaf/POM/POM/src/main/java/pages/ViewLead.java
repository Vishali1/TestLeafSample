package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class ViewLead extends OpentapsWrappers{

	public ViewLead() {
		if(!verifyTitle("View Lead | opentaps CRM"))
			Reporter.reportStep("This is not View Lead Page", "FAIL");
	}	

	public ViewLead clickDelete() {
		clickByClassName(prop.getProperty("ViewLead.DeleteButton.ClassName"));
		return this;

	}

	public EditLeadsPage clickEdit() {
		clickByXpath(prop.getProperty("ViewLead.Edit.Xpath"));
		return new EditLeadsPage();

	}

	public ViewLead verifyFirstName(String firstName) {
		verifyTextById(prop.getProperty("viewLead_firstName_sp"), firstName);
		return this;
	}

	public ViewLead verifySources(String sources) {
		verifyTextById(prop.getProperty("ViewLead.Sources.Id"), sources);
		return this;
	}

	public ViewLead verifyMarketingCampaigns(String marketingCampaigns) {
		verifyTextById(prop.getProperty("ViewLead.marketingCampaigns.Id"), marketingCampaigns);
		return this;
	}














}
