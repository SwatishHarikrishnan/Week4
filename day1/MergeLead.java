package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException {
		//Application : http://leaftaps.com/opentaps/control/main
		//1. Launch the browser
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver(); 
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//2. Enter the username
		//3. Enter the password
		//4. Click Login
		//5. Click crm/sfa link
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//6. Click Leads link
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		
		//7. Click Merge leads
		driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();

		//8. Click on Icon near From Lead
		driver.findElement(By.xpath("(//span[text()='From Lead']/following::img[@alt='Lookup'])[1]")).click();
		
		//9. Move to new window
		System.out.println("The total windows available is : " +driver.getWindowHandles().size());
		Set<String> setwindow= driver.getWindowHandles();
		List<String> lstwindow = new ArrayList<String>(setwindow);
		driver.switchTo().window(lstwindow.get(1));
		
		//10. Enter Lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys("10055");
		//once input is given and it is not showing one more time while re-executing the script, no idea whether is bug or expected application behavior
		
		//11. Click Find Leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//12. Click First Resulting lead
		//driver.findElement(By.xpath("(//td/following::a[@class='linktext'])[1]")).click();
		//driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody/tr//a)[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody/tr/td/div/a[@class='linktext'])[1]")).click();
		
		//13. Switch back to primary window
		driver.switchTo().window(lstwindow.get(0));
		
		//14. Click on Icon near To Lead
		driver.findElement(By.xpath("(//span[text()='From Lead']/following::img[@alt='Lookup'])[2]")).click();
		
		//15. Move to new window
		Set<String> newsetwindow = driver.getWindowHandles();
		List<String> newlistwindow = new ArrayList<String>(newsetwindow);
		driver.switchTo().window(newlistwindow.get(1));
		
		//16. Enter Lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys("10051");

		//17. Click Find Leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		//18. Click First Resulting lead
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody/tr/td/div/a[@class='linktext'])[1]")).click();
		
		//19. Switch back to primary window
		driver.switchTo().window(newlistwindow.get(0));

		//20. Click Merge
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		//21. Accept Alert
		Alert action = driver.switchTo().alert();
		action.accept();
		
		//22. Click Find Leads link
		driver.findElement(By.linkText("Find Leads")).click();

		//23. Enter From Lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys("10055");

		//24. Click Find Leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//25. Verify message "No records to display" in the Lead List. This message confirms that the successful merge of leads
		Thread.sleep(1000);
		String records = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		System.out.println(records);
		if(records.equalsIgnoreCase("No records to display"))
		{
			System.out.println("It is successfully verified that no records are found to display in the lead list");
		}
		//26. Close the browser (Do not log out)
		driver.quit();
	}

}
