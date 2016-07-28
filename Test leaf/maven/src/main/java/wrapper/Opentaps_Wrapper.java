package wrapper;

public class Opentaps_Wrapper extends Wrapper_Methods {
 
	public void login(String browser, String username, String password)
	{
		launchapp("http://demo1.opentaps.org/",browser);
		enterTextbyID("username",username);
		enterTextbyID("password",password);	
		clickbyclass("decorativeSubmit");
		
	}
	
}
