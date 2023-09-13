package stepdefinitions;

import java.io.File;
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
import pageobject.AddNewCustomerPage;
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
		//addcust=new AddNewCustomerPage(driver);
		//Thread.sleep(2000);
		//Assert.assertEquals(title, driver.getTitle());
	    
	}
	
	@When("user click on customers menu")
	public void user_click_on_customers_menu() throws Exception {
		
		Thread.sleep(2000);
	    addcust.clickOnCustoms();
	}

	@When("user click on customers menu item")
	public void user_click_on_customers_menu_item() throws Exception {
		Thread.sleep(1000);
	    addcust.clickOnCustomsMenu();
	}

	@When("user click on new add button")
	public void user_click_on_new_add_button() throws Exception {
		Thread.sleep(1000);
	    addcust.clickOnAddNew();
	}

	@Then("user can view add new custoer page")
	public void user_can_view_add_new_custoer_page() {
	    
	}

	@When("user enter customer info as {string} and {string} and {string} and {string} and {string} and {string} and {string}")
	public void user_enter_customer_info_as_and_and_and_and_and_and(String newEmail, String newPass, String fname, String lname, String gender, String comName, String adminComment) throws Exception {
	    addcust.setEmail(newEmail);
	    Thread.sleep(1000);
	    
	    addcust.setPasswor(newPass);
	    Thread.sleep(1000);
	    
	    addcust.setFirstName(fname);
	    Thread.sleep(1000);
	    
	    addcust.setLastName(lname);
	    Thread.sleep(1000);
	    
	    addcust.setCompanyName(comName);
	    Thread.sleep(1000);
	    
	    addcust.setAdminComment(adminComment);
	    Thread.sleep(1000);
	    
	    
	}

	@When("user click on save button")
	public void user_click_on_save_button() {
	    addcust.clickOnSave();
	}

	@Then("user can view confirmation msg {string}")
	public void user_can_view_confirmation_msg(String string) {
	    
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
