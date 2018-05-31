package com.csg.sone.base.helper;

import com.csg.sone.base.util.DateUtil;
import com.csg.sone.base.util.JSONUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * <p> Description:  ExcelHelperTest </p >
 * <pre> </pre>
 *
 * Copyright:  2012-2017 . All rights reserved.
 * Company:
 *
 * @author sultan
 * @version 1.0
 */
public class ExcelHelperTest {

    String classPath = "";
    List<List<Object>> rowList = new ArrayList<List<Object>>();
    List<Object> cellList = new ArrayList<Object>();

    @Before
    public void setUp() {
        cellList.add("第一列");
        cellList.add("第二列");
        cellList.add("第三列");
        cellList.add("第四列");
        cellList.add("第五列");
        cellList.add("第六列");
        cellList.add("第七列");
        cellList.add("第八列");
        rowList.add(cellList);
        for (int i = 0; i < 10; i++) {
            cellList = new ArrayList<Object>();
            cellList.add(123);
            cellList.add("ABC");
            cellList.add(DateUtil.parseDate("2017-01-01 01:01:01", "yyyy-MM-dd HH:mm:ss"));
            cellList.add(100.123D + i);
            cellList.add(100.123F + i);
            cellList.add("");
            cellList.add("123.123F");
            rowList.add(cellList);
        }

    }

    @Test
    public void createExcel() {
        String classPath = this.getClass().getResource("").getPath() + "test.xls";

        Workbook workbook = ExcelHelper.createXLSWorkbook();
        Sheet sheet = ExcelHelper.createSheet(workbook, "测试工作簿");
        Row rowHead = ExcelHelper.createRow(sheet, 0);
        List headList = rowList.get(0);
        for (int i = 0; i < headList.size(); i++) {
            Cell cell = ExcelHelper.createCell(rowHead, i);
            ExcelHelper.setCell(cell, headList.get(i));
        }

        for (int i = 1; i < rowList.size(); i++) {
            Row rowDate = ExcelHelper.createRow(sheet, i);
            List cells = rowList.get(i);
            for (int j = 0; j < cells.size(); j++) {
                Cell cell = ExcelHelper.createCell(rowDate, j);
                ExcelHelper.setCell(cell, cells.get(j));
            }
        }
        ExcelHelper.writeExcelFile(workbook, classPath);

    }

    @Test
    public void getExcelData() {
        String classPath = this.getClass().getResource("").getPath() + "test.xls";
        Workbook workbook = ExcelHelper.getWorkbook(classPath);
        Sheet sheet = ExcelHelper.getSheet(workbook, "测试工作簿");
        List rows = new ArrayList();
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            Row row = ExcelHelper.getRow(sheet, i);
            List cells = new ArrayList();
            for (int j = 0; j < row.getLastCellNum(); j++) {

                Cell cell = ExcelHelper.getCell(row, j);
                cells.add(ExcelHelper.getCellValue(cell));
            }
            rows.add(cells);
        }


        Cell cell = ExcelHelper.getCell(sheet, 0, 0);
        Object object = ExcelHelper.getCellValue(cell);
        assertEquals(object, "第一列");

        List list = ExcelHelper.getRowsData(sheet, 0);
        assertEquals(JSONUtil.format(list), JSONUtil.format(rowList));

        list = ExcelHelper.getRowsData(sheet, 2, 3);
        assertEquals(JSONUtil.format(list), JSONUtil.format(rowList.subList(2, 3)));

        assertEquals(JSONUtil.format(rows), JSONUtil.format(rowList));
    }
}