package us.tx.state.tea.seleniumfw.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ckutac
 */
public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	private static FileOutputStream fileOut;

	// This method is to set the File path and to open the Excel file, Pass
	// Excel Path and Sheetname as Arguments to this method
	public static XSSFSheet setExcelFile(String Path, String SheetName) throws Exception {
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {
			throw (e);
		}
		return ExcelWSheet;
	}
	
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			String CellData = "";
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			CellType type = Cell.getCellTypeEnum();
			if (type == CellType.STRING) {
				CellData = Cell.getStringCellValue();
			} else if (type == CellType.BOOLEAN) {
				CellData = String.valueOf(Cell.getBooleanCellValue());
			} else if (type == CellType.NUMERIC) {
				CellData = String.valueOf(Cell.getNumericCellValue());
			}
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	public static String getStringCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	// This method is to read the test data from the Excel cell in Integer
	// Format, in this we are passing parameters as Row num and Col num
	public static int getIntCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = (ExcelWSheet.getRow(RowNum).getCell(ColNum));
			// = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			int CellData = (int) Cell.getNumericCellValue();
			return CellData;
		} catch (Exception e) {
			return 0;
		}
	}

	public static int rowCount(XSSFSheet ExcelWSheet) {
		return ExcelWSheet.getLastRowNum() + 1;
	}

	public static int columnCount(XSSFSheet ExcelWSheet) {
		return ExcelWSheet.getRow(0).getLastCellNum();
	}

	// This method is to write in the Excel cell, Row num and Col num are the
	// parameters
	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {
		Row = ExcelWSheet.getRow(RowNum);
		// Cell = Row.getCell(ColNum, Row);
		if (Cell == null) {
			Cell = Row.createCell(ColNum);
			Cell.setCellValue(Result);
		} else {
			Cell.setCellValue(Result);
		}
	}

	public static void saveWorkbook(String filename) throws Exception {
		try {
			fileOut = new FileOutputStream(filename);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}
}