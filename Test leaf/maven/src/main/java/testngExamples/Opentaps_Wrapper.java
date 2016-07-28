package testngExamples;

import org.testng.annotations.BeforeMethod;

public class Opentaps_Wrapper extends WrapperClass_v4 {
 @BeforeMethod
	public void login(String browser, String username, String password)
	{
		launchApp("http://demo1.opentaps.org/",browser);
		enterTextbyID("username",username);
		enterTextbyID("password",password);	
		clickByClass("decorativeSubmit");
		
	}
	
}
