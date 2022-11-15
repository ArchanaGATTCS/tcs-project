package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class iframe {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "E:\\Velocity Software Testing\\Auto\\Javafirstprogram\\src\\Browers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?org/openqa/selenium/package-summary.html");
		
		driver.manage().window().maximize();
		driver.switchTo().frame("packageListFrame");
		String text1=driver.findElement(By.xpath("//a[text()='org.openqa.selenium.chrome']")).getText();
		System.out.println(text1);
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		driver.switchTo().frame("packageFrame");
		String text2=driver.findElement(By.xpath("//a[text()='AbstractAnnotations']")).getText();
		System.out.println(text2);
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		driver.switchTo().frame("classFrame");
		String text3=driver.findElement(By.xpath("//a[text()='Capabilities']")).getText();
		System.out.println(text3);
	}

}
