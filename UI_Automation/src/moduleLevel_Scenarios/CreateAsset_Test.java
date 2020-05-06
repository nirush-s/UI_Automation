package moduleLevel_Scenarios;

import java.util.Map;

import org.testng.annotations.Test;

import generic.BaseTest;
import moduleLevelTestScripts.CreateAsset_Script;
import testDataProvider_Repository_ModuleLevel.AssetDataProvider;


public class CreateAsset_Test extends BaseTest {

	
	//Asset Script
	@Test(dataProvider = "DataProvider_CreateAsset", dataProviderClass = AssetDataProvider.class)
	public void assetDataSetup(Map<String, String> map) throws Exception
	{
		test=reports.createTest("AssetCreation"+map.get("Sl No"),"Asset creation");
		CreateAsset_Script assetcreation = new CreateAsset_Script();
		assetcreation.assetCreation(driver, test, map);

		
	}
	
}
