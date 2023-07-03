package Common_Api_methods;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Common_UtilityMethod {
	public static void EvidenceFileCreator(String Filename, String RequestBody, String ResponseBody, int statuscode)
			throws IOException {
		File NewText = new File("D:\\mssquare class recording\\RestAssure\\class notes" + Filename + ".txt");
		System.out.println("New blank file created :" + NewText.getName());

		FileWriter Data = new FileWriter(NewText);
		Data.write("Request Body is :\n" + RequestBody + "\n\n");
		Data.write("Request Code is :\n" + statuscode + "\n\n");
		Data.write("Request Body is :\n" + ResponseBody + "\n\n");

		Data.close();
		System.out.println("Data Written is the file:" + NewText.getName());
	}

	public static ArrayList<String> ReadDataExcel(String SheetName, String TestCaseName) throws IOException {
		ArrayList<String> ArrayData = new ArrayList<String>();
		// create the object of FileInputStrem to locate the file
		FileInputStream Fis = new FileInputStream("D:\\mssquare class recording\\RestAssure\\Selenium\\SahilRestAssure.xlsx");
		// Create the Object Of XSSFWorkbook to open the excel file
		XSSFWorkbook WorkBook = new XSSFWorkbook(Fis);
		// open the desire excel sheet
		int countsheet = WorkBook.getNumberOfSheets();
		for (int i = 0; i < countsheet; i++) {
			String Sheetname = WorkBook.getSheetName(i);
			// Step 4 Access the desired sheet
			if (Sheetname.equalsIgnoreCase(SheetName)) {
				// Use XSSFSheet to save the sheet into the variable
				XSSFSheet Sheet = WorkBook.getSheetAt(i);

				// Create iterator to iterate through rows and find out in which column the test
				// case names are found
				Iterator<Row> Rows = Sheet.iterator();
				Row FirstRow = Rows.next();
				// Create the iterate through the Cell of first row to find out which cell
				// contain test case name
				Iterator<Cell> CellsOfFirstRow = FirstRow.cellIterator();
				int k = 0;
				int TC_coloumn = 0;
				while (CellsOfFirstRow.hasNext()) {
					Cell CellValue = CellsOfFirstRow.next();
					if (CellValue.getStringCellValue().equalsIgnoreCase("TestCaseName")) {
						TC_coloumn = k;
						// System.out.println("Expected coloumn for TestCaseName : " +k);
						break;
					}
					k++;
				}
				// Verify the Row where the desired TestCase is found and fetch the entire Row
				while (Rows.hasNext()) {
					Row DataRow = Rows.next();
					String TCName = DataRow.getCell(TC_coloumn).getStringCellValue();
					DataRow.getCell(TC_coloumn).getStringCellValue();
					// DataRow.getCell(TC_coloumn).getNumericCellValue()
					if (TCName.equalsIgnoreCase(TestCaseName)) {

						Iterator<Cell> CellValues = DataRow.cellIterator();
						while (CellValues.hasNext()) {
							String Data = "";
							Cell CurrentCell = CellValues.next();
							try {
								String StringData = CurrentCell.getStringCellValue();
								Data = StringData;
							} catch (IllegalStateException e) {
								double doubledata = CurrentCell.getNumericCellValue();
								Data = Double.toString(doubledata);
							}
							ArrayData.add(Data);
						}
						break;
					}
				}
			}
		}
		return ArrayData;
	}
}
