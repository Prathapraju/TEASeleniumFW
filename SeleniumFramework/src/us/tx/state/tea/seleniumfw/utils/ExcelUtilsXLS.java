package us.tx.state.tea.seleniumfw.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;


/**
 *
 * @author ckutac
 */
public class ExcelUtilsXLS {
    private HSSFSheet ExcelWSheet;
    private HSSFWorkbook ExcelWBook;
    private HSSFCell Cell;
    private HSSFRow Row;
    private FileOutputStream fileOut;
    
    //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
    public HSSFSheet setExcelFile(String Path,String SheetName) throws Exception {
        try {
        // Open the Excel file
	FileInputStream ExcelFile = new FileInputStream(Path);
	// Access the required test data sheet
	ExcelWBook = new HSSFWorkbook(ExcelFile);
	ExcelWSheet = ExcelWBook.getSheet(SheetName);
	} catch (Exception e){
	throw (e);
	}
        return ExcelWSheet;
}

    public String getCellData(int RowNum, int ColNum) throws Exception {
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
			} else {
				CellData = "";
			}
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	public String getStringCellData(int RowNum, int ColNum) throws Exception {
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
	public int getIntCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = (ExcelWSheet.getRow(RowNum).getCell(ColNum));
			// = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			int CellData = (int) Cell.getNumericCellValue();
			return CellData;
		} catch (Exception e) {
			return 0;
		}
	}

	public int rowCount(HSSFSheet excelsheet) {
		return excelsheet.getLastRowNum() + 1;
	}

	public int columnCount(HSSFSheet excelsheet) {
		return excelsheet.getRow(0).getLastCellNum();
	}

	// This method is to write in the Excel cell, Row num and Col num are the
	// parameters
	public void setCellData(String Result, int RowNum, int ColNum) throws Exception {
		Row = ExcelWSheet.getRow(RowNum);
		// Cell = Row.getCell(ColNum, Row);
		if (Cell == null) {
			Cell = Row.createCell(ColNum);
			Cell.setCellValue(Result);
		} else {
			Cell.setCellValue(Result);
		}
	}

	public void saveWorkbook(String filename) throws Exception {
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