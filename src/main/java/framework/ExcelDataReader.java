package framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Dineshkumar
 *
 */
public class ExcelDataReader {

	/**
	 * This method used to read the excel data in a key value pair
	 * @param excelFilePath
	 * @return Map
	 */
	public static Map<String, String> readExcel(String excelFilePath) {
		Map<String, String> keyValueMap = new HashMap<>();

		try {
			FileInputStream fis = new FileInputStream(excelFilePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			Row keyRow = sheet.getRow(0);
			Row valueRow = sheet.getRow(1);

			Iterator<Cell> keyIterator = keyRow.cellIterator();
			Iterator<Cell> valueIterator = valueRow.cellIterator();

			while (keyIterator.hasNext() && valueIterator.hasNext()) {
				Cell keyCell = keyIterator.next();
				Cell valueCell = valueIterator.next();

				String key = keyCell.getStringCellValue();
				String value = valueCell.getStringCellValue();

				keyValueMap.put(key, value);
			}

			workbook.close();
			fis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return keyValueMap;
	}
}
