package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] a=new Object[3][2];
		a[0][0]="qwerty";
		a[0][1]="asdf";
		
		a[1][0]="12345";
		a[1][1]="09876";
		
		a[2][0]="qwe123";
		a[2][1]="asd098";
		return a;
	}
	
	@Test(dataProvider= "getdata")
	public void tc1(String user, String pwd)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys(user);
		driver.findElement(By.name("pass")).sendKeys(pwd);
		driver.findElement(By.name("login")).click();
		driver.close();
	}
}
