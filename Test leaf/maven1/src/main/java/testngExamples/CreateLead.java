package testngExamples;

import org.testng.annotations.BeforeMethod;

import wrapper.Opentaps_Wrapper;

public class CreateLead extends Opentaps_Wrapper {
	@BeforeMethod
	public void Login()
	{
	login("Chrome", "DemoSalesManager", "crmsfa");

	}
}
