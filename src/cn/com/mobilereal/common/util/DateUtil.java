package cn.com.mobilereal.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 
 * @author xiehuaping
 * @date 2014-03-06
 */
public class DateUtil {

public static Timestamp parseYMDEndTime(String time) {
     try {
         Date d = sdf4.parse(time + " 23:59:59");
         return new Timestamp(d.getTime());
      } catch (ParseException e) {
         return null;
      }
}
public static Timestamp convertToEndTime(Timestamp time) {
    if (time == null) return null;
    try {
        
        Date d = sdf4.parse(sdf2.format(time) + " 23:59:59");
        return new Timestamp(d.getTime());
     } catch (ParseException e) {
        return null;
     }
}
public static Timestamp convertToStartTime(Timestamp time) {
    if (time == null) return null;
    try {
        
        Date d = sdf4.parse(sdf2.format(time) + " 00:00:00");
        return new Timestamp(d.getTime());
     } catch (ParseException e) {
        return null;
     }
}
    public static Timestamp parseYMDStartTime(String time) {
        try {
            Date d = sdf4.parse(time + " 00:00:00");
            return new Timestamp(d.getTime());
        } catch (ParseException e) {
            return null;
        }
    }
    

	public static String formatTimeStr(String createTime) {
		long msgCreateTime = Long.parseLong(createTime) * 1000L;
		return sdf4.format(new Date(msgCreateTime));
	}

	public static String formatJSonTimeStr(Timestamp ts) {
		if (ts == null)
			return null;
		return sdf.format(ts);
	}

	public static Timestamp formatTime(String createTime) {
		long msgCreateTime = Long.parseLong(createTime) * 1000L;
		return new Timestamp(msgCreateTime);
	}

	public static Timestamp parseTime(String publishDate) {
		try {
			Date d = sdf5.parse(publishDate);
			return new Timestamp(d.getTime());
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

	}

	public static Timestamp parseYYYYMMDDTime(String publishDate) {
		try {
			Date d = sdf2.parse(publishDate);
			return new Timestamp(d.getTime());
		} catch (ParseException e) {
			return null;
		}
	}

	public static Timestamp parseChinaTime(String publishDate) {
		try {
			Date d = sdf6.parse(publishDate);
			return new Timestamp(d.getTime());
		} catch (ParseException e) {
			try {
				Date d = sdf7.parse(publishDate);
				return new Timestamp(d.getTime());
			} catch (Exception ee) {
				try {
					Date d = sdf8.parse(publishDate);
					return new Timestamp(d.getTime());
				} catch (Exception eee) {
					try {
						Date d = sdf9.parse(publishDate);
						return new Timestamp(d.getTime());
					} catch (Exception eee1) {
						throw new RuntimeException(eee1);
					}
				}
			}
		}
	}

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
	static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	static SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-01");
	static SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static SimpleDateFormat sdf5 = new SimpleDateFormat(
			"EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
	static SimpleDateFormat sdf6 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss",
			Locale.CHINA);
	static SimpleDateFormat sdf7 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm",
			Locale.CHINA);
	static SimpleDateFormat sdf8 = new SimpleDateFormat("yyyy年MM月dd日HH:mm",
			Locale.CHINA);
	static SimpleDateFormat sdf9 = new SimpleDateFormat("yyyy年MM月dd日",
			Locale.CHINA);

	public static java.sql.Date getSystemDate() {
		return new java.sql.Date(System.currentTimeMillis());
	}

	public static java.sql.Timestamp getSystemTimestamp() {
		return new java.sql.Timestamp(System.currentTimeMillis());
	}
	
    public static java.sql.Timestamp getSystemTimestampBeforeSecond(long second) {
        return new java.sql.Timestamp(System.currentTimeMillis() - second *1000);
    }

	public static java.sql.Timestamp getSystemTimestampAfterMinute(int minutes) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, minutes);
		return new java.sql.Timestamp(cal.getTimeInMillis());
	}

	public static String getMonthFirstDay() {
		return sdf3.format(getSystemDate());
	}

	public static String getSystemDateStr() {
		return sdf2.format(getSystemDate());
	}

	public static String getServerSystemDate() {
		return sdf.format(getSystemDate());
	}
	
	public static String formatYYYYMMDD(Timestamp time) {
        return sdf1.format(time);
    }
	public static Timestamp parseYMdHmsTimestamp(String time) {
		try {
			Date d = sdf.parse(time);
			return new Timestamp(d.getTime());
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
     * 将String型格式化,比如想要将2011-11-11格式化成20111111,就StringPattern("2011-11-11","yyyy-MM-dd","yyyyMMdd"). 
     * String日期转换成String日期
     * @param date String 想要格式化的日期 
     * @param oldPattern  String 想要格式化的日期的现有格式 
     * @param newPattern String 想要格式化成什么格式 
     * @return
     */
    public final static  String StringPattern(String date, String oldPattern, String newPattern) {   
        if (date == null || oldPattern == null || newPattern == null)   
            return "";   
        SimpleDateFormat sdf1 = new SimpleDateFormat(oldPattern) ;        // 实例化模板对象    
        SimpleDateFormat sdf2 = new SimpleDateFormat(newPattern) ;        // 实例化模板对象    
        Date d = null ;    
        try{    
            d = sdf1.parse(date) ;   // 将给定的字符串中的日期提取出来    
        }catch(Exception e){            // 如果提供的字符串格式有错误，则进行异常处理    
            e.printStackTrace() ;       // 打印异常信息    
        }    
        return sdf2.format(d);  
    }
    
    public static void main(String[] args) {
       System.out.println("edit".hashCode());
       System.out.println("add".hashCode());
       System.out.println("delete".hashCode());
       System.out.println("import".hashCode());
       System.out.println("distributeOrder".hashCode());
       System.out.println("createOrder".hashCode());
       
    }
}
