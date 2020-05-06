package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class LoginPage extends BasePage
{
	@FindBy(id = "ctl00_ContentPlaceHolder_txtCompanyName")
	private WebElement companyName;
	
	@FindBy(id="ctl00_ContentPlaceHolder_lnkCompany")
	private WebElement rideTheLeaseWave;
	
	@FindBy(id="ctl00_ContentPlaceHolder_loginControl_txtUserName")
	public WebElement userName;
	
	@FindBy(id="ctl00_ContentPlaceHolder_loginControl_txtPassword")
	private WebElement password;
	
	@FindBy(id="ctl00_ContentPlaceHolder_loginControl_cmdLogin1_cmdButtonControl")
	private WebElement loginButton;
	
	@FindBy(id="ctl00_ctl04_lnkSignOut")
	private WebElement logoutButton;
	
	public LoginPage(WebDriver driver,ExtentTest test)
	{
	super(driver, test);
	PageFactory.initElements(driver, this);
	}
	
	public void setCompanyName(String comName)
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(companyName));
		companyName.clear();
		companyName.sendKeys(comName);
	}
	
	public void rideTheLeaseWave()
	{
		rideTheLeaseWave.click();
	}
	
	public void setuserName(String un)
	{
		userName.clear();
		userName.sendKeys(un);
	}
	
	public void setPassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickOnLogin()
	{
		loginButton.click();
	}
	
	public void clickOnLogOut()
	{
		logoutButton.click();
	}
	
	public void handleAlert()
	{
		try
		{
			WebDriverWait wt= new WebDriverWait(driver, 2);
			wt.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		
		catch (Exception e) 
		{
			System.out.println("Alert is not present waited for 2 sec");
		}
	}
	
}
