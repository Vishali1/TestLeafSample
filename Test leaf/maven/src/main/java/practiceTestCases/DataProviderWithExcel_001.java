package practiceTestCases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.ExcelUtils;


public class DataProviderWithExcel_001 {

	WebDriver driver;
	 
    @BeforeMethod

    public void beforeMethod() throws Exception {

	    driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

        	 driver.get("http://demo1.opentaps.org");
        	

	}
    
    @Test(dataProvider="CLead")
    
    public void CreateLead(String Username,String Password, String FirstName, String LastName, String Company)throws  Exception{
  
        driver.findElement(By.id("username")).sendKeys(Username);
    	System.out.println(Username);
 
        driver.findElement(By.id("password")).sendKeys(Password);
 
        System.out.println(Password);
		
        driver.findElement(By.className("decorativeSubmit")).click();
 
      System.out.println("Successfully logged in");
      	
      	driver.findElement(By.linkText("CRM/SFA")).click();
      	
      	driver.findElement(By.linkText("Create Lead")).click();
      	
      	driver.findElement(By.id("createLeadForm_companyName")).sendKeys(Company);
      	
      //Enter the First name
      	driver.findElement(By.id("createLeadForm_firstName")).sendKeys(FirstName);
      	//Enter the Last name
      	driver.findElement(By.id("createLeadForm_lastName")).sendKeys(LastName);
      	
      //Click 'Create Lead' 
    	driver.findElement(By.name("submitButton")).click();
    	
    	//View the Created name of the lead
    	System.out.println(driver.findElement(By.id("viewLead_firstName_sp")).getText());
      	driver.close();
		}
    
    
    @Test(dependsOnMethods="CreateLead",dataProvider="ELead")
    public void EditLead(String Username,String Password) throws InterruptedException{
    	 driver.findElement(By.id("username")).sendKeys(Username);
     	System.out.println(Username);
  
         driver.findElement(By.id("password")).sendKeys(Password);
  
         System.out.println(Password);
 		
         driver.findElement(By.className("decorativeSubmit")).click();
  
       System.out.println("Successfully logged in");
       	
       	driver.findElement(By.linkText("CRM/SFA")).click();
      //Click on leads link
      	driver.findElement(By.linkText("Leads")).click();
      //Click on Find leads
      		driver.findElement(By.linkText("Find Leads")).click();
      	
        driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
        
        driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
        
        Thread.sleep(3000);
        
        driver.findElement(By.linkText("Edit")).click();    
        
        driver.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();
        
       // (//input[@name='submitButton'])[1]
        
        driver.close();
    }
    
    public void MergeLead(String Username,String Password,String LeadId) throws InterruptedException{
   	 driver.findElement(By.id("username")).sendKeys(Username);
    	System.out.println(Username);
 
        driver.findElement(By.id("password")).sendKeys(Password);
 
        System.out.println(Password);
		
        driver.findElement(By.className("decorativeSubmit")).click();
 
      System.out.println("Successfully logged in");
      	
      	driver.findElement(By.linkText("CRM/SFA")).click();
     //Click on leads link
     	driver.findElement(By.linkText("Leads")).click();
     	
     	
     	//Click on leads link
     			driver.findElement(By.linkText("Leads")).click();
     			
     		//Click on Merge leads
     			driver.findElement(By.linkText("Merge Leads")).click();
     			
     	String parentWindow=driver.getWindowHandle();
     			
     		//Click From lead icon
     			driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();
     		
     		//Switch to new window1
     			Set<String> handles =driver.getWindowHandles();
     			
     			for(String childwindow : handles)
     			{		
     		driver.switchTo().window(childwindow);
     			
     		}
     			
     		//Type Lead ID
     	driver.findElement(By.xpath("(//input[@type='text'])")).sendKeys(LeadId);

     	//Click find leads

     	driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();

     	//Click on the first lead (note: automatically the second window will close)

     	//driver.findElementByXPath("//*class[@linktext='10000']").click();

     	driver.findElement(By.xpath("(//a[@class='linktext'])")).click();

     	//Switches to parent window
     	driver.switchTo().window(parentWindow);

     	//Click on merge button
     	driver.findElement(By.linkText("Merge")).click();

     	System.out.println(driver.switchTo().alert().getText());

     	}
    @DataProvider
    public Object[][] CLead() throws Exception{
 
         Object[][] testObjArray = ExcelUtils.readExcel("Lead");
		return testObjArray;
    }
    
    @DataProvider
	public Object[][] ELead() throws Exception{
		Object[][] testObjArray= ExcelUtils.readExcel("ELead");
		return testObjArray;
	}
		
    @DataProvider
   	public Object[][] MLead() throws Exception{
   		Object[][] testObjArray= ExcelUtils.readExcel("MLead");
   		return testObjArray;
   	}
    
}
