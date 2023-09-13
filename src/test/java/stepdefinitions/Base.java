package stepdefinitions;

import org.openqa.selenium.WebDriver;

import pageobject.AddNewCustomerPage;
import pageobject.AdminPage;
import utilities.ReadConfig;

public class Base {

	public WebDriver driver;
	
	public AdminPage ad;
	
	public ReadConfig readconfig;
	
	public AddNewCustomerPage addcust;
	
}
