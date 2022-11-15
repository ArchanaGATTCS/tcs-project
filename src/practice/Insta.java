package practice;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.datatype.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Insta {
	public static void main(String[] args) throws IOException, Throwable {
		System.setProperty("webdriver.chrome.driver","E:\\Velocity Software Testing\\Auto\\Javafirstprogram\\src\\Browers\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.get("https://www.instagram.com/");
	    
	    FileInputStream file=new FileInputStream("E:\\Velocity Software Testing\\Auto\\12-10-2022\\DataSample.xlsx");
	    XSSFWorkbook workbook =new XSSFWorkbook(file);
	    XSSFSheet Sheet = workbook.getSheet("Sheet1");
	    int rowcount=Sheet.getLastRowNum();
	    int cellcount=Sheet.getRow(1).getLastCellNum();
	    System.out.println("rowcount :"+rowcount+" cellcount: "+cellcount);
	    for (int i=1; i<=rowcount;i++) {
	    	XSSFRow celldata = Sheet.getRow(i);
	    	
	    	String mail = celldata.getCell(0).getStringCellValue();
	    	String pwd = celldata.getCell(1).getStringCellValue();
	    	 Thread.sleep(20000);
	    	
	    	driver.findElement(By.cssSelector("input[name='username']")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	    	driver.findElement(By.cssSelector("input[name='username']")).sendKeys(mail);
	    	 Thread.sleep(20000);
	    	
	    	
	    	driver.findElement(By.cssSelector("input[name='password']")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	    	driver.findElement(By.cssSelector("input[name='password']")).sendKeys(pwd);
	    	 Thread.sleep(20000);
	    	driver.findElement(By.xpath("//div[text()='Log In']")).click();
	    	
	    	
	    	
	    	
	    	
	    	System.out.println(i+"."+mail+" || "+pwd);
	    	
	    	
	    }
	    driver.findElement(By.xpath("//button[text()='Not Now']")).click();
	}

}


