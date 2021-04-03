package week4.day1;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.asynchttpclient.request.body.generator.FileBodyGenerator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.Ordering;

import io.cucumber.messages.internal.com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.awt.List;
import java.io.File;
import java.io.IOException;

import javax.print.DocFlavor.INPUT_STREAM;

import org.apache.commons.io.FileUtils;
import org.apache.poi.poifs.crypt.dsig.KeyInfoKeySelector;
import org.apache.tools.ant.taskdefs.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.inject.spi.Element;
import com.mongodb.client.ListCollectionsIterable;

import io.cucumber.messages.internal.com.google.protobuf.ByteString.Output;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException {
		//1. Launch https://www.snapdeal.com/
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver(); 
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//2. Go to Mens Fashion
		WebElement mensfashion = driver.findElement(By.xpath("(//span[@class='catText'])[6]"));
		Actions action = new Actions(driver);
		action.moveToElement(mensfashion).perform();
		
		//3. Go to Sports Shoes
		driver.findElement(By.linkText("Sports Shoes")).click();
		
		//4. Get the count of the sports shoes
		System.out.println("The count of the sport shoes present is : " +driver.findElement(By.xpath("(//a[@class='child-cat-node dp-widget-link hashAdded'])[2]/div[2]")).getText());
		
		//5. Click Training shoes
		driver.findElement(By.xpath("(//div[@class=\"child-cat-name \"]/following::a)[2]")).click();
		
		//6. Sort by Low to High
		List<WebElement> sortingshoelist = driver.findElements(By.xpath("//div[@class='col-xs-6  favDp product-tuple-listing js-tuple ']//span[@class='lfloat product-price']"));
		List<Integer> number = new ArrayList<Integer>();
		for(WebElement shoe : sortingshoelist)
		{
			String shoeremovealpha = shoe.getText().replaceAll("\\D", "");
			number.add(Integer.parseInt(shoeremovealpha));
		}
		System.out.println("The total number of shoes present in training shoes is : " +number.size());
		Collections.sort(number);
		System.out.println("The sorted order of low to high : " +number);
		
		//7. select the brand Puma
		driver.findElement(By.xpath("//input[@readonly='readonly']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='sd-input js-searchable-box'])[1]")).click();
		driver.findElement(By.xpath("(//input[@class='sd-input js-searchable-box'])[1]")).sendKeys("puma");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@for='Brand-Puma']/a")).click();
		driver.findElement(By.xpath("//div[@class='btn applyFilters lfloat']")).click();
		
		//8. Check if the items displayed are sorted correctly		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']/div/following::li[@data-index='1']")).click();
		Thread.sleep(1000);
		List<WebElement> sortingshoelist1 = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<Integer> number1 = new ArrayList<Integer>();
		for(WebElement shoe1 : sortingshoelist1)
		{
			String shoeremovealpha1 = shoe1.getText().replaceAll("\\D", "");
			number1.add(Integer.parseInt(shoeremovealpha1));
		}
		System.out.println(number1);
		boolean sorted = Ordering.natural().isOrdered(number1);
		if(sorted)
		{
			System.out.println("The items are sorted correctly");
		}
		
		//9. Mouse Hover on puma Blue Training shoes
		WebElement blueshoe = driver.findElement(By.xpath("//img[@title='Puma Blue Training Shoes']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(blueshoe).perform();
		
		//10. click QuickView button
		driver.findElement(By.xpath("//img[@title='Puma Blue Training Shoes']//following::div/div")).click();
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
		
		//11. Print the cost and the discount percentage
		action1.moveToElement(blueshoe).perform();
		driver.findElement(By.xpath("//img[@title='Puma Blue Training Shoes']")).click();
		Set<String> shoepage = driver.getWindowHandles();
		List<String> shoecostdisccost = new ArrayList<String>(shoepage);
		driver.switchTo().window(shoecostdisccost.get(1));
		System.out.println("The cost of the shoe is : " +driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText());
		System.out.println("The discount percentage of the shoe is : " +driver.findElement(By.xpath("//span[@class='pdpDiscount ']/span")).getText());
		
		//12. Take the snapshot of the shoes.
		driver.getScreenshotAs(OutputType.FILE);
		
		//13. Close the current window
		driver.close();
		
		//14. Close the main window
		driver.switchTo().window(shoecostdisccost.get(0));
		driver.close();
		
		
	}
	
}
		