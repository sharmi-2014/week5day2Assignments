package week5.sun2;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {
	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		 ChromeDriver driver=new ChromeDriver(option);
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		   driver.get("https://www.nykaa.com/");
		   
		   WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		   
		   Actions builder=new Actions(driver);
		   builder.moveToElement(brands).perform();
		   driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		   Thread.sleep(4000);
		   driver.findElement(By.xpath("(//a[contains(text(),'Oreal Paris')])[1]")).click();
		   String title = driver.getTitle();
		   System.out.println(title);
		   driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
		   driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		  	   
		   driver.findElement(By.xpath("//span[text()='Category']")).click();
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//span[text()='Hair']")).click();
           Thread.sleep(2000);
		   driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		   driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		   
		   String text = driver.findElement(By.xpath("//div[@class='css-1emjbq5']//span")).getText();
		   
		   if (text.equals(text)) {
			   
			   System.out.println("Shampoo is Clicked");
			
		}
		   else {
			
			   System.out.println("Not Clicked");
		}
		   
		   driver.findElement(By.xpath("//span[text()='Concern']")).click();

		   driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		   
           //click on L'Oreal Paris Colour protection Shampoo
		   driver.findElement(By.xpath("//div[@class='css-1rd7vky']")).click();
		   
		   //driver.findElement(By.xpath("(//span[text()='180ml'])[2]")).click();
		   
		   Set<String> windowHandles = driver.getWindowHandles();

		   System.out.println(windowHandles.size());
		   
		   List<String>lstwindow = new ArrayList<String>(windowHandles);
		   
		   //switch the control to window
		   driver.switchTo().window(lstwindow.get(1));
		   System.out.println(driver.getTitle());
		   
		   driver.findElement(By.xpath("//span[text()='180ml']")).click();
		   
		   String MRP = driver.findElement(By.xpath("//span[text()='₹189']")).getText();
		   System.out.println(MRP);
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
		   
		   driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		   driver.switchTo().frame(0);
		   String grandtotal = driver.findElement(By.xpath("//span[text()='Grand Total']")).getText();
		   System.out.println(grandtotal);
		   
		   Thread.sleep(2000);
		   
		   driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		   
		   driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		   
		   String finaltotal = driver.findElement(By.xpath("//p[text()='Price Details']")).getText();
		   
		   System.out.println(finaltotal);
		   
		   if(grandtotal.equals(finaltotal)) {
			   System.out.println("NOT EQUAL");
		   }
		   else {
			   System.out.println("IS EQUAL");
		   }
		   driver.switchTo().window(lstwindow.get(0));
		   
	}	
}
