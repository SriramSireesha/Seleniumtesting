package miscellaneoustopics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Brokenlink {

	public static void main(String[] args) throws MalformedURLException, IOException {

		WebDriver driver =new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:SireeshaEclipse\\automationSelenium\\chromedriver-win64\\chromedriver.exe");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//inspect-networktab-->XHR
		//Step 1 - Is to get all urls tied up to the links using selenium
		//Java methods will call URL's and get you the status code
		//if  status code -> 400 then that url is not working -> link which tied to url is broken
		
		List<WebElement>links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a = new SoftAssert();
		 for(WebElement link : links) {
			 {	 
			 String url = link.getAttribute("href");
			 
			 //String url= driver.findElement(By.cssSelector("a[href*='SoapUI']")).getAttribute("href" );
		//String url = driver.findElement(By.xpath("//a[text()='Broken Link']")).getAttribute("href");
		
		//we need to take the status code so we need to take from the HTTP so we will import HttpURLConnection
		
		HttpURLConnection conn =(HttpURLConnection) new URL(url).openConnection();
		//by using below all we are taking the statuscode based on links no need to check on UI side
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode = conn.getResponseCode();
		System.out.println((respCode>400));
		a.assertTrue(respCode<400,"The link with Text "+link.getText()+"is broken with code"+respCode);
	}
			// a.assertAll();

}
		 }}
