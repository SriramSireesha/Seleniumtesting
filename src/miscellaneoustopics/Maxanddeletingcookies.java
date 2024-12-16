package miscellaneoustopics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Maxanddeletingcookies {

	public static void main(String[] args) throws IOException {
		WebDriver driver =new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:SireeshaEclipse\\automationSelenium\\chromedriver-win64\\chromedriver.exe");
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		//we will use to delete specific cookie
		//driver.manage().deleteCookieNamed("asjf");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\SeleniumScreenshot\\eclipse.png"));
		
	}

}
