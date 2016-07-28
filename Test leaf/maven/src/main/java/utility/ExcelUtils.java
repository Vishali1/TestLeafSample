package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelUtils {
	

	public static Object[][] readExcel(String fileName) throws IOException {

		// Read the file
		FileInputStream fis = new FileInputStream(new File("./data/"+fileName+".xlsx"));
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
	@DataProvider(name = "excelData")
	public Object[][] excelData() throws IOException {
		//ChromeDriver driver = new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		//driver.get("http://demo1.opentaps.org");
		
		
		//Maximise Chrome
		//driver.manage().window().maximize();
		
		//Implicit wait(Default Timeout)
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return readExcel("Lead");
		//return new Object[][] {{"DemoSalesManager", "crmsfa"}, {"DemoCSR",
		//"crmsfa"}};
		
		//return readExcel("ELead");
	}
	@DataProvider(name = "excelData")
	public Object[][] excelData2() throws IOException {
		//ChromeDriver driver = new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		//driver.get("http://demo1.opentaps.org");
		
		
		//Maximise Chrome
		//driver.manage().window().maximize();
		
		//Implicit wait(Default Timeout)
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return readExcel("ELead");
		//return new Object[][] {{"DemoSalesManager", "crmsfa"}, {"DemoCSR",
		//"crmsfa"}};
		
		//return readExcel("ELead");
	}
	
	@DataProvider(name = "excelData")
	public Object[][] excelData3() throws IOException {
		
		
		return readExcel("MLead");
	}
	@Test(dataProvider = "excelData", enabled = true)
	public void fromExcelCLead(String Username, String Password, String FirstName,String LastName, String Company) {

		System.out.println(Username);
		System.out.println(Password);
		System.out.println(Company);

	}
	@Test(dataProvider = "excelData2", enabled = true)
	public void fromExcelELead(String Username, String Password) {

		System.out.println(Username);
		System.out.println(Password);
		

	}
	
	@Test(dataProvider = "excelData3", enabled = true)
	public void fromExcelMLead(String Username, String Password, String LeadId) {

		System.out.println(Username);
		System.out.println(Password);
		System.out.println(LeadId);
		

	}
}