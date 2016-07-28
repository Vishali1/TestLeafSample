package automationFramework;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Wrap {

	int snapcount = 1;
	public static RemoteWebDriver driver = null;
	String parentwindow = null;

	/**
	 * This method will launch the broswer,get the URL,maximize the window and
	 * implicitly wait to locate the webelement
	 * 
	 * @param Url
	 * @param browser
	 */
	@Parameters({"Url","browser"})
	@BeforeMethod
		public void launchApp(String Url, String browser) {
			try {
				if (browser.equalsIgnoreCase("Chrome")) {
					System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
					driver = new ChromeDriver();
					System.out.println("Chrome driver is successfully launched");
				} else if (browser.equalsIgnoreCase("Firefox")) {
					driver = new FirefoxDriver();
					System.out.println("Firefox driver is successfully launched");
				}
				// Get URL
				driver.get(Url);
				// maximise window
				driver.manage().window().maximize();
				// Implict wait
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				System.out.println("Application is successfully launched");
				// storing the parent window
				parentwindow = driver.getWindowHandle();

			} catch(UnreachableBrowserException e){
				System.out.println("Could not reach browser");
				
			}
			
			catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Unable to launch the app");

			} 
			finally {
				CaptureScreenshot();
			}
	}

	/*
	 * // Get URL driver.get(Url); // maximise window
	 * driver.manage().window().maximize(); // Implict wait
	 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 * System.out.println("Application is successfully launched"); // storing
	 * the parent window parentwindow = driver.getWindowHandle();
	 * 
	 * } catch (UnreachableBrowserException e) {
	 * System.out.println("Could not reach browser");
	 * 
	 * }
	 * 
	 * catch (Exception e) { // TODO Auto-generated catch block
	 * System.out.println("Unable to launch the app");
	 * 
	 * } finally { CaptureScreenshot(); } }
	 * 
	 * /** This method will close the current application running in the browser
	 */
	@AfterMethod
	public void logoutandCloseApp() {

		try {
			driver.close();
			System.out.println("Logged out successfully");
		} catch (UnreachableBrowserException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to logout of the application");
		} finally {
			CaptureScreenshot();
		}
	}

	
	public void enterTextbyID(String id,String value){
		 try {
			driver.findElementById(id).sendKeys(value);
		} catch (NoSuchElementException e) {
			System.out.println("Element by"+id+ "is not found");
		}
		 finally{
			 CaptureScreenshot();
		 }
	}
	public void CaptureScreenshot() {

		try {

			File srcfile = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile, new File("./Snapshot/" + snapcount + ".jpeg"));
			snapcount++;
		} catch (UnreachableBrowserException e) {
			System.out.println("Could not reach browser");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to capture screenshot");
		}
	}

	public void enterTextbyclassname(String classname,String value){
		try {
			driver.findElementByClassName(classname).sendKeys(value);
		} catch (NoSuchElementException e) {
			System.out.println("Element by"+classname+ "is not found");
		}
		finally{
			CaptureScreenshot();
		}
	}
	public void clickbyclassName(String className)
	{
		try {
			driver.findElementById(className).click();
		} catch (NoSuchElementException e) {
			System.out.println("Element by"+className+ "is not found");
		}
		finally{
			CaptureScreenshot();
		}
	}

}
