package stepdefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageobject.AdminPage;
import utilities.ReadConfig;

public class StepDefinition extends Base{
	
	@Before
	public void setUp() throws Exception {
		readconfig=new ReadConfig();//create object of ReadConfig class
		System.out.println("setup method is executed");
		//driver=new ChromeDriver();
		
		String browser=readconfig.getBrowser();
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}else if(browser.equalsIgnoreCase("ie")) {
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}else if(browser.equalsIgnoreCase("safari")) {
			driver=new SafariDriver();
			driver.manage().window().maximize();
			Thread.sleep(1000);
		}
	}

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
	    //driver=new ChromeDriver();
	    
	    ad=new AdminPage(driver);//create object of AdminPage java class
	}

	@When("User open url {string}")
	public void user_open_url(String url) {
	    driver.get(url);
	}

	@When("User eneter email as {string} and Password as {string}")
	public void user_eneter_email_as_and_password_as(String email, String password) throws Exception {
	    ad.setUsername(email);
	    Thread.sleep(2000);
	    
	    ad.setPassword(password);
	    Thread.sleep(2000);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() throws Exception {
	    ad.clickOnLogin();
	    Thread.sleep(2000);
	   
	}

	@Then("Verify user title page is {string}")
	public void verify_user_title_page_is(String title) throws Exception {
		
		Thread.sleep(2000);
		Assert.assertEquals(title, driver.getTitle());
	    
	}
	

	@Then("Close browser")
	public void close_browser() throws Exception {
		Thread.sleep(2000);
	    driver.quit();
	}
	
	@After
	public void tearDown(Scenario sc) throws Exception {
		System.out.println("Tear down method executed");
		
		if(sc.isFailed()==true) {
			String filepath="/Users/rohitgulati/eclipse-workspace/BAT17CucumberMavenProject/Screenshot/failedScreenshot.png";
			
			//convert webdriver into take screenshot
			
			TakesScreenshot scrShot=((TakesScreenshot)driver);
			
			//call getscreenshotas to save the image file
			
			File scrFile=scrShot.getScreenshotAs(OutputType.FILE);
			
			File destFile=new File(filepath);
			
			FileUtils.copyFile(scrFile, destFile);
		}
	}
}
