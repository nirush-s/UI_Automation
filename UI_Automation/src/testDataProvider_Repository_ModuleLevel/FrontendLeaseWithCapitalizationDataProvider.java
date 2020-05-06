package testDataProvider_Repository_ModuleLevel;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class FrontendLeaseWithCapitalizationDataProvider extends DataProviderGenerator {

	// Front end Lease with Capitalization Data Provider
		@DataProvider(name ="DataProvider_FrontendLeaseWithCapitalizationSetup")
		public static Object[][] FrontendLeaseWithCapitalization()
		{
			
			String excelName = "FrontendLeaseWithCapitalization_ExcelModel";
			//Object[][] leaseData=objectGenerator(excelName,"LeaseParameters");
			Object[][] leaseDatawithCapitalization=objectGeneratorWithMultiSheet(excelName);
			return leaseDatawithCapitalization; 
		
		}
}
