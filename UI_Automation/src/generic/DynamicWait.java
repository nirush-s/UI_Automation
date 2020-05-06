package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class DynamicWait extends BasePage
{

	public DynamicWait(WebDriver driver, ExtentTest test) 
	{
		super(driver, test);
	}

	public void webDriverWait(WebElement element)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	
}
