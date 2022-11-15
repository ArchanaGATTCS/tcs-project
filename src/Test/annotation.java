package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class annotation {
	WebDriver driver;
	@BeforeClass
	
	public void openbrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\Velocity Software Testing\\Auto\\Javafirstprogram\\src\\Browers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.instagram.com/");
		Reporter.log("open browser",true);
	}
	
	@BeforeMethod
	public void logintoapp() {
		driver.findElement(By.xpath("//span[text()='Phone number, username, or email']")).sendKeys("mrujapune");
		driver.findElement(By.xpath("//span[text()='Password']")).sendKeys("Mruja@8888");
		driver.findElement(By.xpath("//div[text()='Log in']")).click();
		Reporter.log("login to app",true);
	}
	
	@Test
	public void title() throws Throwable {
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println(title);
		AssertJUnit.assertEquals(title,"Instagram");
	}
	@AfterMethod
	public void logoutapp() {
		Reporter.log("logout app", true);
	}
	@AfterClass
	public void closebrowser() {
		Reporter.log("close browser",true);
	}

}



