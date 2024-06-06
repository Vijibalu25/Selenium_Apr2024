package Marathon3;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelOpportunity {
	
	public static String[][] readData() throws IOException
	{
		XSSFWorkbook oppBook = new XSSFWorkbook("./data/Opportunity.xlsx");
		
		XSSFSheet oppSheet = oppBook.getSheet("Sheet1");
		
		int oppRowCount = oppSheet.getLastRowNum();
		
		short oppColcount = oppSheet.getRow(oppRowCount).getLastCellNum();
		
		System.out.println(oppRowCount);
		System.out.println(oppColcount);
		
		String[][] inputData = new String[oppRowCount][oppColcount];
		
		for(int i=1; i<=oppRowCount; i++)
		{
			for(int j=0; j<oppColcount; j++)
			{
				String stringCellValue = oppSheet.getRow(i).getCell(j).getStringCellValue();
				inputData[i-1][j]=stringCellValue;
			}
		}
		
		oppBook.close();
		return inputData;


	}

}
