package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class FindMergeLead extends OpentapsWrappers{
	public FindMergeLead() {
		if(!verifyTitle("Find Leads"))
			Reporter.reportStep("This is not Find Leads Page", "FAIL");
	}
	public FindMergeLead enterLeadid(String firstname){
		enterById(prop.getProperty("FindMergeLeads.firstname.name"), firstname);
		return this;
	}
	public FindMergeLead clickFindLeadsbutton(){
		clickByXpath(prop.getProperty("FindMergeLeads.FindLead.Xpath"));
		return this;
	}
	public MergeLeadsPage clickFirstResult(){
		clickByXpath("FindleadsWindow.leadid.Xpath");
		switchToParentwindow();
		return new MergeLeadsPage();
	}
	
	
}
