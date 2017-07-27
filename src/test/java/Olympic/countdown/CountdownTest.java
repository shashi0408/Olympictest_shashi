package Olympic.countdown;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.annotations.AfterSuite;

public class CountdownTest extends base {
	public WebDriver cDriver; 
	public final int WAIT_TIME = 3000;
	
  @Test(priority=1)
  public void launchPage() throws IOException, InterruptedException  {
	  cDriver.get(applicationUrl);
	  
  }
  
  @Test(priority=2)
  public void login()
  {
  
	  // Click login button
	  cDriver.findElement(By.xpath(("(//a[contains(.,'Login')])[1]"))).click();
	  
	  // Enter username
	  cDriver.findElement(By.id("Email")).sendKeys(username);
	  
	  // Enter password
	  cDriver.findElement(By.id("Password")).sendKeys(password);
	  
	  // Click Login 
	  cDriver.findElement(By.xpath("(//input[@value='Login'])[1]")).click();
	  
	  // Assertion
	  Assert.assertNotNull(cDriver.findElement(By.xpath("(//a[contains(.,'Logout')])[1]")));
  }
  
  
  @Test(priority=3)
  public void shopFromList()
  {
	  // Click Shop from list
	  cDriver.findElement(By.xpath("//a[contains(.,'Shop from list')]")).click();
	  
	  // Enter items in text area
	  cDriver.findElement(By.xpath("//textarea[@name='searchList']")).clear();
	  cDriver.findElement(By.xpath("//textarea[@name='searchList']")).sendKeys("milk\neggs");
	  
	  // Click find these products link
	  cDriver.findElement(By.xpath("//input[@value='Find these products']")).click();
	  
  }
  
  @Test(priority=4)
  public void selectProduct1() throws InterruptedException
  {
	  // Navigate to second page
	  cDriver.findElement(By.xpath("//a[@href='/Shop/SearchFromList?page=2']")).click();
	  
	  Thread.sleep(WAIT_TIME);
	  
	  // Click first item in second page
	  cDriver.findElement(By.xpath("(//img[@title='Homebrand Milk Standard'])[1]")).click();
	  
	  // Add to Trolley
	  addToTrolley();
  }
  
  @Test(priority=5)
  public void SaveTrolley() throws InterruptedException
  {
	  // Click Trolley Image
	  cDriver.findElement(By.xpath("(//img[@alt='Trolley'])[2]")).click();
	  
	  Thread.sleep(WAIT_TIME);
	  
	  // Click View All
	  cDriver.findElement(By.xpath("//a[contains(.,'View All')]")).click();
	  
	  Thread.sleep(WAIT_TIME);
	  
	  // Save Trolley
	  cDriver.findElement(By.xpath("//a[contains(.,'Save Trolley')]")).click();
  }
  
  
  @Test(priority=6)
  public void logout()
  {
	  cDriver.findElement(By.xpath(("(//a[contains(.,'Logout')])[1]"))).click();
  }
  
  public void addToTrolley() throws InterruptedException
  {
	  Thread.sleep(WAIT_TIME);
	  
	  cDriver.findElement(By.xpath("//input[@value='Add to Trolley']")).click();
	  
	  Thread.sleep(WAIT_TIME);
  }
  
  @BeforeSuite
  public void beforeSuite() throws IOException {
	  cDriver = initializeDriver();
  }

  @AfterSuite
  public void afterSuite() {
	  cDriver.close();
  }

}
