package dataBaseConnection;

import generic.DataBaseVerification;

public class GlobalParameterGenerator 
{

		public int customerGlobalParameterGenerator()
		{
				DataBaseVerification databaseverification = new DataBaseVerification();
				String CustomerGlobalParameter_String = databaseverification.fetchinSingleValueDataFromDB("select  Max (CustomerID)+1  from Customer_profile");
				int CustomerGlobalParameter = Integer.parseInt(CustomerGlobalParameter_String);
				return CustomerGlobalParameter;
		}
		
		
		public int assetGlobalParameterGenerator()
		{
				DataBaseVerification databaseverification = new DataBaseVerification();
				String assetGlobalParameter_String = databaseverification.fetchinSingleValueDataFromDB("select  Max (InventoryId)+1 from Inventory_Profile");
				int assetGlobalParameter = Integer.parseInt(assetGlobalParameter_String);
				return assetGlobalParameter;
		}
		
		
		public int vendorInvoiceGlobalParameterGenerator()
		{
				DataBaseVerification databaseverification = new DataBaseVerification();
				String  vendorInvoiceGlobalParameter_String = databaseverification.fetchinSingleValueDataFromDB("select  Max (VendorInvoiceID)+1  from ApInvoice_profile");
				int vendorInvoiceGlobalParameter = Integer.parseInt(vendorInvoiceGlobalParameter_String);
				return vendorInvoiceGlobalParameter;
		}

}
