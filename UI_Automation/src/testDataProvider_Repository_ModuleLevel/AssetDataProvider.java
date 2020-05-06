package testDataProvider_Repository_ModuleLevel;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class AssetDataProvider extends DataProviderGenerator  {

	// Asset Data Provider
	@DataProvider(name ="DataProvider_CreateAsset")
	public static Object[][] AssetCreation()
	{
		
		String excelName = "CreateAsset_ExcelModel";
		//Object[][] leaseData=objectGenerator(excelName,"LeaseParameters");
		Object[][] assetData=objectGeneratorWithSingleSheet(excelName, "Data For Inventory Creation");
		return assetData; 
	
	}
}
