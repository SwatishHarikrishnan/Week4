package week4.day2;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.asynchttpclient.request.body.generator.FileBodyGenerator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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

public class Pepperfry {

	public static void main(String[] args) throws InterruptedException {
		//1) Go to the URL https://www.Pepperfry.com/shop/sale 
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver(); 
		driver.get("https://www.pepperfry.com/");
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
		//2) Mouseover on Furniture and click Office Chairs under Chairs
		WebDriverWait wait = new WebDriverWait(driver, 15);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		Actions furniture = new Actions(driver);
		WebElement furnitureloacation = driver.findElement(By.xpath("//a[@rel='meta-furniture']")); 
		furniture.moveToElement(furnitureloacation).perform();
		driver.findElement(By.xpath("//a[text()='Office Chairs']")).click();
		
		//3) click Executive Chairs
		driver.findElement(By.xpath("//h5[text()='Executive Chairs']")).click();
		
		//4) Change the minimum Height to 50 in under Dimensions
		driver.findElement(By.xpath("(//input[@class='clipFilterDimensionHeightValue'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@class='clipFilterDimensionHeightValue'])[2]")).sendKeys("50", Keys.ENTER);;
		
		//5) Add "Galician High Back Executive Chair In Black Colour" chair to Wishlist
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-productname='Executive Chair in Black Colour'])[1]")).click();
		
		//6) Mouseover on Bedroom and Click Study tables
		WebElement bedloacation = driver.findElement(By.xpath("//a[@rel='meta-bedroom']")); 
		furniture.moveToElement(bedloacation).perform();
		driver.findElement(By.xpath("(//a[text()='Study Tables'])[3]")).click();
		
		//7) Select Spacewood as Brand
		driver.findElement(By.xpath("//*[@for='brandsnameSpacewood']")).click();
			
		//8) Select Price as 7000 to 8000
		Thread.sleep(1000);
		WebElement pricecost = driver.findElement(By.xpath("//label[@for='price7000-8000']"));
		Actions amount = new Actions(driver);
		amount.moveToElement(pricecost).click().perform();
		
		//9) Add "SOS Carter Study Table In Lorraine Walnut & Silver Grey Finish
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@data-productname='SOS Carter Study Table in Lorraine walnut & silver grey Finish']")).click();
		
		//10) Verify the number of items in the Wishlist
		driver.findElement(By.xpath("//a[@class='wishlist_bar']")).click();
		List<WebElement> noofitems=driver.findElements(By.xpath("//div[@class='item_details']"));
		System.out.println("The number of items in the Wishlist is : " +noofitems.size());
		
		//11) Navigate to Wishlist
		//12) Move Table only to Cart from Wishlist
		driver.findElement(By.xpath("(//img[@class='mCS_img_loaded'])[2]")).click();
		Set<String> couponwindow = driver.getWindowHandles();
		List<String> backtowindow = new ArrayList<String>(couponwindow);
		driver.switchTo().window(backtowindow.get(1));
		driver.findElement(By.xpath("//a[text()='Add to Cart']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='cart_bar']")).click();
		WebElement adframe = driver.findElement(By.xpath("//iframe[@id='webklipper-publisher-widget-container-notification-frame']"));
		driver.switchTo().frame(adframe);
		WebElement product = driver.findElement(By.xpath("//span[@class='wewidgeticon we_close icon-large']"));
		Actions cart1 = new Actions(driver);
		cart1.moveToElement(product).click().perform();
		driver.switchTo().defaultContent();
				
		//13) Click Proceed to Pay Securely
		driver.findElement(By.xpath("//a[text()='Proceed to pay securely ']")).click();
		
		//14) Enter Pincode as 600028 in Delivery & Assembly Details and click Go
		driver.findElement(By.xpath("//input[@placeholder='Pincode']")).sendKeys("600028");
		driver.findElement(By.xpath("//INPUT[@NAME='pin_check']")).click();
		
		//15) Click Place Order
		driver.findElement(By.xpath("(//a[@class='btn_green_big'])[1]")).click();
		
		//16) Capture a screenshot by Clicking on Order Summary
		driver.findElement(By.xpath("(//span[text()='ORDER SUMMARY']/following::div/span)[1]")).click();
		driver.getScreenshotAs(OutputType.FILE);
		
		//17) Close the browser 
		driver.quit();
		
	}
	
}
		