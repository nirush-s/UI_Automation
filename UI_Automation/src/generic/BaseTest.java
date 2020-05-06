package generic;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pom.JobListPage;
import pom.LoginPage;

public abstract class BaseTest implements AutoConst 
{
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	public static String snap;

	
	
	// Runs before the suites runs and sets up the Reporting Functionality
	@BeforeSuite
	public void settingUpReport()
	{
		ConfigReader reader = new ConfigReader();
		htmlReporter= new ExtentHtmlReporter("./Reports/" + reader.getValueFromConfig("scenario_name") +SystemDate.systemDateWithoutTime()+".html");
		reports= new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		reports.setSystemInfo("Opereating System", "Windows7");
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("Host Name", "Nirush");
		reports.setSystemInfo("User", "Nirush S");
		
		htmlReporter.config().setDocumentTitle("AutomationReport");
		htmlReporter.config().setReportName("UI_Framework");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setChartVisibilityOnOpen(false);
	}
	

	// Runs before every method
	// Logins to the application
	@BeforeMethod
	public void openApplication() throws InterruptedException
	{
		ConfigReader reader = new ConfigReader();
				
		//Open the browser
		if(reader.getValueFromConfig("Browser") == "ie")
		{
			System.setProperty(reader.getValueFromConfig("IE_KEY"),reader.getValueFromConfig("IE_VALUE"));
			driver=new InternetExplorerDriver();
		}
		if(reader.getValueFromConfig("Browser") == "chrome")
		{
			System.setProperty(reader.getValueFromConfig("CHROME_KEY"),reader.getValueFromConfig("CHROME_VALUE"));
			driver=new ChromeDriver();
		}
		
		//if not both IE and Chrome,  we default to IE
		if(driver == null)
		{
			System.setProperty(reader.getValueFromConfig("IE_KEY"),reader.getValueFromConfig("IE_VALUE"));
			driver=new InternetExplorerDriver();
		}
		
		LoginPage loginpage=new LoginPage(driver,test);
		WebDriverWait wait= new WebDriverWait(driver, 56);
		SwitchControlToNextWindow switchcontroltonextwindow= new SwitchControlToNextWindow();
		
		//Opening the application		
		driver.get(reader.getValueFromConfig("url"));
        driver.manage().window().maximize();        
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		String currentWindow= driver.getWindowHandle();
		loginpage.setCompanyName(reader.getValueFromConfig("companyname"));
		loginpage.rideTheLeaseWave();
		Thread.sleep(2000);
		driver.close();
		switchcontroltonextwindow.waitForWndows(driver, currentWindow);		
		wait.until(ExpectedConditions.visibilityOf(loginpage.userName));
		loginpage.setuserName(reader.getValueFromConfig("username"));
		loginpage.setPassword(reader.getValueFromConfig("password"));
		loginpage.clickOnLogin();
		loginpage.handleAlert();		
	}
	
	
	//Runs after every method
	//Closes the LeaseWave application
	@AfterMethod
	public void closeApplication(ITestResult result) throws IOException, InterruptedException
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String name= result.getName();
			String screenshotpath = ScreenShot.takeScreenshot(driver, SNAP_PATH+name);
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" failed becuase of below issue", ExtentColor.RED));
			test.fail(result.getThrowable());
			//test.fail("SnapShot Below:").addScreenCaptureFromPath(screenshotpath);
			test.fail("SnapShot Below:", MediaEntityBuilder.createScreenCaptureFromPath(Paths.get("").toAbsolutePath().toString() + screenshotpath).build());
			driver.quit();
			
			try
			{
				JobListPage jl= new JobListPage(driver,test);
				snap=jl.clickOnLogDetails();
				test.fail("LogDetails Below").addScreenCaptureFromPath(snap);
				driver.quit();	
			}
			catch (Exception e) 
			{
				
			}	
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" is pass ", ExtentColor.GREEN));
			driver.quit();
		}
		
		else
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" is skipped because of below issue ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
			driver.quit();
		}
		
	}
	
	
	//Runs after the suite
	@AfterSuite
	public void tearDown()
	{
		reports.flush();
		ConfigReader reader = new ConfigReader();
		System.setProperty(reader.getValueFromConfig("CHROME_KEY"),reader.getValueFromConfig("CHROME_VALUE"));
		driver=new ChromeDriver();
		
		
		driver.get(reader.getValueFromConfig("Root_path") + "/Reports/" + reader.getValueFromConfig("scenario_name")+SystemDate.systemDateWithoutTime()+".html");
        driver.manage().window().maximize();   
	}
	

}