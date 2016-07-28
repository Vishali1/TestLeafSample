package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class MyLeadsPage extends OpentapsWrappers  {
	
	public  MyLeadsPage() {
		if(!verifyTitle("My Leads | opentaps CRM"))
			Reporter.reportStep("This is not My Leads Page", "FAIL");
		
	}	
	 public CreateLeadPage clickCreateLead(){
		   clickByLink(prop.getProperty("MyLead.CreateLead.linktext"));
		return new CreateLeadPage();
	   }
	public FindLeadsPage clickFindLeads(){
			clickByLink(prop.getProperty("Mylead.FindLeads.Linktext"));
			return new FindLeadsPage();
		}
		
		public MergeLeadsPage clickMergeLeads(){
			clickByLink(prop.getProperty("MyLead.MergeLeads.Linktext"));
			return new MergeLeadsPage();
		}


}
