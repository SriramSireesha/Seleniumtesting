package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Locatorsexample2 {

	public static void main(String[] args) throws InterruptedException {
		String name = "Sireesha";
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:SireeshaEclipse\\automationSelenium\\chromedriver-win64\\chromedriver.exe");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[type*=pass]")).sendKeys(password);
		//classnamewithID[input#id]
		//driver.findElement(By.cssSelector("input#chkboxTwo")).click();
		//driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.className("signInBtn")).click();
		
	//	driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		//css selector with child so we will use it as in space div[class='login-container'] h2
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
		
		//anyelement finding based on text //button[text() ='Log Out']  or //*[text() ='Log Out']
		driver.findElement(By.xpath("//button[text() ='Log Out']")).click();
		driver.close();
	}
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		
		String PasswordText = driver.findElement(By.cssSelector("form p")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.
		
		
		/*1. I want to split the string based on ' ' 
		2. first it will take upto ' and it will split
		3.from Rahulshettyacademy' it will split again that is  right side(1) and left side (0)
		*/
		
		/*
		  0th index -->Please use temporary password 
		  1st index -->rahulshettyacademy' to Login
		  
		   0th index -->rahulshettyacademy
		   1st index --> to Login
		 */
		String[] PasswordArray = PasswordText.split("'");
		/*String[] PasswordArray2 = PasswordArray[1].split("'");
		PasswordArray2[0]*/
			String password = PasswordArray[1].split("'")[0];
			return password;
	}
}

