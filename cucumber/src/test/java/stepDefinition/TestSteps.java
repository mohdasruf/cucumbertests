package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.practice.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps extends TestBase {
	public static WebDriver driver;
	

@Before
@Given("^User is on Home Page$")
public void user_is_on_Home_Page() throws Throwable {
	
	// initConfigurations();
	 //driver = initDriver();
	DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
	
	String chromeBinary = "/usr/bin/chromedriver";
	
	    System.setProperty("webdriver.chrome.driver", chromeBinary);
	
	    driver = new ChromeDriver(chromeCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
   
}

@When("^User Navigate to LogIn Page$")
public void user_Navigate_to_LogIn_Page() throws Throwable {
	
	driver.get("https://secure.tesco.com/register/?from=http%3a%2f%2fwww.tesco.com%2fgroceries%2f");

}


@When("^User enters \"(.*?)\" and \"(.*?)\"$")
public void user_enters_and(String Username,String Password) throws Throwable {
	
	driver.findElement((By.xpath(Constants.tusername))).sendKeys(Username);
	driver.findElement((By.xpath(Constants.tpassword))).sendKeys(Password);
	driver.findElement((By.xpath(Constants.tpassword))).sendKeys(Keys.ENTER);
    // Write code here that turns the phrase above into concrete actions

}

@Then("^Message displayed Login Successfully$")
public void message_displayed_Login_Successfully() throws Throwable {
	
	Assert.assertEquals(driver.getTitle(), Constants.titleHomePage);
	driver.close();
    
}

@When("^User enters invalid Username and Password$")
public void user_enters_invalid_Username_and_Password() throws Throwable {
	driver.findElement((By.xpath(Constants.tusername))).sendKeys("xxx@gmail.com");
	driver.findElement((By.xpath(Constants.tpassword))).sendKeys("xxx");
	driver.findElement((By.xpath(Constants.tpassword))).sendKeys(Keys.ENTER);
}

@Then("^Message displayed Login unSuccessfull$")
public void message_displayed_Login_unSuccessfull() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Assert.assertEquals(driver.getTitle(), "Tesco.com - Signin");
	driver.close();

}

}
