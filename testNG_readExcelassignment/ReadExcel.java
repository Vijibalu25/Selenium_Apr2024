package week5.testNG_readExcelassignment;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	
	//public static String[][] main(String[] arg) throws IOException
		public static String[][] readexcel() throws IOException
		//public String[][] readexcel() throws IOException
		{
			
		
		//Set the excel workbook path
		XSSFWorkbook wbook =new XSSFWorkbook("./data/CCData.xlsx");
		
		XSSFSheet sheet = wbook.getSheet("CCDatadetails");
		
		int rowCount = sheet.getLastRowNum();
		
		int colCount = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[rowCount][colCount];
		for(int i=1; i<=rowCount; i++)
		{
			for(int j=0;j<colCount; j++)
			{
				
				String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				//System.out.println(stringCellValue);
				data[i-1][j]=stringCellValue;
			}
		}
		wbook.close();
		
		return data;
	}

		}



