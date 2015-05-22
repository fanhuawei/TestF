package cn.com.mobilereal.common.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.dd.plist.NSDictionary;
import com.dd.plist.PropertyListParser;

public class XmlUtil {	
	
	
	public static Map<String, String> getAppInfo(String filePath){
	   ZipFile file = null;
	   Map<String, String> ret = new HashMap<String, String>();
	   File apk = new File(filePath);
	   
	   if(apk.exists() && apk.getName().endsWith(".ipa")){
	    	try {
	            file = new ZipFile(filePath);
	            @SuppressWarnings("unchecked")
	            Enumeration<ZipEntry> enu = (Enumeration<ZipEntry>) file.entries();
	            while (enu.hasMoreElements()) { 
	                ZipEntry zipElement = (ZipEntry) enu.nextElement();
	                InputStream read = file.getInputStream(zipElement);
	                String fileName = zipElement.getName();
	                if (fileName != null && fileName.indexOf(".") != -1) {
		                	if("Info.plist".equals(fileName.substring(fileName.lastIndexOf("/")+1, fileName.length()))){
		                		NSDictionary parse = (NSDictionary)PropertyListParser.parse(read);
		                    	ret.put("APP_ID", parse.objectForKey("CFBundleIdentifier")!=null?parse.objectForKey("CFBundleIdentifier").toString():"");
		                    	ret.put("VERSION", parse.objectForKey("CFBundleShortVersionString")!=null?parse.objectForKey("CFBundleShortVersionString").toString():"");
		                    	ret.put("TYPE", "I");
		                    	ret.put("APP_NAME", parse.objectForKey("CFBundleDisplayName")!=null?parse.objectForKey("CFBundleDisplayName").toString():"");
		                    	ret.put("RELEASE_TIME", parse.objectForKey("ReleaseDate")!=null?parse.objectForKey("ReleaseDate").toString():"");
		                    	break;
		                	}
	                	}
	                }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally{
	        	try {
				   file.close();
				} catch (IOException e) {
				}
			}		   
	   }
		return ret;
	}
    public static void main(String[] args) {
    //System.out.println(getAppInfo("c:/iCheck20131018.apk"));
    	System.out.println(getAppInfo("D:/wasshare/fbs/app/FBS.ipa"));
    	
	}

	
}
