package week4.day1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver(); 
		driver.get("http://leafground.com/pages/Window.html");
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[@onclick='openWindows()']")).click();
		
		System.out.println(driver.getWindowHandles().size());
		
		Set<String> totalset =  driver.getWindowHandles();
		List<String> totallist=new ArrayList<String>(totalset);
		driver.switchTo().window(totallist.get(1));
		System.out.println(driver.getTitle());
		driver.quit();	
	}

}
