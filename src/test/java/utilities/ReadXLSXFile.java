package utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

public class ReadXLSXFile {
	
		public String[][] readXLSXFile(String filepath, String type)
	{
		String [][] data = null;
		
		File file = new File(filepath);
		try 
		{
			FileInputStream fileinputstream = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fileinputstream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			int rowCount = sheet.getLastRowNum();
			int columnCount= sheet.getRow(0).getLastCellNum();
			
			data = new String[rowCount][columnCount];
			
			for(int i=1; i<=rowCount; i++)
			{
				XSSFRow row = sheet.getRow(i);
				for(int j=0; j<columnCount; j++)
				{
					data[i-1][j]=row.getCell(j).getStringCellValue();
				}
			}
			
			fileinputstream.close();
			workbook.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage());
		}
		
		return data;
	}
}
