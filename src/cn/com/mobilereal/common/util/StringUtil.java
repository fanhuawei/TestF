package cn.com.mobilereal.common.util;

import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class StringUtil {
    private static Random random = new Random();
  public static String trim(String x){
      if (x == null) return null;
      return x.trim();
  }
  public static void main(String[] args) {
    System.out.println(makeRandomPassword());
}
  public static String makeRandomPassword(){
     StringBuilder sb = new StringBuilder();
     for (int i=0;i<6;i++){
     int x = random.nextInt(10);
     System.out.println(x);
     sb.append(x);
     }
     return sb.substring(0,6);     
  }
  
  public static String makeErrorCode(){
    return DateUtil.formatJSonTimeStr(new Timestamp(System.currentTimeMillis())) + random.nextInt(1000);
  }
  
  public static boolean isEmpty(Object x){
     if (x == null) return true;
     if (x instanceof String) {
       if (x.toString().trim().length()==0) {
         return true;
       }
     }
     return false;
  }
  
  public static boolean validateLength(String x, int max){
    if (x==null) return true;
    if (x.trim().length()>max){
      return false;
    }
    return true;
  }
  public static String getStringCellValue(Cell cell) {
      String strCell = "";
      if(cell==null||cell.getCellStyle()==null){
          return "";
      }
      switch (cell.getCellType()) {
      case Cell.CELL_TYPE_STRING:
          strCell = cell.getStringCellValue();
          break;
      case Cell.CELL_TYPE_NUMERIC:
          if (HSSFDateUtil.isCellDateFormatted(cell)) {  
              double d = cell.getNumericCellValue();  
              java.util.Date date = HSSFDateUtil.getJavaDate(d); 
              SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM-dd");
              strCell=dformat.format(date);
           }else{
             NumberFormat nf = NumberFormat.getInstance();
             nf.setMaximumFractionDigits(4);
             nf.setGroupingUsed(false);//true时的格式：1,234,567,890
             strCell= nf.format(cell.getNumericCellValue());
           } 
          break;
      case Cell.CELL_TYPE_BOOLEAN:
          strCell = String.valueOf(cell.getBooleanCellValue());
          break;
      case Cell.CELL_TYPE_BLANK:
          strCell = "";
          break;
      case Cell.CELL_TYPE_FORMULA:
          strCell = cell.getCellFormula();
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
  
  /**
   * 用正则表达式判断一个字符串是否全部是数字
   * 
   * @param str
   *            ：要判断的字符串
   * @return 返回true表示字符串是数字，否则不是数字
   */
  public static boolean isNumeric(String str) {
      Pattern pattern = Pattern.compile("[0-9]*");
      Matcher isNum = pattern.matcher(str);
      if (!isNum.matches()) {
          return false;
      }
      return true;
  }
  
  /**
   * 
   * <p>Description: 如果一行所有单元格都为空，就不做check，直接跳过</p>
   * @param colLength 行长度
   * @param row 行
   * @param cell 列
   * @return 空格的行数
   */
  public static int countNull(int colLength, Row row, Cell cell) {
      int nullValueCount = 0;
      for (int k = 0; k < colLength; k++) {
          cell = row.getCell(k);
          final String VALUE = StringUtil.getStringCellValue(cell);
          if (VALUE == null || "".equals(VALUE.trim())) {
              nullValueCount++;
          }
      }
      return nullValueCount;
  }
  /**
   * 
   * <p>Description: 判断序号是否是正确，下一级序号，是上一级序号加上.加上1为的数字</p>
   * @param prentCode 上一级序号
   * @param currentCode 当前序号
   * @return 是否正确，如果满足条件就返回true，否则返回false
   */
    public static boolean checkCode(String prentCode, String currentCode) {
        int idx = currentCode.lastIndexOf(".");
        if (idx <= 0) {
            return false;
        }
        final String SUBCODE = currentCode.substring(0, currentCode.lastIndexOf("."));
        final String NEWSTRING = currentCode.substring(currentCode.lastIndexOf(".") + 1, currentCode.length());
        return SUBCODE.equals(prentCode) && StringUtil.isNumeric(NEWSTRING) && NEWSTRING.length() <= 2;
    }

  /**
   * 
   * <p>Description: excel列号转换为数值序号</p>
   * @param s 列号
   * @return 转换后的数值序号
   */
  public static int S2I(String s) {
      int length = s.length();
      int result = 0;
      for (int i = 0; i < length; i++) {
          char c = s.charAt(i);
          if (Character.isUpperCase(c)) {
              result += (int)(c - 'A' + 1) * (int)Math.pow(26, length - i - 1);
              continue;
          }
          return 0;
      }
      return result;
  }

  /**
   * <p>Description: excel数值序号转换为列号</p>
   * @param s 列号
   * @return 转换后的列号
   */
  public static String I2S(int i) {
      if (i < 1)
          return "";
      int temp = i;
      StringBuffer sb = new StringBuffer();
      while (temp != 0) {
          int reminder = temp % 26;
          if (reminder == 0) {
              reminder = 26;
              temp--;
          }
          sb.append((char)(reminder + 'A' - 1));
          temp /= 26;
      }
      return sb.reverse().toString();
  }
  
}
