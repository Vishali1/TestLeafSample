package week4_day1_hw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import wrapper.Opentaps_Wrapper;

public class Testng_rules extends Opentaps_Wrapper {
	int snapcount=1;
	RemoteWebDriver driver=null;
	@BeforeSuite
	public void launchapp(String Url,String browser)
	{
		try {
			if(browser.equalsIgnoreCase("Chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver= new ChromeDriver();
				}
			else if(browser.equalsIgnoreCase("Firefox")){
				driver= new FirefoxDriver();
			}
			//Get URL
			 driver.get(Url);
			 //maximise window
			 driver.manage().window().maximize();
			 //Implict wait
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to launch the app");
			
			}
		finally{
			CaptureScreenshot();
			}
		}
	@AfterSuite
	public void closeapp(){
		try {
			driver.close();
		} catch (Exception e) {
			
			System.out.println("Unable to close the application");
		}
		finally{
			CaptureScreenshot();
		}
	}

@BeforeTest
	public void login(String browser, String username, String password)
	{
		launchapp("http://demo1.opentaps.org/",browser);
		enterTextbyID("username",username);
		enterTextbyID("password",password);	
		clickbyclass("decorativeSubmit");
	}	
	@AfterTest
	public void Logout() {
			System.out.println(" Application Logout");
		}
}
