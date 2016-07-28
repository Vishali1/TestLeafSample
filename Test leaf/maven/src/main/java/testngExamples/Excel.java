package testngExamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel {

	@Test
	public void ExcelSheet() throws IOException{
		
		FileInputStream fis= new FileInputStream(new File("./data/OpentapsExcel.xlsx"));
		XSSFWorkbook wbook=new XSSFWorkbook(fis);
		
		XSSFSheet Sheet=wbook.getSheetAt(0);
		int rowCount=Sheet.getLastRowNum();
		for (int i = 1; i <=rowCount; i++) {
			XSSFRow Row1 = Sheet.getRow(i);
			XSSFCell Cell1 = Row1.getCell(0);
			System.out.println(Cell1.getStringCellValue());
			
		}
		
		wbook.close();
	}
}
