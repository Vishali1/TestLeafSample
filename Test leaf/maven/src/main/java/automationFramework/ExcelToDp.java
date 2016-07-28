package automationFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ExcelToDp {
	
	public WebDriver driver;
	public WebDriverWait wait;
	//String appURL = "http://demo1.opentaps.org/";
	
	//Locators
	private By byUser = By.id("username");
	private By byPassword = By.id("password");
	private By bySubmit = By.className("decorativeSubmit");
	
	
	
	@BeforeTest
	public void testSetup() {
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
		//driver.get(appURL);
		
	}
		//Check for error message
	
	
	public Object[][] readExcel(String fileName) throws IOException {

		// Read the file
		FileInputStream fis = new FileInputStream(new File("./data/"+fileName+".xlsx"));
		@SuppressWarnings("resource")
		XSSFWorkbook wbook = new XSSFWorkbook(fis);

		// go to first sheet
		XSSFSheet sheet = wbook.getSheetAt(0);

		// get the row count
		int rowCount = sheet.getLastRowNum();
		int colCount= sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[rowCount][colCount];
		for (int i = 1; i <=rowCount; i++) {

			// go to the row
			XSSFRow row1 = sheet.getRow(i);
			
			for (int j = 0; j < colCount; j++) {

				// go to the cell 1
				XSSFCell cell1 = row1.getCell(j);
				// print the content of the cell
				//System.out.println(cell1.getStringCellValue());
				obj[i-1][j]=cell1.getStringCellValue();
			}

		}
		return obj;


	}
	
	@Test(dataProvider="Opentapslogin")
	public void VerifyLogin(String userName, String password) {
		driver.get("http://demo1.opentaps.org/");
		driver.findElement(byUser).sendKeys(userName);
		driver.findElement(byPassword).sendKeys(password);
		//wait for element to be visible and perform click
		wait.until(ExpectedConditions.visibilityOfElementLocated(bySubmit));
		driver.findElement(bySubmit).click();
	}
	@DataProvider(name = "excelData")
	public Object[][] excelData() throws IOException {
		return readExcel("Lead");
		//return new Object[][] {{"DemoSalesManager", "crmsfa"}, {"DemoCSR",
		//"crmsfa"}};

	}

	@Test(dataProvider = "excelData", enabled = true)
	public void fromExcelToDp(String Url,String username, String password, String Name,String LastName, String company) {
	driver.get(Url);
		System.out.println(username);
		System.out.println(password);
		System.out.println(company);

	}
}
