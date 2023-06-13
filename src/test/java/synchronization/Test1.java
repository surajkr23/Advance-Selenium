package synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	@Test
	public void demo1()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phone");
		while(true)
		{
			try
			{
				driver.findElement(By.id("nav-search-submit-button")).submit();
				break;
			}
			catch(Exception e)
			{
				//System.out.println("element not found..");
				e.printStackTrace();
			}
		}
		driver.close();
	}
}
