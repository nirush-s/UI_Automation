package testDataProvider_Repository_ModuleLevel;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class LeaseSyndicationDataProvider extends DataProviderGenerator  {
	
	// Syndication Data Provider
	@DataProvider(name ="DataProvider_Syndication")
	public static Object[][] Syndication()
	{
		
		String excelName = "LeaseSyndication_ExcelModel";
		Object[][] Syndication=objectGeneratorWithMultiSheet(excelName);
		return Syndication; 
	
	}

}
