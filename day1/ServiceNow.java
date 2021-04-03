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

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {
		//Step1: Load ServiceNow application https://dev68594.service-now.com/
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver(); 
		driver.get("https://dev68594.service-now.com/");
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//Step2: Enter username as “admin”
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		
		//Step3: Enter password as “India@123”
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("India@123");
		
		//Step4: Click Login
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		
		//Step5: Search “incident “ Filter Navigator
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");
		
		//Step6: Click “All”
		driver.findElement(By.xpath("(//span[text()='Incident']//following::div[text()='All'])[1]")).click();
		
		//Step7: Click New button
		//driver.findElement(By.xpath(""))
		//not able to access via inspect and below steps are pending
		
		
	}
	
}
		