package testcase;



import org.testng.annotations.Test;

import wrapper.Opentaps_Wrapper;


public class Duplicate_Lead extends Opentaps_Wrapper {
	@Test
	public void Login()
	{
		login("Chrome", "DemoSalesManager", "crmsfa");
		clickbylinktext("CRM/SFA");
		clickbylinktext("Leads");
		clickbylinktext("Find Leads");
		clickbyxpath("//span[contains(text(),'Email')]");
		enterTextbyName("emailAddress","jjguava@testleaf.com");
		clickbyxpath("//button[contains(text(),'Find Leads')]");
		clickbyxpath("(//a[@class='linktext'])[4]");
		String Firstname=getTextbyId("viewLead_firstName_sp");
		System.out.println("First Name is " +Firstname);
		String companyName=getTextbyId("viewLead_companyName_sp");
		int strlength=companyName.length();
			String leadid=companyName.substring(strlength-6,strlength-1);
			
			System.out.println("Lead Id of the created lead is " +leadid);
			clickbylinktext("Duplicate Lead");
			
			String Duplicate_Firstname=getAttributebyId("createLeadForm_firstName");
			
			//String Duplicate_Firstname=getAttribute("createLeadForm_firstName");
			
			System.out.println("Print the Duplicate_first name " +Duplicate_Firstname);
			
			if(Firstname.equals(Duplicate_Firstname))
			{
				System.out.println("Duplicated First name is same");
			}
			else{
				System.out.println("Duplicated Firstname is not same");
			}
			clickbyname("submitButton");
			
			String companyName2=getAttributebyId("viewLead_companyName_sp");
			int strlength2=companyName2.length();
				String leadid2=companyName2.substring(strlength2-6,strlength2-1);
				
				System.out.println("Lead Id of the Duplicated lead is " +leadid2);
				
				
	}
}
