package testcase;



import org.testng.annotations.Test;

import wrapper.Opentaps_Wrapper;
import wrapper.Wrapper_Methods;

public class Testcase extends Opentaps_Wrapper{
@Test
	public void Login()
	{
	login("Chrome", "DemoSalesManager", "crmsfa");
	String[] firstname= {"vishali", "Gowthami"};
	String[] lastname= {"kadali","ravi"};
	String[] email={"jjguava@testleaf.com","jjguava1@testleaf.com"};
	String[] phone={"9900990099","9000000000"};
	clickbylinktext("CRM/SFA");
	
		for(int i=0;i<=1;i++)
		{
			
			clickbylinktext("Create Lead");
			enterTextbyID("createLeadForm_companyName","JJGUAVA");
			enterTextbyID("createLeadForm_firstName",firstname[i]);
			enterTextbyID("createLeadForm_lastName",lastname[i]);
			dropdownselectByIdbyVisibletext("createLeadForm_dataSourceId","Partner");
			dropdownselectByIdbyVisibletext("createLeadForm_marketingCampaignId","Automobile");
			enterTextbyID("createLeadForm_primaryEmail",email[i]);
			enterTextbyID("createLeadForm_primaryPhoneNumber",phone[i]);
			clickbyname("submitButton");
			
	String companyName=getTextbyId("viewLead_companyName_sp");
	int strlength=companyName.length();
		String leadid=companyName.substring(strlength-6,strlength-1);
		
		System.out.println(leadid);
		}
	
	
	}


}
