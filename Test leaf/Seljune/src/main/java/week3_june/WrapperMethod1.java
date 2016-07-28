package week3_june;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class WrapperMethod1 {
RemoteWebDriver driver;
	@Test
	public void selectbyvaluefromid(String id,String value)
	{
		try {
			Select val=new Select(driver.findElementById(id));
			val.selectByValue(value);
		} catch (NoSuchElementException e) {
			System.out.println("Error" +e);
		}
		finally {
		//screenshot();
		}
}
	public void selectbyindexfromid(String id,int value)
	{
		try {
			Select index=new Select(driver.findElementById(id));
			index.selectByIndex(value);
		} catch (NoSuchElementException e) {
			System.out.println("Error" +e);
		}
		finally {
		//screenshot();
		}
	}
		
		public void selectbyvisibletextfromid(String id,String value)
		{
			try {
				Select text=new Select(driver.findElementById(id));
				text.selectByVisibleText(value);
			} catch (NoSuchElementException e) {
				System.out.println("Error" +e);
			}
			finally {
			//screenshot();
			}	
			
			
}
		public void selectbyvaluefromname(String name,String value)
		{
			try {
				Select val=new Select(driver.findElementByName(name));
				val.selectByValue(value);
			} catch (NoSuchElementException e) {
				System.out.println("Error" +e);
			}
			finally {
			//screenshot();
			
}
		}
		public void selectbyindexfromname(String name,int value)
		{
			try {
				Select index=new Select(driver.findElementByName(name));
				index.selectByIndex(value);
			} catch (NoSuchElementException e) {
				System.out.println("Error" +e);
			}
			finally {
			//screenshot();
			
}
		}

		public void selectbyvisibletextfromname(String name,String value)
		{
			try {
				Select text=new Select(driver.findElementByName(name));
				text.selectByVisibleText(value);
			} catch (NoSuchElementException e) {
				System.out.println("Error" +e);
			}
			finally {
			//screenshot();
			
}
		}
}


