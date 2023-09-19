package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {
	
	public WebDriver ldriver;

	public AddNewCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
		@FindBy (xpath = "//a[@class='nav-link active']//p[text()=' Customers']")
		WebElement lnkcust;
		
		By lnkcust1=By.xpath("//a[@class='nav-link active']//p[text()=' Customers']");
	
		By lnkCustomes_menu= By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
		
		By lnkCustomers_menu_item=By.xpath("//p[text()=' Customers']");
		
		By btnAddNew=By.xpath("//a[@class='btn btn-primary']");
		
		By txtEmail=By.xpath("//input[@name='Email']");
		
		By txtPassword=By.xpath("//input[@name='Password']");
		
		By txtFirstName=By.xpath("//input[@name='FirstName']");
		
		By txtLastName=By.xpath("//input[@name='LastName']");
		
		By rdMaleGender=By.xpath("//input[@id='Gender_Male']");
		
		By rdFemaleGender=By.xpath("//input[@id='Gender_Female']");
		
		By txtDOB=By.xpath("//input[@id='DateOfBirth']");
		
		By txtCompanyName=By.xpath("//input[@id='Company']");
		
		By dropdownVendorMgr=By.xpath("//select[@id='VendorId']");
		
		By txtAdminComment=By.xpath("//textarea[@id='AdminComment']");
		
		By btnSave=By.xpath("//button[@name='save']");
		
		//methods
		
		public String getPageTitle() {
			return ldriver.getTitle();
		}
		
		public void clickOnCustoms() {
			ldriver.findElement(lnkCustomes_menu).click();
		}
		
		public void clickOnCustomsMenu() {
			ldriver.findElement(lnkCustomers_menu_item).click();
		}
		
		public void clickOnAddNew() {
			ldriver.findElement(btnAddNew).click();
		}
		
		public void setEmail(String email) {
			ldriver.findElement(txtEmail).sendKeys(email);
		}
		
		public void setPasswor(String passw) {
			ldriver.findElement(txtPassword).sendKeys(passw);
		}
		
		public void setFirstName(String fname) {
			ldriver.findElement(txtFirstName).sendKeys(fname);
		}
		
		public void setLastName(String lname) {
			ldriver.findElement(txtLastName).sendKeys(lname);
		}
		
		public void setGender(String gender){
			if(gender.equalsIgnoreCase("male")) {
				ldriver.findElement(rdMaleGender).click();
			}else {
				ldriver.findElement(rdFemaleGender).click();
			}
			
		}
		
		public void setDOB(String dob) {
			
			ldriver.findElement(txtDOB).sendKeys(dob);
			
		}
		
		public void setCompanyName(String codName) {
			ldriver.findElement(txtCompanyName).sendKeys(codName);
		}
		
		public void setAdminComment(String adminComment) {
			ldriver.findElement(txtAdminComment).sendKeys(adminComment);
		}
		
		public void clickOnSave() {
			ldriver.findElement(btnSave).click();
		}
	
	
	

}
