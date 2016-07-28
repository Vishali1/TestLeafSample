package testngExamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Excel_HW_Opentaps
{
	@Test
	public void OpentapsExcel() throws IOException{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://demo1.opentaps.org");
		
		//Maximise Chrome
		driver.manage().window().maximize();
		
		//Implicit wait(Default Timeout)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		FileInputStream fis=new FileInputStream(new File("./data/OpentapsExcel.xlsx"));
		XSSFWorkbook wbook=new XSSFWorkbook(fis);
		
		XSSFSheet Sheet=wbook.getSheetAt(0);
		int rowCount=Sheet.getLastRowNum();
		
		for (int i = 1; i <=rowCount; i++) {
			XSSFRow Row1 = Sheet.getRow(i);
			XSSFCell Cell1 = Row1.getCell(0);
			
			String Username=Cell1.getStringCellValue();
			driver.findElement(By.id("username")).sendKeys(Username);
			System.out.println("Username has been entered");
			
			XSSFCell Cell2 = Row1.getCell(1);
			String Password=Cell2.getStringCellValue();
			driver.findElementById("password").sendKeys(Password);
			
			driver.findElementByClassName("decorativeSubmit").click();	
			driver.findElement(By.linkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Create Lead")).click();
			
			XSSFCell Cell3=Row1.getCell(2);
			String Firstname=Cell3.getStringCellValue();
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(Firstname);
			
			
			XSSFCell Cell4=Row1.getCell(3);
			String Lastname=Cell4.getStringCellValue();
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(Lastname);
			
			
			XSSFCell Cell5=Row1.getCell(4);
			String Email_Id=Cell5.getStringCellValue();
			
			
			XSSFCell Cell6=Row1.getCell(5);
			String CompanyName=Cell6.getStringCellValue();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(CompanyName);
			
			driver.findElement(By.name("submitButton")).click();
		}
		
//driver.findElement(By.id("username")).sendKeys("UsernameCell1");
		
		//Enter Password
		//driver.findElementById("password").sendKeys("crmsfa");
		
		//Click LoginButton
		//driver.findElementByClassName("decorativeSubmit").click();	
		
	//Click on link CRM/SFA (below the big orange button/image)
		//driver.findElement(By.linkText("CRM/SFA")).click();
		
	//Click on 'Create Lead' on the side panel(Use link text)
		//driver.findElement(By.linkText("Create Lead")).click();
		
	//Fill all the mandatory fields	
		
	//Enter the company name
		//driver.findElement(By.id("createLeadForm_companyName")).sendKeys("RNTBCI");
	
	//Enter the First name
		//driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Vishali");
	//Enter the Last name
		//driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Kadali");
    //Click 'Create Lead' 
	//driver.findElement(By.name("submitButton")).click();
		
		}
}
