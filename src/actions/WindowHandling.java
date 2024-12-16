package actions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:SireeshaEclipse\\automationSelenium\\chromedriver-win64\\chromedriver.exe");
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows = driver.getWindowHandles(); 
		//[parentId, childId, subChildid] these we taking as index 0, 1,2
		//by moving windows from parent to child we will use it as parentid next 
		//So, here we are using to shift from parentid to child id so we are using 2 times 
		//suppose it=f we need to shift another window means we will use it as 	String subChildid = it.next();
		Iterator<String>it=windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		driver.findElement(By.cssSelector(".im-para.red")).getText();
		//Please email us at mentor@rahulshettyacademy.com with below template to receive response 
		// we are taking the above mail using split methiod
		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		//String parentId = it.next();
		//after split the mail id we need to swith the window to parentid
		driver.switchTo().window(parentId);
		driver.findElement(By.cssSelector("#username")).sendKeys(emailId);
	}

}
