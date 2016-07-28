package wrapper;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Opentaps_Wrapper extends Wrapper_Methods {
	@Test
	public void login(String browser, String username, String password)
	{
		launchapp("http://demo1.opentaps.org/",browser);
		enterTextbyID("username",username);
		enterTextbyID("password",password);	
		clickbyclass("decorativeSubmit");
		clickbylinktext("CRM/SFA");
	}
	
}
