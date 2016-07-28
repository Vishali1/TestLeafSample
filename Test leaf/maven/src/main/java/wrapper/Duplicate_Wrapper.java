package wrapper;

public class Duplicate_Wrapper extends WrapperClass_v4 {
	public void login(String browser, String username, String password)
	{
		launchApp("http://demo1.opentaps.org/",browser);
		enterTextbyID("username",username);
		enterTextbyID("password",password);	
		clickByClass("decorativeSubmit");
	//	clickByLinkText("Leads");
	//	clickByLinkText("Find Leads");
	//Click on Email
	//	clickByXpath("//span[contains(text(),'Email')]");
	}
}
