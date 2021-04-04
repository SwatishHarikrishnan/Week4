package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Learnactions {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver(); 
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement selenium = driver.findElement(By.xpath("(//div[@class='example'])[6]/select/option//following::option[@value='1']"));
		WebElement loadrunner = driver.findElement(By.xpath("(//div[@class='example'])[6]/select/option//following::option[@value='4']"));
		
		Actions build = new Actions(driver);
		build.keyDown(Keys.CONTROL).click(selenium).click(loadrunner).keyUp(Keys.CONTROL).perform();
	}

}
