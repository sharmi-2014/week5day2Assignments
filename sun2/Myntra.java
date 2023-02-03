package week5.sun2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Myntra {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		 ChromeDriver driver=new ChromeDriver(option);
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		   driver.get("https://www.myntra.com/");
		 //find the element to do the action
		    WebElement men = driver.findElement(By.xpath("(//a[@class='desktop-main'])[1]"));
		    //class
		    Actions builder=new Actions(driver);
		    builder.moveToElement(men).perform();
		    
	       driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();
	       String item = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
	       System.out.println(item);
	
	String sum1 = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
	System.out.println(sum1);
	
	String sum2 = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
	System.out.println(sum2);
	
	if(sum1+sum2==item)
	{
		System.out.println("COUNT MATCHES");
	}
	else {
		System.out.println("COUNT MISMATCHES");
		}
	
	driver.findElement(By.xpath("//span[text()='Brand']")).click();
	driver.findElement(By.xpath("//div[@class='brand-more']")).click();
	driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Duke");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//label[@class=' common-customCheckbox']//div")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//div[@class='FilterDirectory-titleBar']//span")).click();
	
	List<String>lst=new ArrayList<String>();
	List<WebElement> dukebrand = driver.findElements(By.xpath("//h3[text()='Duke']"));
	
	for(int i=0;i<dukebrand.size();i++)
	{
		String text = dukebrand.get(i).getText();
		lst.add(text);
	}
	if(lst.contains("Duke"))
	{
		System.out.println("ALL THE COATS ARE OF BRAND DUKE");
	}
	
	WebElement sort = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
	Actions action=new Actions(driver);
	action.moveToElement(sort).perform();
	Thread.sleep(3000);
	//WebElement discount = driver.findElement(By.xpath("//span[text()='Better Discount']"));
	//Select drop1=new Select(discount);
	//drop1.selectByVisibleText("Better Discount");
	
	String firstprice = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
	System.out.println(firstprice);
	
	driver.findElement(By.xpath("(//img[@draggable='false'])[4]")).click();
	
	Set<String> windowHandles = driver.getWindowHandles();
	
	List<String>lstwindow=new ArrayList<String>(windowHandles);
	driver.switchTo().window(lstwindow.get(1));
	
	File source = driver.getScreenshotAs(OutputType.FILE);
    File dest =new File("./snap/myntra.png");
    FileUtils.copyFile(source, dest);

	driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
	driver.switchTo().window(lstwindow.get(0));
	
	}
}
