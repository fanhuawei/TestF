/**
 * ExcelUtil.java
 * Created at 2014年7月23日
 * Created by Fanhuawei
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package cn.com.mobilereal.common.util;

import java.io.File;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * <p>ClassName: ExcelUtil</p>
 * <p>Description: POI封装类</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014年7月23日</p>
 */
public class ExcelUtil {

   static transient Logger log = Logger.getLogger(ExcelUtil.class);

  public static Workbook openFile(String file) {
      try {
          return WorkbookFactory.create(new File(file));
      } catch (Throwable e) {
          log.error(e);
          throw new RuntimeException(e.getMessage(),e.getCause());
      }
  }
  
  public static List<Map<String,String>> readExcel(String file,int sheetIndex,int startRow) {
      Workbook wb = openFile(file);
      Sheet sheet = wb.getSheetAt(sheetIndex);
      int lastRow = sheet.getLastRowNum();
      System.out.println(lastRow);
      List<Map<String,String>> ret = new ArrayList<Map<String,String>>();
      for (int i = startRow;i<=lastRow;i++){
         Map<String,String> row = new TreeMap<String,String>();
         ret.add(row);
         short lastColumn = sheet.getRow(i).getLastCellNum();
         char key = 'A';
         for (int c = 0;c<lastColumn;c++){
           row.put(String.valueOf(key), getCellValue(sheet.getRow(i), c));
           key = (char)(key + 1);
         }
      }
      return ret;
  }

  public static void setCellValue(Sheet sheet,int row, int column,String val){
     Row sheetRow = sheet.getRow(row);
     if (sheetRow!=null) {
       Cell cell = sheetRow.getCell(column);
       if (cell!=null){
         cell.setAsActiveCell();
         cell.setCellValue(val);
       }
     } 
  }
  
  public static void setCellValue(Row sheetRow, int column,String val){
        Cell cell = sheetRow.getCell(column);
        if (cell!=null){
          cell.setAsActiveCell();
          cell.setCellValue(val);
        }
   }
   /*
   public static void setImage(Sheet sheet, int row1, int column1, int row2, int column2, Long assetId) {
        final Attachment ATTA = Attachment.I.findById(assetId);
        if (ATTA == null) return;
        String fullFile = AttachmentUtil.makeAttachmentPath(ATTA);
        if (!new File(fullFile).exists()) {
          log.warn("图片资源不存在:" + fullFile);
          return;
        }
        int imageType = Workbook.PICTURE_TYPE_PNG;
        final Drawing DW = sheet.createDrawingPatriarch();
        final ClientAnchor ANCHOR = DW.createAnchor(0, 0, 1023, 255, (short)column1, row1, (short)column2, row2);
        if (assetId == null) return;
        
        if (!"PNG".equalsIgnoreCase(ATTA.getStorePath().substring(ATTA.getStorePath().length() - 3))) {
            imageType = Workbook.PICTURE_TYPE_JPEG;
        }
        try {
            final byte[] AA = StreamUtil.transform(new FileInputStream(fullFile));
            DW.createPicture(ANCHOR, sheet.getWorkbook().addPicture(AA, imageType)).resize(0.5D);
        } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
        } 
    }
 */
  public static String getCellValue(Sheet sheet,int row, int column){
      Row sheetRow = sheet.getRow(row);
      if (sheetRow!=null) {
          return getCellValue(sheetRow,column);
      }
      return null;
  }
  
  public static String getCellValue(Row row, int column){
      Cell cell = row.getCell(column);
      return getStringCellValue(cell);  
   }
  public static String getStringCellValue(Cell cell) {
      String strCell = "";
      if(cell==null||cell.getCellStyle()==null){
          return "";
      }
      switch (cell.getCellType()) {
      case Cell.CELL_TYPE_STRING:
          strCell = cell.getStringCellValue().trim();
          break;
      case Cell.CELL_TYPE_NUMERIC:
          if (HSSFDateUtil.isCellDateFormatted(cell)) {  
              double d = cell.getNumericCellValue();  
              java.util.Date date = HSSFDateUtil.getJavaDate(d); 
              SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM-dd");
              strCell=dformat.format(date).trim();
           }else{
             NumberFormat nf = NumberFormat.getInstance();
             nf.setMaximumFractionDigits(4);
             nf.setGroupingUsed(false);//true时的格式：1,234,567,890
             strCell= nf.format(cell.getNumericCellValue()).trim();
           } 
          break;
      case Cell.CELL_TYPE_BOOLEAN:
          strCell = String.valueOf(cell.getBooleanCellValue()).trim();
          break;
      case Cell.CELL_TYPE_BLANK:
          strCell = "";
          break;
      case Cell.CELL_TYPE_FORMULA:
          strCell = cell.getCellFormula().trim();
          break;                    
      default:
          strCell = "";
          break;
      }
      if (strCell.equals("") || strCell == null) {
          return "";
      }
      return strCell;
  }
  public static void main(String[] args) {
     readExcel("c:/abc.xlsx", 0, 1);
}

}
