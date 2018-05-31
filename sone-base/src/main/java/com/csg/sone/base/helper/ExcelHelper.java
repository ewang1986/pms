package com.csg.sone.base.helper;

import com.csg.sone.base.util.MathUtil;
import com.csg.sone.base.util.StringUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p> Description:  Helper </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author sultan
 * @version 1.0
 */

public final class ExcelHelper {

    /**
     * <p>创建一个xls格式版本的Workbook.
     * </p>
     * <pre>
     *     ExcelHelper.createXLSWorkbook() = Workbook
     * </pre>
     *
     *
     * *
     */
    public static Workbook createXLSWorkbook() {
        Workbook workbook = new HSSFWorkbook();
        return workbook;
    }

    /**
     * <p>创建一个xlsx格式版本的Workbook.
     * </p>
     * <pre>
     *      ExcelHelper.createXLSXWorkbook() = Workbook
     * </pre>
     *
     * *
     */
    public static Workbook createXLSXWorkbook() {
        Workbook workbook = new XSSFWorkbook();
        return workbook;
    }

    /**
     * <p>创建一个sheet工作薄.
     * </p>
     * <pre>
     *     ExcelHelper.createSheet(workbook) = Sheet;
     * </pre>
     *
     *  @param book
     * *
     */
    public static Sheet createSheet(Workbook book) {
        if (book != null) {
            return book.createSheet();
        }
        return null;
    }

    /**
     * <p>创建一个带名字的工作薄.
     * </p>
     * <pre>
     *     ExcelHelper.createSheet(workbook,"工作簿1") = Sheet;
     * </pre>
     *
     * @param book
     * @param name
     * *
     */
    public static Sheet createSheet(Workbook book, String name) {
        if (book != null) {
            return book.createSheet(name);
        }
        return null;
    }

    /**
     * <p>创建一个Row，设置他行数，以0为第一行.
     * </p>
     * <pre>
     *     ExcelHelper.createRow(sheet,0) = Row 1;
     * </pre>
     *
     * @param sheet
     * @param i
     * *
     */
    public static Row createRow(Sheet sheet, int i) {
        if (sheet != null) {
            return sheet.createRow(i);
        }
        return null;
    }


    /**
     * <p>创建一个单元格cell，设置他所在行的第几列，0为第一列.
     * </p>
     * <pre>
     *     ExcelHelper.createCell(row,0) = Cell 1;
     * </pre>
     *
     * @param row
     * @param i
     * *
     */
    public static Cell createCell(Row row, int i) {
        if (row != null) {
            return row.createCell(i);
        }
        return null;
    }


    /**
     * <p>设置单元格的值,参数为字符串，时间，数字.
     * </p>
     * <pre>
     *     ExcelHelper.setCell(cell,object) ;
     * </pre>
     *
     * @param cell
     * @param object
     * *
     */
    public static void setCell(Cell cell, Object object) {
        if (object != null) {
            if (object instanceof String) {
                cell.setCellValue(object.toString());
            } else if (object instanceof Date) {
                Workbook wb = cell.getSheet().getWorkbook();
                CellStyle cellStyle = wb.createCellStyle();
                CreationHelper creationHelper = wb.getCreationHelper();
                cellStyle.setDataFormat(
                        creationHelper.createDataFormat().getFormat("yyyy-MM-dd hh:mm:ss")
                );
                cell.setCellStyle(cellStyle);
                cell.setCellValue((Date) object);
            } else if (object instanceof Number) {
                double d = MathUtil.asNumber(object, Double.class);
                cell.setCellValue(d);
            } else {
                throw new RuntimeException("parameter type must String ,Number,Date");
            }

        }

    }

    /**
     * <p>根据路径导出excel文件.
     * </p>
     * <pre>
     *     ExcelHelper.writeExcelFile(workbook,excelFilePath) ;
     * </pre>
     *
     * @param workbook
     * @param excelFilePath
     * *
     */
    public static void writeExcelFile(Workbook workbook, String excelFilePath) {
        try {
            FileOutputStream out = new FileOutputStream(excelFilePath);
            workbook.write(out);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }


    }

    /**
     * <p>通过路径获取Workbook对象.
     * </p>
     * <pre>
     *     ExcelHelper.getWorkbook("E:\test.xls") = Workbook;
     * </pre>
     *
     *  @param excelFilePath
     * *
     */
    public static Workbook getWorkbook(String excelFilePath) {
        Workbook workbook;
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(excelFilePath));
            workbook = WorkbookFactory.create(inputStream);

        } catch (Exception e) {
            throw new RuntimeException("Excel file is not find", e);
        } finally {
            try {
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return workbook;
    }


    /**
     * <p>通过序号Workbook得到工作博.
     * </p>
     * <pre>
     *     ExcelHelper.getSheet(workbook,0) = sheet 1;
     * </pre>
     *
     *  @param book
     *  @param i
     * *
     */
    public static Sheet getSheet(Workbook book, int i) {
        if (book != null) {
            return book.getSheetAt(i);
        }
        return null;
    }

    /**
     * <p>通过名字Woekbook得到工作博.
     * </p>
     * <pre>
     *     ExcelHelper.resolveSheet(workbook,0) = sheet 1;
     * </pre>
     *
     *  @param book
     *  @param name
     * *
     */
    public static Sheet getSheet(Workbook book, String name) {
        if (book != null) {
            return book.getSheet(name);
        }
        return null;
    }


    /**
     * <p>得到sheet某一行.
     * </p>
     * <pre>
     *     ExcelHelper.getRow(sheet,0) = Row;
     * </pre>
     *
     * @param sheet
     * @param i
     * *
     */
    public static Row getRow(Sheet sheet, int i) {
        if (sheet != null) {
            return sheet.getRow(i);
        } else {
            return null;
        }
    }


    /**
     * <p>得到sheet某一行的数据.
     * </p>
     * <pre>
     *     ExcelHelper.getRowData(sheet,0) = ["a","b","c"];
     * </pre>
     *
     * @param sheet
     * @param i
     * *
     */
    public static List<Object> getRowData(Sheet sheet, int i) {
        List<Object> rowData = new ArrayList<Object>();
        Row row = getRow(sheet, i);
        for (int j = 0; j < row.getLastCellNum(); j++) {
            Object cellValue = getCellValue(row.getCell(j));
            if (cellValue == null) {
                cellValue = "";
            }
            rowData.add(cellValue);
        }
        return rowData;
    }

    /**
     * <p>得到sheet某一行的数据.
     * </p>
     * <pre>
     *     ExcelHelper.getRowData(row) = ["a","b","c"];
     * </pre>
     * <p>
     * *
     */
    public static List<Object> getRowData(Row row) {
        List<Object> rowData = new ArrayList<Object>();
        for (int j = 0; j < row.getLastCellNum(); j++) {
            Object cellValue = getCellValue(row.getCell(j));
            if (cellValue == null) {
                cellValue = "";
            }
            rowData.add(cellValue);
        }
        return rowData;
    }


    /**
     * <p>得到sheet里从多少行到多少行数据.
     * </p>
     * <pre>
     *
     *     ExcelHelper.getRowsData(sheet,1) 获取第2行到最后一行;
     * </pre>
     * <p>
     * *
     */
    public static List<List<Object>> getRowsData(Sheet sheet, int start) {
        if (sheet != null) {
            return getRowsData(sheet, start, sheet.getLastRowNum() + 1);
        } else {
            return null;
        }
    }

    /**
     * <p>得到sheet里从多少行到多少行数据.
     * </p>
     * <pre>
     *     ExcelHelper.getRowsData(sheet,1,10) 获取第2行到第11行数据;
     *      ExcelHelper.getRowsData(sheet,1) 获取第2行到最后一行;
     * </pre>
     * <p>
     * *
     */
    public static List<List<Object>> getRowsData(Sheet sheet, int start, int end) {
        if (sheet != null) {
            List<List<Object>> rowsDatas = new ArrayList<List<Object>>();

            int rowCount = end;

            for (int i = start; i < rowCount; i++) {
                Row row = getRow(sheet, i);
                if (row == null) {
                    continue;
                }
                List<Object> rowData = getRowData(sheet, i);
                rowsDatas.add(rowData);
            }

            return rowsDatas;

        } else {
            return null;
        }
    }


    /**
     * <p>通过行的到里面的单元格.
     * </p>
     * <pre>
     *     ExcelHelper.getRow(sheet,0);
     * </pre>
     * <p>
     * *
     */
    public static Cell getCell(Row row, int i) {
        return row.getCell(i);
    }

    /**
     * <p>通过行和列的序号得到单元格.
     * </p>
     * <pre>
     *     ExcelHelper.getCellValue(Cell,0,0)
     * </pre>
     *
     * @param sheet
     * @param x
     * @param y
     * *
     */
    public static Cell getCell(Sheet sheet, int x, int y) {
        Row row = getRow(sheet, x);
        Cell cell = getCell(row, y);
        return cell;
    }

    /**
     * <p>得到Cell里的格式化数据.
     * </p>
     * <pre>
     *     ExcelHelper.getCellValue(Cell)
     * </pre>
     *
     * @param cell
     * *
     */
    public static Object getCellValue(Cell cell) {
        Object obj = null;
        if (cell == null)
            return null;
        CellType cellType = cell.getCellTypeEnum();
        switch (cellType) {
            case NUMERIC:
                double value = cell.getNumericCellValue();
                if (DateUtil.isCellDateFormatted(cell)) {
                    Date date = DateUtil.getJavaDate(value);
                    obj = date;
                } else {
                    String str = String.valueOf(value);
                    boolean isInteger = StringUtil.endsWith(str, ".0");
                    if (isInteger) {
                        str = StringUtil.replace(str, ".0", "");
                        Integer integer = MathUtil.asNumber(str, Integer.class);
                        obj = integer;
                    } else {
                        obj = value;
                    }
                }
                break;
            case STRING:
                obj = cell.getStringCellValue();
                break;
            case BLANK:
                obj = "";
                break;
            case ERROR:
                break;
            default:
                obj = cell.getRichStringCellValue();
        }
        return obj;
    }


}
