package cn.com.mobilereal.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import cn.com.mobilereal.common.bean.LatLng;


public class MapUtil {
	private static transient Logger log = Logger.getLogger(MapUtil.class);
	
	private static String getElementValue(Document doc, String name) {
		NodeList list = doc.getElementsByTagName(name);
		Object xx = list.item(0).getChildNodes().item(0);
		if (xx instanceof Text) {
			Text tt = (Text) xx;
			return tt.getData();
		}
		return "";
	}
	
	@SuppressWarnings("unchecked")
    public static LatLng convertLatlng(String lat,String lng) {
	    String format = "http://api.zdoz.net/transgps.aspx?lat=%s&lng=%s";
	    LatLng bean = new LatLng(new Double(lat),new Double(lng));
	    String remoteURL = String.format(format, lat,lng);
	    try {
            //log.info(remoteURL);
            GetMethod method = new GetMethod(remoteURL);
            method.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
            HttpClient client = new HttpClient();
            int ret = client.executeMethod(method);
            if (ret == HttpStatus.SC_OK) {
                String json = method.getResponseBodyAsString();
                Map<String,Object> map = (Map<String,Object>)JSonUtil.toJavaObjectFromJson(json);
                Number numLng = (Number)map.get("Lng");
                Number numLat = (Number)map.get("Lat");
                bean.setLat(numLat.doubleValue());
                bean.setLng(numLng.doubleValue());
            }
        } catch (Throwable e) {
            log.error(e.getMessage(), e.getCause());
            return bean;
        }
        return bean;   
       
	}

	private static String google = "http://ditu.google.cn/maps/api/geocode/xml?latlng=%s,%s&sensor=true";
	public static String makeAddress(String lat, String lng) {
		String remoteURL = String.format(google, lat, lng);
		String addr = makeAddress(remoteURL,lat,lng);
		return addr;
	}
	
	public static String makeUrlParam(String link, String paramName) {
	    int start = link.indexOf("&" + paramName+ "=");
        if (start>0){
            int end = link.indexOf("&", start+1);
            if (end<=0){ 
              end = link.length();
            }
            return link.substring(start + paramName.length()+2, end);
        }else{
            start = link.indexOf("?" + paramName+ "=");
            if (start>0){
                int end = link.indexOf("&", start+1);
                if (end<=0) end = link.length();
                return link.substring(start + paramName.length()+2, end);
            }
        }
        return null;
    }
	public static List<LatLng> decodePoly(String encoded) {

	      List<LatLng> poly = new ArrayList<LatLng>();
	      int index = 0, len = encoded.length();
	      int lat = 0, lng = 0;

	      while (index < len) {
	          int b, shift = 0, result = 0;
	          do {
	              b = encoded.charAt(index++) - 63;
	              result |= (b & 0x1f) << shift;
	              shift += 5;
	          } while (b >= 0x20);
	          int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
	          lat += dlat;

	          shift = 0;
	          result = 0;
	          do {
	              b = encoded.charAt(index++) - 63;
	              result |= (b & 0x1f) << shift;
	              shift += 5;
	          } while (b >= 0x20);
	          int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
	          lng += dlng;

	          LatLng p = new LatLng((((double) lat / 1E5)),
	                  (((double) lng / 1E5)));
	          poly.add(p);
	      }

	      return poly;
	  }
    
	private static String makeAddress(String remoteURL,String lat, String lng) {
		try {
			//log.info(remoteURL);
			GetMethod method = new GetMethod(remoteURL);
			method.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
			HttpClient client = new HttpClient();
			int ret = client.executeMethod(method);
			if (ret == HttpStatus.SC_OK) {
				java.io.InputStream ins = method.getResponseBodyAsStream();
				DocumentBuilder db = DocumentBuilderFactory.newInstance()
						.newDocumentBuilder();
				Document doc = db.parse(ins);
				String status = getElementValue(doc, "status");
				if ("OK".equalsIgnoreCase(status) || "0".equalsIgnoreCase(status)) {
					String x = getElementValue(doc, "formatted_address");
					return renderAddress(x);
				}
			}
		} catch (Throwable e) {
			return null;
		}
		return null;
	}
	
	public static String renderAddress(String addr){
		if (addr==null || addr.trim().length()==0) return "";
		if ("中国".equals(addr.substring(0, 2))){
			addr = addr.substring(2);
		}
		int idx = addr.indexOf("邮政编码");
		if (idx > 0) {
			addr = addr.substring(0, idx);
		}
		addr = addr.replaceAll(" ","");
		return addr;
	}
}
