package testDataProvider_Repository_ModuleLevel;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class LeaseAccrualNonAccrualDataProvider extends DataProviderGenerator {
	
	// Lease Non-Accrual and Accrual Data Provider
		@DataProvider(name ="DataProvider_LeaseNonAccrualAndAccrual")
		public static Object[][] LeaseNonAccrualAndAccrual()
		{
			
			String excelName = "LeaseNonAccrualAndAccrual_ExcelModel";
			Object[][] LeaseNAAndA=objectGeneratorWithMultiSheet(excelName);
			return LeaseNAAndA; 
		
		}
		

}
