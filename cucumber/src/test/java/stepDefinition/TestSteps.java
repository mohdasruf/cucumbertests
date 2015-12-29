package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.practice.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps extends TestBase {
	WebDriver driver = null;


@Given("^User is on Home Page$")
public void user_is_on_Home_Page() throws Throwable {
	
	 initConfigurations();
	 driver = initDriver();
	 
   
}

@When("^User Navigate to LogIn Page$")
public void user_Navigate_to_LogIn_Page() throws Throwable {
	driver.get("https://secure.tesco.com/register/?from=http%3a%2f%2fwww.tesco.com%2fgroceries%2f");

}

@When("^User enters UserName and Password$")
public void user_enters_UserName_and_Password() throws Throwable {
	
	driver.findElement((By.xpath(Constants.tusername))).sendKeys("XXX");
	driver.findElement((By.xpath(Constants.tpassword))).sendKeys("XXX");
	driver.findElement((By.xpath(Constants.tpassword))).sendKeys(Keys.ENTER);
    // Write code here that turns the phrase above into concrete actions

}

@Then("^Message displayed Login Successfully$")
public void message_displayed_Login_Successfully() throws Throwable {
	
	Assert.assertEquals(driver.getTitle(), Constants.titleHomePage);
	driver.close();
    
}


}
