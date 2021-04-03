package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IRCTC {

	public static void main(String[] args) throws InterruptedException {
		//1. Load https://www.irctc.co.in/
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver(); 
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//2. Click on OK button in the dialog  // Alert
		//Alert alert= driver.switchTo().alert();
		//alert.accept();
		//System.out.println(alert.getText());
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

		//3. Click on FLIGHTS link             // New window
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		System.out.println("The total number of windows available is : " +driver.getWindowHandles().size());
		
		
		//4. Go to the Flights tab
		Set<String> firstwindow=driver.getWindowHandles();
		List<String> listwindow=new ArrayList<String>(firstwindow);
		driver.switchTo().window(listwindow.get(1));
		
		//5. Print the customer care email id
		System.out.println("The customer care mail id is : " +driver.findElement(By.xpath("(//nav/div/a/following::a[text()=' flights@irctc.co.in'])[1]")).getText());

		//6. Close the First tab(Train ticket booking) alone
		driver.switchTo().window(listwindow.get(0));
		driver.close();
		
	}

}
