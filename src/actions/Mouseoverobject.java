package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouseoverobject {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:SireeshaEclipse\\automationSelenium\\chromedriver-win64\\chromedriver.exe");
		driver.get("https://www.amazon.in/");
		Actions a = new Actions(driver);
		//By using WebElement we are creating a variable to the perform
		WebElement move=driver.findElement(By.cssSelector("span[id='nav-link-accountList-nav-line-1']"));
		//performing cursor actions
		//a.moveToElement(move).build().perform();
		
		//search the element using actions
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		//by using cursor actions after search the hello we are clicking the outside of the page using contextclick
		a.moveToElement(move).contextClick().build().perform();
		
		
	}

}
