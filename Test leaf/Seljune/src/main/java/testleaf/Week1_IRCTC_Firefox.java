package testleaf;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Week1_IRCTC_Firefox {

	public static void main(String[] args) throws InterruptedException {
		
		FirefoxDriver driver = new FirefoxDriver();
		
		// TODO Auto-generated method stub
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.findElementById("userRegistrationForm:userName").sendKeys("Arul");
		driver.findElementById("userRegistrationForm:password").sendKeys("Abcd1234");
		driver.findElementById("userRegistrationForm:confpasword").sendKeys("Abcd1234");
		Select dropdown = new Select(driver.findElementById("userRegistrationForm:securityQ"));
		List<WebElement> allOptions = dropdown.getOptions();
		int lastIndexValue = allOptions.size()-1;
		dropdown.selectByIndex(lastIndexValue);
		System.out.println(allOptions.get(0).getText());
		driver.findElementById("userRegistrationForm:securityAnswer").sendKeys("Italy");
		driver.findElementById("userRegistrationForm:firstName").sendKeys("Dell");
		driver.findElementById("userRegistrationForm:lastName").sendKeys("Italy");
		driver.findElementById("userRegistrationForm:gender:1").click();
		driver.findElementById("userRegistrationForm:maritalStatus:1").click();
		//select Day
		Select dropdown1= new Select(driver.findElementById("userRegistrationForm:dobDay"));
		List<WebElement> selectDate= dropdown1.getOptions();
		int selectDay= selectDate.size()-1;
		dropdown1.selectByIndex(selectDay);

		//Select Month
		Select dropdown3=new Select(driver.findElementById("userRegistrationForm:dobMonth"));
		List<WebElement> selectMonth= dropdown3.getOptions();
		int selectMon= selectMonth.size()-1;
		dropdown3.selectByIndex(selectMon);

		//Select year
		Select year= new Select(driver.findElementById("userRegistrationForm:dateOfBirth"));
		year.selectByValue("1990");

		//Select occupation
		Select occupation= new Select(driver.findElementById("userRegistrationForm:occupation"));
		occupation.selectByVisibleText("Professional");

		//Enter email

		driver.findElementById("userRegistrationForm:email").sendKeys("arul@gmail.com");
		driver.findElementById("userRegistrationForm:mobile").sendKeys("9980789999");

		//Select the nationality
		Select nationality= new Select(driver.findElementById("userRegistrationForm:nationalityId"));
		nationality.selectByIndex(1);

		//Enter the address
		driver.findElementById("userRegistrationForm:address").sendKeys("Flat No:G7");

		//Select the country

		Select country=new Select(driver.findElementById("userRegistrationForm:countries"));
		country.selectByIndex(1);

		//Enter pincode
		driver.findElementById("userRegistrationForm:pincode").sendKeys("600045");

		//Click on State

		driver.findElementById("userRegistrationForm:statesName").click();

		//Enter the landline number

		driver.findElementById("userRegistrationForm:landline").sendKeys("0448888888");

		Thread.sleep(3000);

		//Select the City/town

		Select city= new Select(driver.findElementById("userRegistrationForm:cityName"));
		city.selectByVisibleText("Kanchipuram");

		Thread.sleep(3000);

		//Select Post office
		Select PostOffice= new Select(driver.findElementById("userRegistrationForm:postofficeName"));
		List<WebElement> selectPost= PostOffice.getOptions();
		int post= selectPost.size()-1;
		PostOffice.selectByIndex(post);


		driver.findElementById("userRegistrationForm:j_idt486").click();
		
		driver.close();

				
	}

}
