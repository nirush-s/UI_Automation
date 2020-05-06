package moduleLevel_Scenarios;

import java.util.Map;

import org.testng.annotations.Test;

import generic.BaseTest;
import moduleLevelTestScripts.CreateData_Script;
import testDataProvider_Repository_ModuleLevel.DataProviderClass;


public class CreateData_Test extends BaseTest {

	
	//Asset Script
	@Test(dataProvider = "DataProvider_CreateAsset", dataProviderClass = DataProviderClass.class)
	public void assetDataSetup(Map<String, String> map) throws Exception
	{
		test=reports.createTest("AssetCreation"+map.get("Sl No"),"Asset creation");
		CreateData_Script assetcreation = new CreateData_Script();
		assetcreation.assetCreation(driver, test, map);

		
	}
	
}
