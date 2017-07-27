package Olympic.countdown;

import java.io.FileInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
	private WebDriver driver;
	
	// Properties
	public String browserName;
	public String applicationUrl;
	public String username;
	public String password;
	
	public WebDriver initializeDriver() throws IOException 
	{
		initialiseProperties();
		
		if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:/Seleniumpgm/countdown/drivers/chromedriver_win32/chromedriver.exe" );
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			options.addArguments("start-maximized");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			
			driver= new ChromeDriver(capabilities);
			
		}
		else if (browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:/Seleniumpgm/countdown/drivers/geckodriver/geckodriver.exe" );
			driver= new FirefoxDriver();
		}
	//	else if (browserName=="IE")
	//	{
	//	}
		
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	private void initialiseProperties() throws IOException
	{
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream("D:\\Seleniumpgm\\countdown\\src\\main\\java\\Olympic\\countdown\\data.properties");
		prop.load(fis);
		
		// Initialise properties
		browserName= prop.getProperty("browser");
		applicationUrl = prop.getProperty("appUrl");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		

	}
}