package generic;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public abstract class BasePage implements AutoConst 
{
	public  WebDriver driver;
	public  ExtentTest test;
	
	public BasePage(WebDriver driver,ExtentTest test)
	{			
		this.driver=driver;
		this.test=test;
	}

	
	
	
	
	
	
	/*public void verfyTittle(String eTitle,String msg) throws IOException, InterruptedException
	{
	
			WebDriverWait wait= new WebDriverWait(driver,5);
			try
			{
				wait.until(ExpectedConditions.titleIs(eTitle));
	//			Reporter.log("Pass:Title is Matching",true);
			}
			catch(Exception e)
			{
				Reporter.log(msg,true);
				try 
				{
					System.out.println("verifying title");
					Assert.fail();
				}
				finally 
				{
					test.log(Status.FAIL, "Title is not matching"+"Expected Title is " +eTitle);
				}
			
		}
	}*/
	
	
}
