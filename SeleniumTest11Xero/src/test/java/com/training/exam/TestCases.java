package com.training.exam;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.relevantcodes.extentreports.LogStatus;

public class TestCases extends ReusableMethods {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		TC1A();
		TC1B();		
		TC1C();
		TC1D(); 		
		TC2A();
		TC2B();
		TC2C();
		TC2D();
		TC2E();
		TC3A();
		TC4A();
		TC6A();
		TC8A();
		TC8B();
		TC8C();	
		TC10A();

	}

	//Successful Login
	public static  void TC1A() {
		initializeDriver();
		launchUrl("https://login.xero.com/");
		extentReports("tc1A");
		Login("kharoteneha29@gmail.com","nehamandar1");
		System.out.println(driver.getTitle());
		endReport();		
	}

	/*Username Valid
	Incorrect password*/
	public static void TC1B() throws IOException {
		try {
			initializeDriver();
			launchUrl("https://login.xero.com/");
			extentReports("tc1B");
			String[][] recdata=readExcel("D:\\JavaPrograms\\SeleniumTestXero\\ExcelData\\Data1.xls","Data1.xls","Sheet1");
			//Login("kharoteneha29@gmail.com","neha");
			WebElement un = findElement(By.xpath("//input[@placeholder='Email address']"), "Username");
			enterText(un, "username", recdata[1][0]);

			WebElement pass = findElement(By.xpath("//input[@id='password']"), "Password");
			enterText(pass, "Password", recdata[1][1]);

			WebElement lg=findElement(By.xpath("//button[@id='submitButton']"),"Log In");
			clickButton(lg,"Login");

			String string1=findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect')]"), "Error msg").getText();
			String string2="Your email or password is incorrect";
			validateText(string1,string2);
			System.out.println("Error message :" + string1);
			logger.log( LogStatus.PASS, "Error message :" + string1);
		}catch(Exception E)
		{
			endReport();
		}
	}

	/*Invalid Username
	 *Valid Password*/ 
	public static void TC1C() throws IOException {
		try
		{
			initializeDriver();
			launchUrl("https://login.xero.com/");
			extentReports("tc1C");
			String[][] recdata=readExcel("D:\\JavaPrograms\\SeleniumTestXero\\ExcelData\\Data1.xls","Data1.xls","Sheet1");
			//Login("kharoteneha29@gmail.com","neha");
			WebElement un = findElement(By.xpath("//input[@placeholder='Email address']"), "Username");
			enterText(un, "username", recdata[2][0]);

			WebElement pass = findElement(By.xpath("//input[@id='password']"), "Password");
			enterText(pass, "Password", recdata[2][1]);

			WebElement lg=findElement(By.xpath("//button[@id='submitButton']"),"Log In");
			clickButton(lg,"Login");

			String string1=findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect')]"), "Error msg").getText();
			String string2="Your email or password is incorrect";
			validateText(string1,string2);
			System.out.println("Error message :" + string1);
			logger.log( LogStatus.PASS, "Error message :" + string1);
		}catch(Exception E)
		{
			endReport();
		}
	}



	//Clicked Forgot Pwd Link
	public static void TC1D() {
		initializeDriver();
		launchUrl("https://login.xero.com/");
		extentReports("tc1D");
		WebElement fp = findElement(By.xpath("//a[contains(@class,'forgot-password-advert')]"), "ForgotPassword");
		fp.click();

		WebElement un = findElement(By.xpath("//input[@id='UserName']"), "User name");
		enterText(un, "User name", "kharoteneha29@gmail.com");		

		WebElement click=findElement(By.xpath("//span[contains(@class,'text')]"),"SendLink");
		clickButton(click,"SendLink");

		endReport();
	}

	/*New User
	 * Free Trial 
	 * Enter Details of the Form
	 */
	public static void TC2A() throws IOException {
		try
		{
		initializeDriver();
		launchUrl("https://www.xero.com/");
		extentReports("tc2A");

		WebElement click=findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"),"FreeTrial");
		clickButton(click,"FreeTrial");		
		String[][] recdata=readExcel("D:\\JavaPrograms\\SeleniumTestXero\\ExcelData\\Data1.xls","Data1.xls","Sheet2");

		WebElement fn = findElement(By.xpath("//input[@name='FirstName']"), "FirstName");
		enterText(fn, "FirstName", recdata[1][0]);		

		WebElement ln = findElement(By.xpath("//input[@name='LastName']"), "LastName");
		enterText(ln, "LastName", recdata[1][1]);		

		WebElement email = findElement(By.xpath("//input[@name='EmailAddress']"), "EmailAddress");
		enterText(email, "EmailAddress", recdata[1][2]);		

		WebElement phone = findElement(By.xpath("//input[@name='PhoneNumber']"), "PhoneNumber");
		enterText(phone, "PhoneNumber", recdata[1][3]);

		WebElement dd= findElement(By.xpath("//*[@class='form-select-arrow icon']"), "DropDown");
		enterText(dd, "DropDown", "United States");

		WebElement iframe= findElement(By.xpath("//div[@class='g-recaptcha form-group']"), "Frame");
		driver.switchTo().frame(iframe);

		WebElement iframe_CheckBox=driver.findElement(By.xpath(""));
		iframe_CheckBox.click();		
		}catch(Exception E)
		{
		endReport();
		}
	}


	public static  void TC2B() throws InterruptedException {
		try
		{
		initializeDriver();
		launchUrl("https://www.xero.com/");
		Thread.sleep(3000);
		extentReports("tc2B");
		WebElement freeTrial=findElement(By.xpath("//li[@class='global-ceiling-bar-cta2']"),"Free Trial");
		clickButton(freeTrial,"FreeTrial");

		WebElement getStarted=findElement(By.xpath("//span[@class='g-recaptcha-submit']"),"Get started");
		clickButton(getStarted,"Get started");

		WebElement msg1 = findElement(By.id("signup-form-error-message-1"), "ErrorFirstName");
		String str1=msg1.getText();
		validateText(str1,"First name can't be empty");

		WebElement msg2 = findElement(By.id("signup-form-error-message-2"), "ErrorLastName");
		String str2=msg2.getText();
		validateText(str2,"Last name can't be empty");

		WebElement msg3 = findElement(By.id("signup-form-error-message-3"), "ErrorEmailAddress ");
		String str3=msg3.getText();
		validateText(str3,"Email address can't be empty");

		WebElement msg4 = findElement(By.id("signup-form-error-message-4"), "ErrorPhoneNumber ");
		String str4=msg4.getText();
		validateText(str4,"Phone number can't be empty");

		WebElement email = findElement(By.xpath("//input[@name='EmailAddress']"), "EmailAddress ");
		enterText(email, "EmailAddress", "afdsgfghjhg$gmail.com");	

		WebElement getStarted1=findElement(By.xpath("//span[@class='g-recaptcha-submit']"),"Get started");
		clickButton(getStarted1,"Get started");


		String str5= findElement(By.xpath("//span[@id='signup-form-error-message-3']"), "EmailAddress ").getText();
		validateText(str5,"Email address is invalid");
		System.out.println("Email address is invalid");
		}catch(Exception E)
		{
		endReport();
		}
	}

	public static void TC2C() throws InterruptedException {
		try
		{
		initializeDriver();
		launchUrl("https://www.xero.com/");
		extentReports("tc2C");
		Thread.sleep(2000);

		WebElement freeTrial=findElement(By.xpath("//li[@class='global-ceiling-bar-cta2']"),"Free Trial");
		clickButton(freeTrial,"FreeTrial");	

		String parent=driver.getWindowHandle();
		// This will return the number of windows opened by Webdriver and will return Set of St//rings
		Set<String>s1=driver.getWindowHandles();
		// Now we will iterate using Iterator
		Iterator<String> I1= s1.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			// Here we will compare if parent window is not equal to child window then we            will close
			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
				String name=driver.switchTo().window(child_window).getTitle();
				validateText(name, "Terms of Use | Xero US");
				driver.close();
			}

		}
		// once all pop up closed now switch to parent window
		driver.switchTo().window(parent);
		WebElement privacynotice=findElement(By.xpath("//a[contains(text(),'privacy notice')]"),"Privacy notice ");
		clickButton(privacynotice,"Privacy notice");
		}catch(Exception E)
		{
		endReport();
		}
	}

	public static void TC2D() {
		initializeDriver();
		launchUrl("https://www.xero.com/");
		extentReports("tc2D");
		WebElement freeTrial=findElement(By.xpath("//li[@class='global-ceiling-bar-cta2']"),"Free Trial");
		clickButton(freeTrial,"FreeTrial");
		WebElement offerdetails=findElement(By.xpath("//a[contains(text(),'offer details')]"),"Offer Details "); 
		clickButton(offerdetails,"Offer Details");
		endReport();

	}

	public static void TC2E() {
		initializeDriver();
		launchUrl("https://www.xero.com/");
		extentReports("tc2E");
		WebElement freeTrial=findElement(By.xpath("//li[@class='global-ceiling-bar-cta2']"),"Free Trial");
		clickButton(freeTrial,"FreeTrial");
		WebElement book=findElement(By.xpath("//a[contains(text(),'accountant or bookkeeper')]"),"Accountant or Bookkeeper");
		clickButton(book,"Accountant or Bookkeeper");
		endReport();

	}
	public static void TC3A() {
		initializeDriver();
		launchUrl("https://login.xero.com/");
		extentReports("tc3A");
		Login("kharoteneha29@gmail.com","nehamandar1");

		WebElement dashboard=findElement(By.xpath("//a[@class='xrh-focusable xrh-tab--body xrh-tab--body-is-selected']"),"DashBoard");
		clickButton(dashboard,"DashBoard");
		WebElement business=findElement(By.xpath("//a[@class='xrh-focusable xrh-tab--body xrh-tab--body-is-selected']"),"Business");
		clickButton(business,"Business");
		findElement(By.xpath("//a[contains(text(),'Invoices')]"),"Invoices").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Quotes')]"),"Quotes").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Bills to pay')]"),"Bills to pay").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Purchase orders')]"),"Purchase orders").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Purchases overview')]"),"Purchases overview").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Expense claims')]"),"Expense claims").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Expense claims')]"),"Expense claims").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Checks')]"),"Checks").isDisplayed();
		WebElement account=findElement(By.xpath("//button[contains(text(),'Accounting')]"),"Account");
		clickButton(account,"Account");
		findElement(By.xpath("//a[contains(text(),'Bank accounts')]"),"Bank accounts").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Reports')]"),"Reports").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Advanced')]"),"Advanced").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Account Transactions')]"),"Account Transactions").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Aged Payables Summary')]"),"Aged Payables Summary").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Aged Receivables Summary')]"),"Aged Receivables Summary").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Balance Sheet')]"),"Balance Sheet").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Income Statement')]"),"Income Statement").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Sales Tax Report')]"),"Sales Tax Report").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Chart of accounts')]"),"Chart of accounts").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Fixed assets')]"),"Fixed assets").isDisplayed();
		WebElement reports=findElement(By.xpath("//a[contains(text(),'Reports')]"),"Reports");
		clickButton(reports,"Reports");

		WebElement contact=findElement(By.xpath("//button[contains(text(),'Contacts')]"),"Contacts");
		clickButton(contact,"Contacts");
		findElement(By.xpath("//a[contains(text(),'All contacts')]"),"All contacts").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Customers')]"),"Customers").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Suppliers')]"),"Suppliers").isDisplayed();
		WebElement abc=findElement(By.xpath("//div[@class='xrh-appbutton--body']"),"abc");
		clickButton(abc,"abc");
		findElement(By.xpath("//a[contains(text(),'Files')]"),"Files").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Settings')]"),"Settings").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Subscription and billing')]"),"Subscription and billing").isDisplayed();
		findElement(By.xpath("//a[@title='Demo Company']"),"Demo Company").isDisplayed();
		findElement(By.xpath("//a[@class='xrh-verticalmenuitem--body xrh-verticalmenuitem--body-blue']"),"Add new Organization").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Payroll powered by Gusto')]"),"Payroll powered by Gusto").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Projects')]"),"Projects").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'WorkflowMax')]"),"WorkflowMax").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'App marketplace')]"),"App marketplace").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'My Xero')]"),"My Xero").isDisplayed();

		WebElement setting =findElement(By.xpath("//a[contains(text(),'Settings')]"),"Setting");
		clickButton(setting,"Setting");

		WebElement plus=findElement(By.xpath("//button[@title='Create new']//div[@class='xrh-focusable--child xrh-iconwrapper']"),"CreateNew");
		clickButton(plus,"CreateNew");
		findElement(By.xpath("//div[@class='xrh-dropdown-layout xrh-addon--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionright']//a[@class='xrh-verticalmenuitem--body'][contains(text(),'Invoice')]"),"Invoice").isDisplayed();
		findElement(By.xpath("//div[@class='xrh-dropdown-layout xrh-addon--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionright']//a[@class='xrh-verticalmenuitem--body'][contains(text(),'Bill')]"),"Bill").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Contact')]"),"Contact").isDisplayed();
		findElement(By.xpath("//div[@class='xrh-dropdown-layout xrh-addon--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionright']//a[@class='xrh-verticalmenuitem--body'][contains(text(),'Quote')]"),"Quote").isDisplayed();
		findElement(By.xpath("//div[@class='xrh-dropdown-layout xrh-addon--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionright']//a[@class='xrh-verticalmenuitem--body'][contains(text(),'Purchase order')]"),"Purchase order").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Spend money')]"),"Spend money").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Receive money')]"),"Receive money").isDisplayed();
		findElement(By.xpath("//a[contains(text(),'Transfer money')]"),"Transfer money").isDisplayed();

		WebElement abc1 =findElement(By.xpath("//div[@class='xrh-appbutton--body']"),"abc1 ");
		clickButton(abc1,"abc1");

		WebElement files =findElement(By.xpath("//a[contains(text(),'Files')]")," Files");
		clickButton(files,"Files");


		WebElement notifications =findElement(By.xpath("//button[@title='Notifications']//div[@class='xrh-focusable--child xrh-iconwrapper']"),"Notifications ");
		clickButton(notifications,"Notifications");

		WebElement search =findElement(By.xpath("//button[@title='Search']//div[@class='xrh-focusable--child xrh-iconwrapper']"),"search");
		clickButton(search,"search");

		WebElement help =findElement(By.xpath("//button[@title='Help']//div[@class='xrh-focusable--child xrh-iconwrapper']"),"help ");
		clickButton(help,"help");


		/*	

		notifications=
		search=
		help=
		 */
	}	

	public static void TC4A() throws InterruptedException {
		initializeDriver();
		launchUrl("https://login.xero.com/");
		extentReports("tc4A");
		Login("kharoteneha29@gmail.com","nehamandar1");	
		Thread.sleep(3000);	
		WebElement usermenu =findElement(By.xpath("//abbr[@class='xrh-avatar xrh-avatar-color-6']"),"Usermenu");
		clickButton(usermenu,"Usermenu");

		WebElement logout =findElement(By.xpath("//div[@class='xrh-dropdown-layout xrh-addon--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionright']//a[@class='xrh-verticalmenuitem--body'][contains(text(),'Log out')]"),"Logout ");
		clickButton(logout,"Logout");

		Thread.sleep(3000);
		WebElement name=findElement(By.xpath("//input[@id='email']"),"Username");
		String actual=name.getText();
		System.out.println(actual);
		String expected="kharoteneha29@gmail.com";
		validateText(actual,expected);

		endReport();	
	}



	public static void TC6A() throws InterruptedException {
		initializeDriver();
		launchUrl("https://login.xero.com/");
		extentReports("tc4A");
		Login("kharoteneha29@gmail.com","nehamandar1");	
		Thread.sleep(3000);	
		WebElement usermenu =findElement(By.xpath("//abbr[@class='xrh-avatar xrh-avatar-color-6']"),"Usermenu");
		clickButton(usermenu,"Usermenu");
		WebElement edit =findElement(By.xpath("//li[@class='xrh-addon xrh-addon-lastvisible']//li[1]//a[1]"),"EditProfile ");
		clickButton(edit,"EditProfile");
		WebElement img =findElement(By.xpath("//div[@id='button-1041']"),"Uploadimage ");
		clickButton(img,"Uploadimage");
		WebElement browse =findElement(By.xpath("//td[@id='filefield-1174-browseButtonWrap']"),"browsePic");
		clickButton(browse,"browsePic");


	}

	public static void TC8A() throws InterruptedException {
		initializeDriver();
		launchUrl("https://login.xero.com/");
		extentReports("tc8A");
		Login("gopala.anumanchipalli@gmail.com","password12");	

		WebElement aaa=findElement(By.xpath("//div[@class='xrh-appbutton--body']"),"aaa");
		clickButton(aaa,"aaa");

		WebElement myxero=findElement(By.xpath("//a[contains(text(),'My Xero')]"),"MyXero");
		clickButton(myxero,"MyXero");

		System.out.println(driver.getCurrentUrl());

		Set<String> getAllwindows=driver.getWindowHandles();
		String[] getwin=getAllwindows.toArray(new String[getAllwindows.size()]);
		System.out.println(getAllwindows.size());
		driver.switchTo().window(getwin[1]);
		System.out.println(driver.getCurrentUrl());	

		WebElement org=findElement(By.xpath("//a[@class='x-btn green']"),"Add Organisation ");
		clickButton(org,"Add Organisation ");

		WebElement name = findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/table[2]/tbody[1]/tr[1]/td[2]/input[1]"), "name");
		name.sendKeys("Self");
		WebElement country = findElement(By.xpath("//input[@id='countryCmb-inputEl']"), "country");
		country.sendKeys("United States");
		WebElement timeselect = findElement(By.xpath("//*[@id=\"cmbTimeZone-inputEl\"]"),"Timeselect");
		timeselect.sendKeys("(UTC-08:00) Pacific Time (US & Canada)");
		WebElement industry = findElement(By.xpath("//input[@id='industrysearchcombofield-1025-inputEl']"), "industry");
		industry.sendKeys("Accounting");
		Thread.sleep(4000);
		WebElement StartTrial = findElement(By.id("simplebutton-1035"), "StartTrial");
		StartTrial.click();

		endReport();
	}

	public static void TC8B() throws InterruptedException {
		initializeDriver();
		launchUrl("https://login.xero.com/");
		extentReports("tc8A");
		Login("gopala.anumanchipalli@gmail.com","password12");	

		WebElement aaa=findElement(By.xpath("//div[@class='xrh-appbutton--body']"),"aaa");
		clickButton(aaa,"aaa");

		WebElement myxero=findElement(By.xpath("//a[contains(text(),'My Xero')]"),"MyXero");
		clickButton(myxero,"MyXero");

		System.out.println(driver.getCurrentUrl());

		Set<String> getAllwindows=driver.getWindowHandles();
		String[] getwin=getAllwindows.toArray(new String[getAllwindows.size()]);
		System.out.println(getAllwindows.size());
		driver.switchTo().window(getwin[1]);
		System.out.println(driver.getCurrentUrl());	

		WebElement org=findElement(By.xpath("//a[@class='x-btn green']"),"Add Organisation ");
		clickButton(org,"Add Organisation ");

		WebElement name = findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/table[2]/tbody[1]/tr[1]/td[2]/input[1]"), "name");
		name.sendKeys("Self");
		WebElement country = findElement(By.xpath("//input[@id='countryCmb-inputEl']"), "country");
		country.sendKeys("United States");
		WebElement timeselect = findElement(By.xpath("//*[@id=\"cmbTimeZone-inputEl\"]"),"Timeselect");
		timeselect.sendKeys("(UTC-08:00) Pacific Time (US & Canada)");
		WebElement industry = findElement(By.xpath("//input[@id='industrysearchcombofield-1025-inputEl']"), "industry");
		industry.sendKeys("Accounting");
		Thread.sleep(4000);
		WebElement buyNow = findElement(By.id("simplebutton-1035"), "BuyNow");
		buyNow.click();

		endReport();
	}

	public static void TC8C() throws InterruptedException {
		try
		{
		initializeDriver();
		launchUrl("https://login.xero.com/");
		extentReports("tc8C");
		Login("gopala.anumanchipalli@gmail.com","password12");	

		WebElement aaa=findElement(By.xpath("//div[@class='xrh-appbutton--body']"),"aaa");
		clickButton(aaa,"aaa");

		WebElement myxero=findElement(By.xpath("//a[contains(text(),'My Xero')]"),"MyXero");
		clickButton(myxero,"MyXero");

		System.out.println(driver.getCurrentUrl());

		Set<String> getAllwindows=driver.getWindowHandles();
		String[] getwin=getAllwindows.toArray(new String[getAllwindows.size()]);
		System.out.println(getAllwindows.size());
		driver.switchTo().window(getwin[1]);
		System.out.println(driver.getCurrentUrl());	

		WebElement org=findElement(By.xpath("//a[@class='x-btn green']"),"Add Organisation ");
		clickButton(org,"Add Organisation ");

		WebElement name = findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/table[2]/tbody[1]/tr[1]/td[2]/input[1]"), "name");
		name.sendKeys("Self");
		WebElement country = findElement(By.xpath("//input[@id='countryCmb-inputEl']"), "country");
		country.sendKeys("United States");
		
		WebElement timeselect = findElement(By.xpath("//*[@id=\"cmbTimeZone-inputEl\"]"),"Timeselect");
		timeselect.sendKeys("(UTC-08:00) Pacific Time (US & Canada)");
		WebElement industry = findElement(By.xpath("//input[@id='industrysearchcombofield-1025-inputEl']"), "industry");
		industry.sendKeys("Accounting");
		Thread.sleep(4000);
		WebElement buyNow = findElement(By.id("simplebutton-1035"), "BuyNow");
		buyNow.click();
		//String selectplan = findElement(By.xpath("//span[contains(text(),'Select a plan')]"), "Select plan").getText();
		//ystem.out.println(validate(selectplan,"Select a plan"));

		Thread.sleep(3000);
		WebElement Early = findElement(By.xpath("//section[1]//div[1]//label[1]//div[1]"),"Radio Button");

		Early.click();

		WebElement continueButton = findElement(By.id("continueButton"), "continueButton");
		clickButton(continueButton, "continueButton");

		WebElement contactAddress = findElement(By.name("contactAddress"), "contactAddress");
		enterText(contactAddress, "contactAddress","3450 granada ave");
		WebElement contactCity = findElement(By.name("contactCity"), "contactCity");
		enterText(contactCity, "contactCity","santa clara");
		WebElement postal = findElement(By.xpath("//div[@id='postalAddress']//button[@type='button']"), "postal");
		clickButton(postal, "postal");
		WebElement postalselect = findElement(By.xpath("//li[@id='California']//button[@type='button']"), "postalselect");
		postalselect.click();
		WebElement contactPostalCode = findElement(By.id("contactPostalCode"), "contactPostalCode");
		enterText(contactPostalCode,"contactPostalCode", "95051");
		WebElement continueButton1 = findElement(By.xpath("//button[contains(text(),'Continue to Review & Pay')]"), "continueButton1");
		clickButton(continueButton1, "continueButton1");

		WebElement frame=findElement(By.xpath("//*[@id=\"stripe-card-number\"]/div/iframe"),"card number iframe");
		driver.switchTo().frame(frame);
		System.out.println("Switched to frame"+ frame);
		WebElement cardnumber = findElement(By.name("cardnumber"), "cardnumber");
		cardnumber.sendKeys("12345");	
		driver.switchTo().defaultContent();

		WebElement frame2=findElement(By.xpath("//*[@id=\"stripe-card-cvc\"]/div/iframe"),"card cvc iframe");
		driver.switchTo().frame(frame2);
		WebElement cardcvc = findElement(By.name("cvc"), "cardcvc");
		cardcvc.sendKeys("1231");
		driver.switchTo().defaultContent();

		WebElement cardholdername = findElement(By.xpath("//*[@id=\"stripe-cardholder-name\"]"), "card holder name");
		cardholdername.sendKeys("abc");
		WebElement frame1=findElement(By.xpath("//*[@id=\"stripe-card-expiry\"]/div/iframe"),"card expiry iframe");
		driver.switchTo().frame(frame1);
		WebElement cardexpiry = findElement(By.name("exp-date"), "cardexpiry");
		cardexpiry.sendKeys("3/12/2020");	
		driver.switchTo().defaultContent();
		WebElement continueButton2 = findElement(By.id("continueButton"), "Confirm Purchase");
		clickButton(continueButton2, "Confirm Purchase");
		}catch(Exception E)
		{
		endReport();
		}
	}

	public static void TC10A() throws InterruptedException {
		initializeDriver();
		launchUrl("https://login.xero.com/");
		extentReports("tc10A");	
		Login("kharoteneha29@gmail.com","nehamandar1");	
		Thread.sleep(3000);	
		endReport();
	}
}
