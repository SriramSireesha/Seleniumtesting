package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingFrames {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:SireeshaEclipse\\automationSelenium\\chromedriver-win64\\chromedriver.exe");
		driver.get("https://jqueryui.com/droppable/");
	//here we are having 3 types of handling frames 1.String 2. Frameid 3.WebElement
		/* suppose example we are using frames
		 * driver.switchto().frame(1); if we want to switch to frame 2 we will mention 2
		 * but this is not prefereable message why because if dev add one more frame it may get fail 
		 * System.out.println(driver.findElements(By.id("iframe")).size(); // So, it will gives the count of frames in the window
		 * driver.switchTo.frame(0); // here we are giving the index as zero why because we are having only one so, that starts from 0
		 * 
		 * */
		
		
		
	//here we are using webElement
	driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
	//driver.findElement(By.id("draggable")).click();
	
	Actions a = new Actions(driver);
	
	WebElement source = driver.findElement(By.id("draggable"));
	WebElement target = driver.findElement(By.id("droppable"));

	a.dragAndDrop(source, target).build().perform();
	driver.switchTo().defaultContent(); // This command is use for comeback from the frames section other wise it will search in the box for next steps
	driver.findElement(By.xpath("//a[text() = 'Accept'] ")).click();
		
	}

}
