package stepDefinition;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.remote.CapabilityType;  
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import org.openqa.selenium.support.PageFactory;
// parameterize
// ant, exe-bat
// xslt reports
public class TestBase {

	public static Logger APPLICATION_LOGS = null;
	public static Properties CONFIG=null;
	public static WebDriver driver=null;
	public static boolean isLoggedIn=false;
	public static String profileff = "/Users/mohamedasruf/Library/Application Support/Firefox/Profiles/lwutr29o.QAAutomation";

	
	public void initConfigurations(){
		if(CONFIG==null){
		// config.prop
		 CONFIG = new Properties();
		try {
			FileInputStream fs = new FileInputStream("/Users/mohamedasruf/git/cucumber/cucumber/config.properties");			CONFIG.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public WebDriver initDriver() throws MalformedURLException{
		if(driver==null){
			if(CONFIG.getProperty("browser").equals("Mozilla")){
				File profileDirectory = new File(profileff);
			
			FirefoxProfile profile = new FirefoxProfile(profileDirectory);
			
			driver = new FirefoxDriver(profile);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
			else if(CONFIG.getProperty("browser").equals("IE")){
				System.out.println("IE Browser");
				System.setProperty("webdriver.ie.driver","C:\\Users\\toshiba\\Downloads\\IEDriverServer_Win32_2.24.2\\iedriverserver.exe");
				driver=new InternetExplorerDriver();}
			else if(CONFIG.getProperty("browser").equals("Chrome")){
				DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
				
				String chromeBinary = "/usr/bin/chromedriver";
				
				    System.setProperty("webdriver.chrome.driver", chromeBinary);
				
				    driver = new ChromeDriver(chromeCapabilities);
				    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}
			else if(CONFIG.getProperty("browser").equals("Android")){
				DesiredCapabilities cap = new DesiredCapabilities();  
				
				  cap.setCapability("deviceName", "HTC One_M8");  
				  cap.setCapability("platformName", "Android");  
				  cap.setCapability("platformVersion", "5.0.1");  
				  cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");  
				    // driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);//instantiate driver  
				  driver.manage().timeouts().implicitlyWait( 30,TimeUnit.SECONDS); 
			}		
					else if(CONFIG.getProperty("browser").equals("Safari")){
					DesiredCapabilities safariCapabilities = DesiredCapabilities.safari();
				    driver = new SafariDriver(safariCapabilities);
				    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}

		}
		return driver;
	}
	
	public void quitDriver(){
		driver.quit();
		driver=null;
	}
	
	
	
	
}
