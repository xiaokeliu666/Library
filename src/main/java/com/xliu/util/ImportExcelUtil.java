package com.xliu.util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportExcelUtil {
    public static List<List<Object>> testReadExcel(String path) {
        List<List<Object>> res = new ArrayList<List<Object>>();
        try{
            Workbook wb = new XSSFWorkbook(path);
            for (int t = 0; t < wb.getNumberOfSheets(); t++) {
                Sheet sheet = wb.getSheetAt(t);
                Row row;
                int lastRowNum = sheet.getLastRowNum();
                for (int i = 1; i <= lastRowNum; i++) {
                    res.add(new ArrayList<Object>());
                    row = sheet.getRow(i);
                    if (row != null) {
                        for (int j = 0; j < row.getLastCellNum(); j++) {
                            Cell cell = row.getCell(j);
                            res.get(i-1).add(getCellValue(cell));
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    private static Object getCellValue(Cell cell) {
        Object result = "";
        if(cell != null) {
            switch (cell.getCellTypeEnum()) {
                case STRING:
                    result = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    double d = cell.getNumericCellValue();
                    result = new Double(d).intValue();
                    break;
                case BOOLEAN:
                    result = cell.getBooleanCellValue();
                    break;
                case ERROR:
                    result = cell.getErrorCellValue();
                    break;
                case BLANK:
                    break;
                default:
                    break;
            }
        }
        return result;
    }

}
