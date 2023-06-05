package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="login_data")
	public String[][] getData() throws IOException{
		
		 ExcelUtility utlity= new ExcelUtility(".\\testdata\\Opencart_LoginData.xlsx");
		 int rowCount=utlity.getRowCount("Sheet1");
		 int colCount=utlity.getCellCount("Sheet1", 1);
		 String data[][]= new String[rowCount][colCount];
		 for(int i=1;i<=rowCount;i++) {
			 for(int j=0;j<colCount;j++) {
				 data[i-1][j]=utlity.getCellData("Sheet1",i,j);
			 }
		 }
		 return data;
	}

}
