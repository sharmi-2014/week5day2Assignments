package week5.sun2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.leafground.com/waits.xhtml");

		WebElement visible = driver.findElement(By.xpath("(//span[text()='Click'])[1]"));
		visible.click();
		// Explicit wait
		// Create obj for WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// wait until the element to visible
		wait.until(ExpectedConditions.visibilityOf(visible));
		// verification
		String text = driver.findElement(By.xpath("//span[text()='I am here']")).getText();
		System.out.println(text);

		WebElement invisible = driver.findElement(By.xpath("(//span[text()='Click'])[2]"));
		invisible.click();
		WebElement findElement2 = driver.findElement(By.xpath("//span[text()='I am about to hide']"));
		String text3 = findElement2.getText();
		// wait until the element to visible
		wait.until(ExpectedConditions.invisibilityOf(findElement2));
		
		System.out.println("**********");
		// Wait for the element to clickable
		driver.findElement(By.xpath("//span[text()='Click First Button']")).click();
		WebElement clickable = driver.findElement(By.xpath("//span[text()='Click Second']"));
		wait.until(ExpectedConditions.elementToBeClickable(clickable));
		String textnew = clickable.getText();
		System.out.println(textnew);

		

	driver.findElement(By.xpath("(//span[text()='Click'])[3]")).click();
		WebElement didyouNotice = driver.findElement(By.xpath("//span[text()='Did you notice?']"));
		String text2 = didyouNotice.getText();
		wait.until(ExpectedConditions.textToBePresentInElement(didyouNotice, text2));

	}
}
