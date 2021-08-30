package com.nopCommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	public WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

//	By lnkCustomers_menu = By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
	By lnkCustomers_menu = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p");
	
//	By lnkCustomers_menuitem = By.xpath("//span[@class='menu-item-title'][contains(text(),'Customers')]");
	By lnkCustomers_menuitem = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");
	
//	By btnAddnew = By.xpath("//a[@class='btn bg-blue']"); // Add new
	By btnAddnew = By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a"); // Add new
	
//	By txtEmail = By.xpath("//input[@id='Email']");
	By txtEmail = By.xpath("//*[@id=\"Email\"]");
	
//	By txtPassword = By.xpath("//input[@id='Password']");
	By txtPassword = By.xpath("//*[@id=\"Password\"]");
	
//	By txtcustomerRoles = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	By txtcustomerRoles = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");	
	
//	By lstitemAdministrators = By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemAdministrators = By.xpath("//*[@id=\"34500f18-78ba-4593-b3c1-7a4e79827e7c\"]");	
	
//	By lstitemRegistered = By.xpath("//li[contains(text(),'Registered')]");
	By lstitemRegistered = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[4]");	
	
//	By lstitemGuests = By.xpath("//li[contains(text(),'Guests')]");
	By lstitemGuests = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]");	
	
//	By lstitemVendors = By.xpath("//li[contains(text(),'Vendors')]");
	By lstitemVendors = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[5]");	

//	By drpmgrOfVendor = By.xpath("//*[@id='VendorId']");
	By drpmgrOfVendor = By.xpath("//*[@id=\"VendorId\"]");
	
	By rdMaleGender = By.id("Gender_Male");
	By rdFeMaleGender = By.id("Gender_Female");
//	By rdMaleGender = By.xpath("//*[@id=\"Gender_Male\"]");
//	By rdFeMaleGender = By.xpath("//*[@id=\"Gender_Female\"]");
	
//	By txtFirstName = By.xpath("//input[@id='FirstName']");
//	By txtLastName = By.xpath("//input[@id='LastName']");
	By txtFirstName = By.id("FirstName");
	By txtLastName = By.id("LastName");
	
//	By txtDob = By.xpath("//input[@id='DateOfBirth']");
	By txtDob = By.xpath("//*[@id=\"DateOfBirth\"]");
	
//	By txtCompanyName = By.xpath("//input[@id='Company']");
	By txtCompanyName = By.xpath("//*[@id=\"Company\"]");	
	
//	By txtAdminContent = By.xpath("//textarea[@id='AdminComment']");
	By txtAdminContent = By.xpath("//*[@id=\"AdminComment\"]");	

//	By btnSave = By.xpath("//button[@name='save']");
	By btnSave = By.xpath("/html/body/div[3]/div[1]/form/div[1]/div/button[1]");

	public void clickOnCustomersMenu() {
		ldriver.findElement(lnkCustomers_menu).click();
	}

	public void clickOnCustomersMenuItem() {
		ldriver.findElement(lnkCustomers_menuitem).click();
	}

	public void clickOnAddnew() {
		ldriver.findElement(btnAddnew).click();
	}

	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}

	public void setPassword(String password) {
		ldriver.findElement(txtPassword).sendKeys(password);
	}

	public void setCustomerRoles(String role) {
		ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();

		ldriver.findElement(txtcustomerRoles).click();

		WebElement listitem;

		switch (role) {
		case "Administrators":
			listitem = ldriver.findElement(lstitemAdministrators);
			break;
		case "Guests":
			listitem = ldriver.findElement(lstitemGuests);
			break;
		case "Registered":
			listitem = ldriver.findElement(lstitemRegistered);
			break;
		case "Vendors":
			listitem = ldriver.findElement(lstitemVendors);
			break;
		default:
			listitem = ldriver.findElement(lstitemGuests);
		}

//		listitem.click(); // In Pavan's case, this will not work
		// Replaced with the following two statements
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click();", listitem);

	}

	public void setManagerOfVendor(String value) {
		Select drp = new Select(ldriver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
	}

	public void setGender(String gender) {
		if (gender.equals("Male")) {
			ldriver.findElement(rdMaleGender).click();
		} else if (gender.equals("Female")) {
			ldriver.findElement(rdFeMaleGender).click();
		} else {
			ldriver.findElement(rdMaleGender).click();// Default
		}

	}

	public void setFirstName(String fname) {
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}

	public void setLastName(String lname) {
		ldriver.findElement(txtLastName).sendKeys(lname);
	}

	public void setDob(String dob) {
		ldriver.findElement(txtDob).sendKeys(dob);
	}

	public void setCompanyName(String comname) {
		ldriver.findElement(txtCompanyName).sendKeys(comname);
	}

	public void setAdminContent(String content) {
		ldriver.findElement(txtAdminContent).sendKeys(content);
	}

	public void clickOnSave() {
		ldriver.findElement(btnSave).click();
	}

}
