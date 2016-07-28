package testngExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Amazon {

	@Test
	public void amazon() {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.in/s/ref=nb_sb_noss_1?url=search-alias%3Daps&field-keywords=bags");
		driver.manage().window().maximize();

		// Implicit wait(Default Timeout)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//driver.findElementByXPath("//div[@class='a-fixed-left-grid-inner']/preceeding.sibling::div").click();
		
		//driver.findElementByXPath("//li[@id='result_3']/preceeding.sibling::li").click();
		
		//driver.findElementByXPath("//a[@class='a-link-normal s-access-detail-page  a-text-normal']/preceeding.sibling::a").click();
		//driver.findElementByXPath("//div[@class='a-fixed-left-grid-inner']/preceeding::div[1]").click();
		//driver.findElementByXPath("//div[@class='a-row a-spacing-none']/preceeding.sibling::div").click();
		driver.findElementByXPath("//li[@id='result_3']/preceeding.sibling::li[3]").click();
		
	}
}
