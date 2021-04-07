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

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		//1. Launch URL: https://www.amazon.in/
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver(); 
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		
		//2. Type "one plus 7 pro mobiles" in Search Box and Enter
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("one plus 7 pro mobiles", Keys.ENTER);
		
		//3. Print the price of the first resulting mobile
		System.out.println("The price of the first resulting mobile is : " +driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText().replaceAll("\\D", ""));
		
		//4. Click on the Mobile (First resulting) image
		driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
		
		//5. Switch to the new window
		Set<String> setwindo= driver.getWindowHandles();
		List<String> listwino= new ArrayList<String>(setwindo);
		driver.switchTo().window(listwino.get(1));
		
		//6. Print the number of customer ratings
		System.out.println("The number of customer ratings is : " +driver.findElement(By.xpath("(//span[@id='acrCustomerReviewText'])[1]")).getText().replaceAll("\\D", ""));
		
		//7. Click 'Add to Cart'
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//8. Confirm "Added to Cart" text message appeared
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//h4[text()='Added to Cart'])[2]"))));
		String text = driver.findElement(By.xpath("(//h4[text()='Added to Cart'])[2]")).getText();
		if(text.equals("Added to Cart"))
		{
			System.out.println("The Added to cart is successfully confirmed");
		}
		
		//9. Click on Proceed to checkout
		driver.findElement(By.xpath("(//div[@class='a-row a-spacing-top-small']/form/span/span/following::span/span/input[@class='a-button-input'])[1]")).click();
		
		//10. Confirm the title is "Amazon Sign In"
		//System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Amazon Sign In"))
		{
			System.out.println("The Title is successfully verified");
		}
		
		//11. Click Continue (without entering mobile number/email)
		driver.findElement(By.id("continue")).click();
		
		//12. Verify the error message: Enter your email or mobile phone number
		System.out.println("The error message is displayed upon clicking without entering mobile numner/email is :" +driver.findElement(By.xpath("(//div[@class='a-alert-content'])[2]")).getText());
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("8610449475");
		
		//13. Close both browsers - for practising for each loop closed both browser like this
		for(String handle : driver.getWindowHandles())
		{
				driver.switchTo().window(handle);
				driver.close();
		}
		
	}
	
}
		