package dataDriven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	@Test
	public void tc1() throws SQLException
	{
		//step1: register to database
		Driver driverrf=new Driver();
		DriverManager.registerDriver(driverrf);
		
		//step2: connect to database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdvSel","root","root");
		
		//step3: create sql query statement
		Statement statement = con.createStatement();
		String query="select * from logindetails;";
		
		//step4: execute query
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ResultSet result = statement.executeQuery(query);
		while(result.next())
		{
			System.out.println(result.getString(1));
			System.out.println(result.getString(2));

		}
	}
}
