package testDataProvider_Repository_ModuleLevel;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class LeaseWritedownDataProvider extends DataProviderGenerator  {

	// Lease Writedown Data Provider
	@DataProvider(name ="DataProvider_LeaseWritedown")
	public static Object[][] leaseWritedownDataProvider()
	{
		
		String excelName = "LeaseWriteDown_ExcelModel";
		Object[][] leaseWriteDownData=objectGeneratorWithMultiSheet(excelName);
		return leaseWriteDownData; 
	
	}

}
