package week4_day1_hw;

import org.testng.annotations.Test;



public class Opentaps_Wrapper extends Wrapper_Methods {
@Test
	public void login(String browser, String username, String password)
	{
		launchapp("http://demo1.opentaps.org/",browser);
		enterTextbyID("username",username);
		enterTextbyID("password",password);	
		clickbyclass("decorativeSubmit");
		
	}
	public void logout()
	{
		System.out.println("Logout of the application");
	}
}
