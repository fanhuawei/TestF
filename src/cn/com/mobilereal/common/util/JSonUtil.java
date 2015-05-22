package cn.com.mobilereal.common.util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.googlecode.jsonplugin.JSONException;
import com.googlecode.jsonplugin.JSONUtil;

public class JSonUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

	public static Object toJavaObjectFromJson(String str) {
		try {
			Object obj = JSONUtil.deserialize(str);
			if (obj instanceof Exception){
				throw (Exception)obj;
			}
			return obj;
		} catch (Exception e) {
			return new RuntimeException(e);
		}
	}
	
	public static Object toJavaObjectFromJson(InputStream ins) {
        try {
            Object obj = JSONUtil.deserialize(new InputStreamReader(ins,"UTF-8"));
            if (obj instanceof Exception){
                throw (Exception)obj;
            }
            return obj;
        } catch (Exception e) {
            return new RuntimeException(e);
        }
    }

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String toJson(Object obj) {
		if (obj == null)
			return "null";
		if (obj instanceof String) {
			try {
				return JSONUtil.serialize(obj);
			} catch (JSONException e) {
				throw new RuntimeException(e);
			}
		}
		if (obj instanceof Number) {
			return "\"" + obj + "\"";
		}
		if (obj instanceof Date) {
			return "\"" + sdf.format(obj) + "\"";
		}
		if (obj instanceof List) {
			List list = (List) obj;
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			int size = list.size();
			for (int i = 0; i < size; i++) {
				sb.append(toJson(list.get(i)));
				if (i < size - 1) {
					sb.append(",");
				}
			}
			sb.append("]");
			return sb.toString();
		}
		if (obj instanceof Map) {
			Map map = (Map) obj;
			StringBuilder sb = new StringBuilder();
			sb.append("{");
			Iterator<Map.Entry> iter = map.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry item = iter.next();
				Object aaa = item.getKey();
				Object val = item.getValue();
				if (aaa == null || val == null)
					continue;
				String key = aaa.toString();
				sb.append("\"").append(key).append("\"").append(":")
						.append(toJson(val));
				if (iter.hasNext()) {
					sb.append(",");
				}
			}
			if (",".equals(sb.substring(sb.length() - 1))) {
				sb.setLength(sb.length() - 1);
			}
			sb.append("}");
			return sb.toString();
		}
		try {
			return JSONUtil.serialize(obj);
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
       // String x = "[{\"category\":\"2001\",\"content\":\"qweqwewe\",\"score\":\"4\",\"personid\":\"8130\",\"lati\":\"23.33434\",\"longi\":\"23.234324\",\"speed\":\"23\",\"time\":\"20140911041230\",\"guid\":\"DAKDIALSFKJAS\"},{\"category\":\"2001\",\"content\":\"czxvczvc\",\"score\":\"4\",\"personid\":\"8130\",\"lati\":\"23.33434\",\"longi\":\"23.234324\",\"speed\":\"23\",\"time\":\"20140911041230\",\"guid\":\"sfdasfdsfeafewdafadsf\"},{\"category\":\"2001\",\"content\":\"asdfasdf\",\"score\":\"4\",\"personid\":\"8130\",\"lati\":\"23.33434\",\"longi\":\"23.234324\",\"speed\":\"23\",\"time\":\"20140911041230\",\"guid\":\"siadfhoweioajfieef\"}]";
        //Map y = (Map)toJavaObjectFromJson(x);
       // final List<Map<String, Object>> LIST = (List<Map<String, Object>>) JSonUtil.toJavaObjectFromJson(x);
        //System.out.println(LIST);
    }

}
