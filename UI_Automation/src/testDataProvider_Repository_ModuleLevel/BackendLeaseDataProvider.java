package testDataProvider_Repository_ModuleLevel;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class BackendLeaseDataProvider extends DataProviderGenerator {
	
	// Back end Lease Data Provider
	@DataProvider(name ="DataProvider_CreateBackendLease")
	public static Object[][] BackendLease()
	{
		
		String excelName = "CreateBackendLease_ExcelModel";
		Object[][] leaseData=objectGeneratorWithMultiSheet(excelName);
		return leaseData; 
	
	}

}
