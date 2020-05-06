package testDataProvider_Repository_ModuleLevel;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class AssetSplitDataProvider extends DataProviderGenerator {

	// Asset Split Data Provider
		@DataProvider(name ="DataProvider_AssetSplit")
		public static Object[][] assetSplitDataProvider()
		{
			
			String excelName = "AssetSplit_ExcelModel";
			Object[][] assetSplitData=objectGeneratorWithMultiSheet(excelName);
			return assetSplitData; 
		
		}
}
