package week3_june;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WrapperMethods {
	RemoteWebDriver driver = null;
	public void enterTextById(String id, String keyValue){
		
		try {
			driver.findElementById(id).sendKeys(keyValue);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("The Element with id :"+id+"is not available");
		}
		finally{
			//capture the screenshot
		}
	}
	public void clickByClassName(String className){
		try {
			driver.findElementByClassName(className).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("The Element with ClassName :"+className+"is not available");
		}	
		finally{
			//capture the screenshot
		}
		
	}
	public void clickByXPath(String xPath){
		try {
			driver.findElementByXPath(xPath).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("The Element with Xpath :"+xPath+"is not available");
		}	
		finally{
			//capture the screenshot
		}
		
	}
	public boolean verifyTitle(String expectedTitle){
		boolean flag=false;
		try {
			
			String title = driver.getTitle();
			if(title.equals(expectedTitle)){
				System.out.println("Title Matches");
				flag=true;
			}
			else{
				System.out.println("Title does not Match");
				flag=false;
			}
			
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to verfiy the title");
		}
		finally{
			//capture the screenshot
			return flag;
		}
		
		
	}
	public String getTextByXpath(String xpath){
		String selectString=null;
		try {
			selectString = driver.findElementByXPath(xpath).getText();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("The Element with Xpath :"+xpath+"is not available");
		}
		finally
		{
			//capture the screenshot
		}
		return selectString;
	}
	public void launchApp(String url, String browser){
		try {
			if(browser.equalsIgnoreCase("firefox")){
			// Open Firefox browser
					 driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", 

"./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
					// maximize the browser window
					driver.manage().window().maximize();

					//implicit wait
					driver.manage().timeouts().implicitlyWait(30, 

TimeUnit.SECONDS);

					// load the URL
					driver.get(url);
					//capture the screenshot
		} catch (Exception e) {
			System.out.println("browser could not be launched");
		}
}
}
