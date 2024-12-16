package realTimeexercises;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Printthelinksofcount {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:SireeshaEclipse\\automationSelenium\\chromedriver-win64\\chromedriver.exe");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//here every html links start with a so by using that we are taking count of links
		//get the count of count entire the page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//get the count of code in footer section
		
		WebElement footerdriver= driver.findElement(By.id("gf-BIG")); //limiting webdriver scope
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		
		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		//click on each link of those links in selected footer section
		
		for(int i=1;i<columndriver.findElements(By.tagName("a")).size(); i++) {
			
			String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(3000L);
		}
			Set<String> getTitleofpage = driver.getWindowHandles(); //4 titles we will get
			Iterator<String> it=getTitleofpage.iterator();
			//hasNext() method returns true if iterator have more elements. next() : 
			//next() method returns the next element and also moves to the next element.
			while(it.hasNext())
			{
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
			
	}

}
