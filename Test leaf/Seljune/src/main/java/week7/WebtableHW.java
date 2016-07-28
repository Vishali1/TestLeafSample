package week7;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebtableHW {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		// Navigate to the url
		driver.get("http://erail.in/");

		// Maximize the browser
		driver.manage().window().maximize();

		// Set default waiting time for finding an element (after the page
		// loads)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Enter Origin
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("txtStationFrom")));
		driver.findElementById("txtStationFrom").clear();
		driver.findElementById("txtStationFrom").sendKeys("MAS", Keys.TAB);

		// Enter Destination
		driver.findElementById("txtStationTo").clear();
		driver.findElementById("txtStationTo").sendKeys("MYS", Keys.TAB);

		// To locate table.
		WebElement table = driver.findElementByXPath("//div[@id='divTrainsList']/table[1]");

		// To locate rows of table.
		List<WebElement> rows_table = table.findElements(By.tagName("tr"));

		// To calculate no of rows In table.
		int rows_count = rows_table.size();

		// Loop will execute till the last row of table.
		for (int row = 0; row < rows_count; row++) {

			// To locate columns(cells) of that specific row.
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));

			// To calculate no of columns(cells) In that specific row.
			int columns_count = Columns_row.size();
			System.out.println("Number of cells In Row " + row + " are " + columns_count);

			// Loop will execute till the last cell of that specific row.
			for (int column = 0; column < columns_count; column++) {

				if (column == 0) {
					// To retrieve text from that specific cell.
					String celtext = Columns_row.get(column).getText();

					System.out.println("Row number " + row + " Train number is " + celtext);
					
					
				} else {
					break;
				}
			}
		}
		driver.close();
	}
}
