package testDataProvider_Repository_ModuleLevel;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class CustomerDataProvider extends DataProviderGenerator {

	// Customer Data Provider
		@DataProvider(name ="DataProvider_CreateCustomer")
		public static Object[][] CustomerCreation()
		{
			
			String excelName = "CreateCustomer_ExcelModel";
			Object[][] customerdata=objectGeneratorWithMultiSheet(excelName);
			return customerdata; 
		
		}
}
