package testngExamples;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class WrapperClass_v4 {
	
	int snapcount = 1;
	public static RemoteWebDriver driver=null;
	String parentwindow = null;
	/**
	 * This method will launch the broswer,get the URL,maximize the window and implicitly wait to locate the webelement
	 * @param Url
	 * @param browser
	 */
	@Parameters({ "browser" })
	@BeforeClass
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
    /**
     * This method will close the current application running in the browser
     */
	public void closeapp() {
		try {
			driver.close();
			System.out.println("Current application is closed");
		}
			catch(UnreachableBrowserException e){
				System.out.println("Could not reach browser");
		} catch (Exception e) {
			System.out.println("Unable to close the application");
		}
	}
	/**
	 * This method will enter the text in the webelement textbox which is located by id
	 * @param id
	 * @param value
	 */

	public void enterTextbyID(String id, String value) {
		try {
			driver.findElementById(id).sendKeys(value);
			System.out.println("Found the element by" +id);
		} 
		catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			System.out.println("Element by" + id + "is not found");
		} finally {
			CaptureScreenshot();
		}
	}
    /**
     * This method will enter the text in the webelement textbox which is located by classname
     * @param classname
     * @param value
     */
	public void enterTextByClassname(String classname, String value) {
		try {
			driver.findElementByClassName(classname).sendKeys(value);
			System.out.println("Found the element by" +classname);
			
		} catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			System.out.println("Element by" + classname + "is not found");
		} finally {
			CaptureScreenshot();
		}
	}
	/**
	 * This method will enter the text in the webelement textbox which is located by name
	 * @param Name
	 * @param value
	 */

	public void enterTextByName(String Name, String value) {
		try {
			driver.findElementByName(Name).sendKeys(value);
			System.out.println("Found the element by" +Name);
		} 
		catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			System.out.println("Element by" + Name + "is not found");
		} 
		finally {
			CaptureScreenshot();
		}
	}

	/**
	 * This method will enter the text in the webelement textbox which is located by xpath
	 * @param xpath
	 * @param value
	 */
	public void enterTextByXpath(String xpath, String value) {
		try {
			driver.findElementByXPath(xpath).sendKeys(value);
			System.out.println("Found the element by" +xpath);
		} 
		catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			System.out.println("Element by" + xpath + "is not found");
		} finally {
			CaptureScreenshot();
		}
	}
  /**
   * This method will verify the text located by the ID with the string to compare
   * @param id
   * @param strToCmpr
   * @return
   */
	
   public boolean VerifyTextById(String id, String strToCmpr) {
		boolean flag = false;
		try {
			String strFrmSys = driver.findElementById(id).getText();
			if (strFrmSys.equals(strToCmpr)) {
				System.out.println("Text obtained from system: " + strFrmSys + " exactly matches with " + strToCmpr);
				flag = true;
			} else {
				System.out.println("Text obtained from system: " + strFrmSys + " does not match with " + strToCmpr);
			}
		} catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			System.out.println("Element " + id + "is not found");
		} 
		return flag;
	}
   /**
    * This method will verify the text located by classname with the string to compare
    * @param classname
    * @param strToCmpr
    * @return
    */
   
   public boolean VerifyTextByClassName(String classname, String strToCmpr) {
		boolean flag = false;
		try {
			String strFrmSys = driver.findElementById(classname).getText();
			if (strFrmSys.equals(strToCmpr)) {
				System.out.println("Text obtained from system: " + strFrmSys + " exactly matches with " + strToCmpr);
				flag = true;
			} else {
				System.out.println("Text obtained from system: " + strFrmSys + " does not match with " + strToCmpr);
			}
		} catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			System.out.println("Element " + classname + "is not found");
		} 
		return flag;
	}
   /**
    * This method will verify the text located by linktext with the string to compare
    * @param linktext
    * @param strToCmpr
    * @return flag
    */
   public boolean VerifyTextByLinkText(String linktext, String strToCmpr) {
		boolean flag = false;
		try {
			String strFrmSys = driver.findElementById(linktext).getText();
			if (strFrmSys.equals(strToCmpr)) {
				System.out.println("Text obtained from system: " + strFrmSys + " exactly matches with " + strToCmpr);
				flag = true;
			} else {
				System.out.println("Text obtained from system: " + strFrmSys + " does not match with " + strToCmpr);
			}
		} 
		catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			System.out.println("Element " + linktext + "is not found");
		} 
		return flag;
	}
   /**
    * This method will verify the text located by name with the string to compare
    * @param name
    * @param strToCmpr
    * @return flag
    */
   public boolean VerifyTextByName(String name, String strToCmpr) {
		boolean flag = false;
		try {
			String strFrmSys = driver.findElementById(name).getText();
			if (strFrmSys.equals(strToCmpr)) {
				System.out.println("Text obtained from system: " + strFrmSys + " exactly matches with " + strToCmpr);
				flag = true;
			} else {
				System.out.println("Text obtained from system: " + strFrmSys + " does not match with " + strToCmpr);
			}
		} 
		catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			System.out.println("Element " + name + "is not found");
		} 
		return flag;
	}
   /**
    * This method will verify the text located by Xpath with the string to compare
    * @param xpath
    * @param strToCmpr
    * @return flag
    */
   public boolean VerifyTextByXpath(String xpath, String strToCmpr) {
		boolean flag = false;
		try {
			String strFrmSys = driver.findElementById(xpath).getText();
			if (strFrmSys.equals(strToCmpr)) {
				System.out.println("Text obtained from system: " + strFrmSys + " exactly matches with " + strToCmpr);
				flag = true;
			} else {
				System.out.println("Text obtained from system: " + strFrmSys + " does not match with " + strToCmpr);
			}
		} catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			System.out.println("Element " + xpath + "is not found");
		} 
		return flag;
	}
   /**
    * This method will verify the text partially by locating it by id with the string to compare
    * @param id
    * @param string1
    * @return flag
    */
	public boolean getandVerifyPartialTextById(String id, String strToCmpr) {
		boolean flag = false;
		try {
			String strFrmSys = driver.findElementById(id).getText();
			if (strFrmSys.contains(strToCmpr)) {
				System.out.println("Text obtained from system: " + strFrmSys + " contains " + strToCmpr);
				flag = true;
			} else {
				System.out.println("Text obtained from system: " + strFrmSys + " does not contain " + strToCmpr);
			}
		} 
		catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			System.out.println("Element " + id + "is not found");
		} 
		return flag;
	}
	/**
	 * This method will return the text which is located by id
	 * @param id
	 * @return txt
	 */

	public String getTextById(String id) {
		String txt = null;
		try {
			txt = driver.findElementById(id).getText();
			System.out.println("The text is" +txt);
		} 
		catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			System.out.println("Element by" + id + "is not found");
		} finally {
			CaptureScreenshot();
		}
		return txt;
	}
	/**
	 * This method will return the text which is located by name
	 * @param name
	 * @return txt
	 */

	public String getTextByName(String name) {
		String txt = null;
		try {
			txt = driver.findElementByName(name).getText();
			System.out.println("The text is" +txt);
		} 
		catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			System.out.println("Element by classname" + name + "is not found");
		} finally {
			CaptureScreenshot();
		}
		return txt;
	}
	/**
	 * This method will return the text which is located by xpath
	 * @param xpath
	 * @return txt
	 */

	public String getTextbyXpath(String xpath) {
		String txt = null;
		try {
			txt = driver.findElementByXPath(xpath).getText();
			System.out.println("The text is" +txt);
		} catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			System.out.println("Element by classname" + xpath + "is not found");
		} finally {
			CaptureScreenshot();
		}
		return txt;
	}
	/**
	 * This method will return the text which is located by linktext
	 * @param linktext
	 * @return txt
	 */

	public String getTextByLinkText(String linktext) {
		String txt = null;
		try {
			txt = driver.findElementByLinkText(linktext).getText();
			System.out.println("The text is" +txt);
		} catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			System.out.println("Element by classname" + linktext + "is not found");
		} finally {
			CaptureScreenshot();
		}
		return txt;
	}
	/**
	 * This method will return the text that s located by tagname
	 * @param tagname
	 * @return
	 */

	public String getTextbyTagname(String tagname) {
		String txt = null;
		try {
			txt = driver.findElementByLinkText(tagname).getText();
			System.out.println("The text is" +txt);
		} catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		
		catch (NoSuchElementException e) {
			System.out.println("Element by classname" + tagname + "is not found");
		} finally {
			CaptureScreenshot();
		}
		return txt;
	}
	/**
	 * This method will verify the current URL
	 * @param url
	 * @return boolean
	 */

	public boolean VerifycurrentURL(String url) {
		boolean flag = false;
		try {
             
			if (driver.getCurrentUrl().equals(url)) {
				System.out.println("The URL matches");
				return true;
			}

			else {
				System.out.println("The URL doesn't match");
				return false;
			}
		} catch (Exception e) {
			System.out.println("URL is not verified");
		} finally {
			CaptureScreenshot();
		}
		return flag;
	}
	/**
	 * This method will verify the Title
	 * @param Title
	 * @return boolean
	 */

	public boolean VerifyTitle(String Title) {
		boolean flag = false;
		try {

			if (driver.getTitle().equals(Title)) {
				System.out.println("The Title matches");
				return true;
			}

			else {
				System.out.println("The Title doesn't match");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Title is not verified");
		} finally {
			CaptureScreenshot();
		}
		return flag;
	}
    /**
     * This method will locate the webelement by ID and click it
     * @param id
     */
	
	public void clickById(String id) {
		try {
			driver.findElementById(id).click();
			System.out.println("Element by" +id+ "is found and clicked");
		} catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			System.out.println("Element by" + id + "is not found");
		} finally {
			CaptureScreenshot();
		}
	}
	/**
	 * This method will locate the webelement by linktext and click it
	 * @param linktext
	 */

	public void clickByLinkText(String linktext) {
		try {
			driver.findElementByLinkText(linktext).click();
			System.out.println("Element by" +linktext+ "is found and clicked");
		} catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			System.out.println("Element by" + linktext + "is not found");
		} finally {
			CaptureScreenshot();
		}
	}
	/**
	 * This method will locate the webelement by Classname and click it
	 * @param classname
	 */

	public void clickByClass(String classname) {
		try {
			driver.findElementByClassName(classname).click();
			System.out.println("Element by" +classname+ "is found and clicked");
		} catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			System.out.println("Element by" + classname + "is not found");
		} finally {
			CaptureScreenshot();
		}
	}
	/**
	 * This method will locate the webelement by name and click it
	 * @param name
	 */

	public void clickbyname(String name) {
		try {
			driver.findElementByName(name).click();
			System.out.println("Element by" +name+ "is found and clicked");
		} catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			System.out.println("Element by" + name + "is not found");
		} finally {
			CaptureScreenshot();
		}
	}
	
	/**
	 * This method will locate the webelement by xpath and click it
	 * @param xpath
	 */

	public void clickByXpath(String xpath) {
		try {
			driver.findElementByXPath(xpath).click();
			System.out.println("Element by" +xpath+ "is found and clicked");
		} catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			System.out.println("Element by" + xpath + "is not found");
		} finally {
			CaptureScreenshot();
		}
	}
	/**
	 * This method will locate the webelement by tagname and click it
	 * @param tagname
	 */

	public void clickByTagname(String tagname) {
		try {
			driver.findElementByTagName(tagname).click();
			System.out.println("Element by" +tagname+ "is found and clicked");
		} catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			System.out.println("Element by" + tagname + "is not found");
		} finally {
			CaptureScreenshot();
		}
	}
	
	/**
	 * This method will locate the dropdown by ID and select by index
	 * @param id
	 * @param index
	 */

	public void dropdownSelectByIdByIndex(String id, int index) {
		try {
			Select dropdown = new Select(driver.findElementById(id));
			dropdown.selectByIndex(index);
			System.out.println("Element by" +id+ "using index is found and selected");
		} catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element by" + id + "is not found");
		} finally {
			CaptureScreenshot();
		}
	}

	/**
	 * This method will locate the dropdown by ID and select by value
	 * @param id
	 * @param value
	 */
	public void dropdownSelectByIdByValue(String id, String value) {
		try {
			Select dropdown = new Select(driver.findElementById(id));
			dropdown.selectByValue(value);
			System.out.println("Element by" +id+ "using value is found and selected");
		} catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element by" + id + "is not found");
		} finally {
			CaptureScreenshot();
		}
	}

	/**
	 * This method will locate the dropdown by ID and select by visible text
	 * @param id
	 * @param visibletext
	 */
	public void dropdownSelectByIdByVisibletext(String id, String visibletext) {
		try {
			Select dropdown = new Select(driver.findElementById(id));
			dropdown.selectByVisibleText(visibletext);
			System.out.println("Element by" +id+ "using visibletext is found and selected");
		} catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element by" + id + "is not found");
		} finally {
			CaptureScreenshot();
		}
	}

	/**
	 * 
	 * This method will locate the dropdown by name and select by index
	 * @param name
	 * @param index
	 */
	public void dropdownSelectByNameByIndex(String name, int index) {
		try {
			Select dropdown = new Select(driver.findElementByName(name));
			dropdown.selectByIndex(index);
			System.out.println("Element by" +name+ "using index is found and selected");
		} catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element by" + name + "is not found");
		} finally {
			CaptureScreenshot();
		}
	}

	/**
	 * This method will locate the dropdown by name and select by value
	 * 
	 * @param name
	 * @param value
	 */
	public void dropdownSelectByNameByValue(String name, String value) {
		try {
			Select dropdown = new Select(driver.findElementByName(name));
			dropdown.selectByValue(value);
			System.out.println("Element by" +name+ "using value is found and selected");
		} catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element by" + name + "is not found");
		} finally {
			CaptureScreenshot();
		}
	}
	
	/**
	 *This method will locate the dropdown by name and select by visible text 
	 *
	 * @param name
	 * @param visibletext
	 */

	public void dropdownselectByNameByVisibletext(String name, String visibletext) {
		try {
			Select dropdown = new Select(driver.findElementByName(name));
			dropdown.selectByVisibleText(visibletext);
			System.out.println("Element by" +name+ "using visibletext is found and selected");
		} catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element by" + name + "is not found");
		} finally {
			CaptureScreenshot();
		}
	}
	/**
	 * This method will switch to the parentwindow
	 * 
	 */

	public void switchToParentwindow() {
		try {
			driver.switchTo().window(parentwindow);
			System.out.println("Switched to the Parent window");
		} catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.out.println("Window is already closed");
		} finally {
			CaptureScreenshot();
		}
	}
	/**
	 * This method will switch to the last window using foreach loop
	 * 
	 */

	public void switchtolastwindow() {

		try {
			Set<String> whandles = driver.getWindowHandles();
			// System.out.println("Number of windows:"+whandles.size());
			for (String handle : whandles) {
				driver.switchTo().window(handle);
				}
			System.out.println("Switched to the last window");
		} 
		catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.out.println("No such window found");
		} finally {
			CaptureScreenshot();
		}
	}

	/**
	 * This method will swtch to an alert and accept / dismiss based on the input
	 *  @param condition -  Accept or any
	 * 
	 * 
	 */
	public void switchToAlert(String condition) {
		try {
			if (condition.equalsIgnoreCase("accept")) {
				driver.switchTo().alert().accept();
				System.out.println("Alert accepted");
			} else {
				driver.switchTo().alert().dismiss();
				System.out.println("Alert dismissed");
			}
		} catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (UnhandledAlertException e) {
			// TODO Auto-generated catch block
			System.out.println("No such alert is found");
		} finally {
			CaptureScreenshot();
		}

	}
	/**
	 * This method will extract the Integer from the String value
	 * 
	 * @param xpath
	 * @return string
	 */
	public String getIntegerFromStringByXpath(String xpath) {
		String txt = null;
		try {
			txt = driver.findElementByXPath(xpath).getText();
			String result = null;
			int length = txt.length();
			for (int i = 0; i < length; i++) {
				Character character = txt.charAt(i);
				if (Character.isDigit(character)) {
					result += character;
				}
			}
			txt = result;
			
		} 
		catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}catch (NoSuchElementException e) {
			System.out.println("Element by" + xpath + "is not found");
		} finally {
			CaptureScreenshot();
		}
		return txt;
	}

	/**
	 * This method will capture the screenshot
	 * 
	 */

	public void CaptureScreenshot() {

		try {

			File srcfile = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile, new File("./Snapshot/" + snapcount + ".jpeg"));
			snapcount++;
		} catch(UnreachableBrowserException e){
			System.out.println("Could not reach browser");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to capture screenshot");
		}

	}

}
