package week5.sun2;

import java.io.File;
import java.io.IOException;
//import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.Test;

public class Amazon {
	
	public static void main(String[] args) throws IOException, InterruptedException {
	//@Test
	//public void add() throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		 ChromeDriver driver=new ChromeDriver(option);
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		   driver.get("https://www.amazon.in/");
		
		   
		   driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro",Keys.ENTER);
		   String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[3]")).getText();
	       System.out.println(price);
	
	       String customerratings = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
	       System.out.println(customerratings);
	       Thread.sleep(2000);
	       WebElement stars = driver.findElement(By.xpath("(//i[@class='a-icon a-icon-star-small a-star-small-4 aok-align-bottom'])[1]"));
	 
	       Actions builder=new Actions(driver);
	       builder.moveToElement(stars).perform();
	       
	       Thread.sleep(4000);
	       
	       //String percentage = driver.findElement(By.xpath("(//a[@title='5 stars represent 63% of rating'])[3]")).getText();
	       
	       //System.out.println(percentage);
	       
	       driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[3]")).click();
	       Set<String> windowHandles = driver.getWindowHandles();
	       List<String>lstwindow=new ArrayList<String>(windowHandles);
	       driver.switchTo().window(lstwindow.get(1));
	       
	       File source = driver.getScreenshotAs(OutputType.FILE);
	       File dest =new File("./snap/amazon.png");
	       FileUtils.copyFile(source, dest);
	
	       driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
	       String subtotal = driver.findElement(By.xpath("//b[text()='Cart subtotal']")).getText();
	       System.out.println(subtotal);
	       if(price==subtotal) {
	    	   System.out.println("subtotal is not correct");
	       }
	       else {
	    	   System.out.println("subtotal is  correct");
	       }
	       
	
	
	}	
	
}
