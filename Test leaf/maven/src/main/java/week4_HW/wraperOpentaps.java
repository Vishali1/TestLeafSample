package week4_HW;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class wraperOpentaps extends WrapperClass_v4 {

	@BeforeMethod
	@Parameters("browser")
	public void login(String browser) {
		String username1 = "DemoSalesManager";
		String password1 = "crmsfa";

		launchApp(browser);
		enterTextbyID("username", username1);
		enterTextbyID("password", password1);
		clickByClass("decorativeSubmit");
		clickByLinkText("CRM/SFA");
		clickByLinkText("Leads");
	}

	@DataProvider(name = "createleaddata")
	public Object[][] getDataLead() {

		Object[][] lead = new Object[2][3];

		lead[0][0] = "company1";
		lead[0][1] = "joseph";
		lead[0][2] = "eliyas";

		lead[1][0] = "company2";
		lead[1][1] = "Magesh";
		lead[1][2] = "Ravi";

		return lead;

	}

	/*
	 * public void login(String browser, String username, String password) {
	 * //launchApp("http://demo1.opentaps.org/",browser);
	 * enterTextbyID("username",username); enterTextbyID("password",password);
	 * clickByClass("decorativeSubmit");
	 * 
	 * }
	 */

	/*
	 * @BeforeTest public void clickLead() { clickByLinkText("CRM/SFA");
	 * clickByLinkText("Leads"); }
	 */

}
