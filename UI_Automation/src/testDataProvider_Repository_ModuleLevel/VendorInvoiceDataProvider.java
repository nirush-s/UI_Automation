package testDataProvider_Repository_ModuleLevel;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class VendorInvoiceDataProvider extends DataProviderGenerator {
	// VI Data Provider
		@DataProvider(name ="DataProvider_CreateVendorInvoice")
		public static Object[][] VICreation()
		{
			
			String excelName = "CreateVendorInvoice_ExcelModel";
			//Object[][] leaseData=objectGenerator(excelName,"LeaseParameters");
			Object[][] VIData=objectGeneratorWithSingleSheet(excelName, "Vendor Invoice Details");
			return VIData; 
		
		}

}
