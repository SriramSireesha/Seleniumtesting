package realTimeexercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class ScrollDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:SireeshaEclipse\\automationSelenium\\chromedriver-win64\\chromedriver.exe");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Generally we are using java but for scrool down we need to use js 
		//here same as java[cssSelector], in js we will use queryselector and and instead of [scrollup] in java we will use scrollTop in js and driver replaced with document
	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
	Thread.sleep(3000);
	js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
	
	List<WebElement>values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
	int sum=0;
	for(int i=0; i<values.size();i++) {
		sum=sum+Integer.parseInt(values.get(i).getText());
	}
	System.out.println(sum);
	int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
	
	Assert.assertEquals(sum, total);
	
	}
	

}
