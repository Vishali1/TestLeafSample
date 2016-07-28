package testleaf;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Week2_Trypopup_hw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://popuptest.com/");
		
		driver.manage().window().maximize();
		
		//Implicit wait(Default Timeout)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Parent window handle
		String parent = driver.getWindowHandle();
		
		driver.findElementByLinkText("Multi-PopUp Test #2").click();
		
		
//get all popup windows
        Set<String> pops=driver.getWindowHandles();
        {
        Iterator<String> it =pops.iterator();
        while (it.hasNext()) 
        {

          String popupHandle=it.next().toString();
            
            
         if(!popupHandle.contains(parent))
           {
            	//Handles all the popups
        driver.switchTo().window(popupHandle);
            
       //Prints title of all popups
       System.out.println("Popu Up Title: "+ driver.switchTo().window(popupHandle).getTitle());
            //Closes all the popups
            driver.close();
            }
        }
        }
        
      //Prints the title of hte parent window
        System.out.println("Switch to parent window and print the title " + driver.switchTo().window(parent).getTitle());
	}
}

