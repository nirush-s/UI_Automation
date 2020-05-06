package testDataProvider_Repository_ModuleLevel;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class FrontendLeaseDataProvider extends DataProviderGenerator {
	
	// Front end Lease Data Provider
		@DataProvider(name ="DataProvider_CreateFrontendLease")
		public static Object[][] FrontendLease()
		{
			
			String excelName = "CreateFrontendLease_ExcelModel";
			//Object[][] leaseData=objectGenerator(excelName,"LeaseParameters");
			Object[][] leaseData=objectGeneratorWithMultiSheet(excelName);
			return leaseData; 
		
		}


}
