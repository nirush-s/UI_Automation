package moduleLevelTestScripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pom.ListPage;

public class CreateAsset_Script extends BaseTest
{
	
	public void assetCreation(WebDriver driver, ExtentTest test,Map<String, String> map) throws Exception
	{
		test=reports.createTest("Data Creation Details","Details of Data created and time taken for the same");

		ListPage assetlistpage= new ListPage(driver, test);

		
		
		// Asset List page
		assetlistpage.clickOnaddButton();
		
		test.log(Status.PASS, "Asset created successfully -" +map.get("AssetAlias"));
	}
}
