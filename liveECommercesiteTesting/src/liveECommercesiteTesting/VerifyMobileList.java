package liveECommercesiteTesting;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class VerifyMobileList {
WebDriver driver;
@BeforeSuite
 void lanuchBrowser() throws IOException{
	
	Properties properitiesObject=new Properties();
	InputStream inputStream = new FileInputStream("config.properties");
	properitiesObject.load(inputStream);
	String driverlocation = properitiesObject.getProperty("driverlocation");
	System.setProperty("webdriver.gecko.driver", driverlocation);
	driver = new FirefoxDriver();
}
@Test
public void openEcommerceSite(){
	boolean isSorted = false;
	driver.get("http://live.guru99.com/index.php/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	String title = driver.getTitle();
	
	if(title.contains("Home page")){
		System.out.println("Home page verified");
	}else{
		System.out.println("Home page is not available");
	}
	
	assertEquals(title, "Home page");
	WebElement chooseMobile = driver.findElement(By.xpath("/html/body/div/div/header/div/div[3]/nav/ol/li[1]/a"));
	chooseMobile.click();
	String mobileTitle = driver.getTitle();
	if(mobileTitle.contains("Mobile")){
		System.out.println("Mobile page is selected");
	}else{
		System.out.println("Mobile page is not selected");
	}
	//assertEquals(mobileTitle, "Mobile");
	
	WebElement selectdropdown = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select"));
	selectdropdown.click();
	Select select = new Select(selectdropdown);
	select.selectByVisibleText("Name");;
	
	
	String mobile1 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/h2/a")).getText();
	
	String mobile2 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/h2/a")).getText();
	 
	String mobile3 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/h2/a")).getText();
	
	
	String previous = ""; // empty string: guaranteed to be less than or equal to any other

	List<String> mobileList= new ArrayList<String>();
	mobileList.add(mobile1);
	mobileList.add(mobile2);
	mobileList.add(mobile3);
	
	
	for (final String current: mobileList) {
	    if (current.compareTo(previous) > 0){
	        isSorted=false;
	    System.out.println(isSorted);
	    previous = current;
	    }else{
		isSorted = true;
		System.out.println(isSorted);
	}
	
	
}
}
}
