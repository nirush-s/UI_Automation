package testDataProvider_Repository_ModuleLevel;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class SalvageValueRestructureDataProvider extends DataProviderGenerator {
	// SalvageValueRestructure Data Provider
		@DataProvider(name ="DataProvider_SalvageValueRestructure")
		public static Object[][] LeaseSalvageValueRestructure()
		{
			
			String excelName = "SalvageValueRestructure_ExcelModel";
			Object[][] SalvageValueRestructuredata=objectGeneratorWithMultiSheet(excelName);
			return SalvageValueRestructuredata; 
		
		}

}
