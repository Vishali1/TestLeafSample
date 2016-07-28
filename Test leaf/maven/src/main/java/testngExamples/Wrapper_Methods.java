package testngExamples;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

public class Wrapper_Methods {
	
	int snapcount=1;
	RemoteWebDriver driver=null;
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
	public void enterTextbyName(String Name,String value){
		try {
			driver.findElementByName(Name).sendKeys(value);
		} catch (NoSuchElementException e) {
			System.out.println("Element by"+Name+ "is not found");
		}
		finally{
			CaptureScreenshot();
		}
	}
	public void enterTextbyXpath(String xpath,String value){
		try {
			driver.findElementByXPath(xpath).sendKeys(value);
		} catch (NoSuchElementException e) {
			System.out.println("Element by"+xpath+ "is not found");
		}
		finally{
			CaptureScreenshot();
		}
	}
	
	public String getTextbyId(String id){
		String txt=null;
		try {
			txt=driver.findElementById(id).getText();
		} catch (Exception e) {
			System.out.println("Element by"+id+ "is not found");
		}
		finally{
			CaptureScreenshot();
		}
		return txt;
		}
	public String getTextbyClassname(String Classname){
		String txt=null;
		try {
			driver.findElementByClassName(Classname).getText();
		} catch (NoSuchElementException e) {
			System.out.println("Element by classname"+Classname+ "is not found");
		}
		finally{
			CaptureScreenshot();
		}
		return txt;
	}
	public String getTextbyname(String name){
		String txt=null;
		try {
			driver.findElementByName(name).getText();
		} catch (NoSuchElementException e) {
			System.out.println("Element by classname"+name+ "is not found");
		}
		finally{
			CaptureScreenshot();
		}
		return txt;
	}
	public String getTextbyXpath(String xpath){
		String txt=null;
		try {
			driver.findElementByXPath(xpath).getText();
		} catch (NoSuchElementException e) {
			System.out.println("Element by classname"+xpath+ "is not found");
		}
		finally{
			CaptureScreenshot();
		}
		return txt;
	}
	public String getTextbyLinktext(String linktext){
		String txt=null;
		try {
			driver.findElementByLinkText(linktext).getText();
		} catch (NoSuchElementException e) {
			System.out.println("Element by classname"+linktext+ "is not found");
		}
		finally{
			CaptureScreenshot();
		}
		return txt;
	}
	public String getTextbyTagname(String tagname){
		String txt=null;
		try {
			driver.findElementByLinkText(tagname).getText();
		} catch (NoSuchElementException e) {
			System.out.println("Element by classname"+tagname+ "is not found");
		}
		finally{
			CaptureScreenshot();
		}
		return txt;
	}
	
	public boolean VerifycurrentURL(String url){
		boolean flag=false;
		try {
			
			if(driver.getCurrentUrl().equals(url)){
				System.out.println("The URL matches");
				return true;
			}
			
			else{
				System.out.println("The URL doesn't match");
				return false;
			}
		} catch (Exception e) {
			System.out.println("URL is not verified");
		}
		finally{
			CaptureScreenshot();
		}
		return flag;
	}
	public boolean VerifyTitle(String Title){
		boolean flag=false;
		try {
			
			if(driver.getTitle().equals(Title)){
				System.out.println("The Title matches");
				return true;
			}
			
			else{
				System.out.println("The Title doesn't match");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Title is not verified");
		}
		finally{
			CaptureScreenshot();
		}
		return flag;
	}
	public boolean VerifyText(String Str1,String Str2){
		boolean flag=false;
		try {
			
			if(Str1.equals(Str2)){
				System.out.println("The Text matches");
				return true;
			}
			
			else{
				System.out.println("The Text doesn't match");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Text is not verified");
		}
		finally{
			CaptureScreenshot();
		}
		return flag;
	}
	
	
	public void clickbyid (String id)
	{
		try {
			driver.findElementById(id).click();
		} catch (NoSuchElementException e) {
			System.out.println("Element by"+id+ "is not found");
		}
		finally{
			CaptureScreenshot();
		}
	}

	public void clickbylinktext(String linktext)
	{
		try {
			driver.findElementByLinkText(linktext).click();
		} catch (NoSuchElementException e) {
			System.out.println("Element by"+linktext+ "is not found");
		}
		finally{
			CaptureScreenshot();
		}
	}

	public void clickbyclass(String classname)
	{
		try {
			driver.findElementByClassName(classname).click();
		} catch (NoSuchElementException e) {
			System.out.println("Element by"+classname+ "is not found");
		}
		finally{
			CaptureScreenshot();
		}
	}
	
	public void clickbyname(String name)
	{
		try {
			driver.findElementByName(name).click();
		} catch (NoSuchElementException e) {
			System.out.println("Element by"+name+ "is not found");
		}
		finally{
			CaptureScreenshot();
		}
	}
	
	public void clickbyxpath(String xpath)
	{
		try {
			driver.findElementByXPath(xpath).click();
		} catch (NoSuchElementException e) {
			System.out.println("Element by"+xpath+ "is not found");
		}
		finally{
			CaptureScreenshot();
		}
	}
	
	public void clickbytagname(String tagname)
	{
		try {
			driver.findElementByTagName(tagname).click();
		} catch (NoSuchElementException e) {
			System.out.println("Element by"+tagname+ "is not found");
		}
		finally{
			CaptureScreenshot();
		}
	}
	
		public void dropdownselectByIdByIndex(String id,int index){
			try {
				Select dropdown = new Select(driver.findElementById(id));
				dropdown.selectByIndex(index);
			} catch (NoSuchElementException  e) {
				// TODO Auto-generated catch block
				System.out.println("Element by" +id+ "is not found");
			}
			finally{
				CaptureScreenshot();
			}
		}
		public void dropdownselectByIdByValue(String id,String value){
			try {
				Select dropdown = new Select(driver.findElementById(id));
				dropdown.selectByValue(value);
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println("Element by" +id+ "is not found");
			}
			finally{
				CaptureScreenshot();
			}
		}
		public void dropdownselectByIdbyVisibletext(String id,String visibletext){
			try {
				Select dropdown = new Select(driver.findElementById(id));
				dropdown.selectByVisibleText(visibletext);
				//dropdown.selectByIndex(visibleText);
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println("Element by" +id+ "is not found");
			}
			finally{
				CaptureScreenshot();
			}
		}
		
		public void dropdownselectByNameByIndex(String name,int index){
			try {
				Select dropdown = new Select(driver.findElementByName(name));
				dropdown.selectByIndex(index);
			} catch (NoSuchElementException  e) {
				// TODO Auto-generated catch block
				System.out.println("Element by" +name+ "is not found");
			}
			finally{
				CaptureScreenshot();
			}
		}
		public void dropdownselectByNameByValue(String name,String value){
			try {
				Select dropdown = new Select(driver.findElementByName(name));
				dropdown.selectByValue(value);
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println("Element by" +name+ "is not found");
			}
			finally{
				CaptureScreenshot();
			}
		}
		public void dropdownselectByNameByVisibletext(String name,String visibletext){
			try {
				Select dropdown = new Select(driver.findElementByName(name));
				dropdown.selectByValue(visibletext);
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println("Element by" +name+ "is not found");
			}
			finally{
				CaptureScreenshot();
			}
		}
		
	
	public String CaptureScreenshot(){
		String path="./Snapshot/"+snapcount+".jpeg";
		try {
			
			File srcfile=driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile, new File (path));
			snapcount++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to capture screenshot");
		}
	  return path;
	}
	  public String getTextbyvalue(String value){
			String txt=null;
			try {
				driver.findElementByName(value).getText();
			} catch (NoSuchElementException e) {
				System.out.println("Element by classname"+value+ "is not found");
			}
			finally{
				CaptureScreenshot();
			}
			return txt;
			
	
	}
	  public String getAttributebyId(String value){
		  String txt=null;
		  try {
			  driver.findElementById(value).getAttribute(value);
			  } 
		  catch (NoSuchElementException e)
		  	{
				System.out.println("Element by classname"+value+ "is not found");
			}
			finally{
				CaptureScreenshot();
			}
			return txt;
	  }
	

}
