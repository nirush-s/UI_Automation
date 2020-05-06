package testDataProvider_Repository_ModuleLevel;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class DataProviderClass extends DataProviderGenerator  {

	// Asset Data Provider
	@DataProvider(name ="DataProvider_CreateData")
	public static Object[][] DataCreation()
	{
		
		String excelName = "CreateData_ExcelModel";
		//Object[][] leaseData=objectGenerator(excelName,"LeaseParameters");
		Object[][] Data=objectGeneratorWithSingleSheet(excelName, "Data");
		return Data; 
	
	}
}
