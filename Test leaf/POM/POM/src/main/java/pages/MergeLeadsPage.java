package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class MergeLeadsPage extends OpentapsWrappers {
	public MergeLeadsPage() {
		if(!verifyTitle("Merge Leads | opentaps CRM"))
			Reporter.reportStep("This is not Merge Lead Page", "FAIL");
	}	
	
	public FindMergeLead clickFromLeadIcon(){
		 switchtolastwindow();
		clickByXpath(prop.getProperty("MergeLead.icon1.Xpath"));
		return new FindMergeLead();
	}
	
	public FindMergeLead clickToLeadIcon(){
		clickByXpath(prop.getProperty("MergeLead.icon2.Xpath"));
		 switchtolastwindow();
		return new FindMergeLead();
	}
	public ViewLead clickMergeLead(){
		clickByIdWithoutScreenshot(prop.getProperty("MergeLead.Merge.link"));
		switchToAlert("accept");
		return new ViewLead();
	}
}
