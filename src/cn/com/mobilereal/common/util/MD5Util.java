package cn.com.mobilereal.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
	public static String md5(String x) {
		try {
			byte[] ret = MessageDigest.getInstance("MD5").digest(x.getBytes());
			StringBuilder sb = new StringBuilder();
			for (byte b : ret) {
				int c = b;
				if (c<0){
					c = 256 + c;
				}
				String str = Integer.toHexString(c);
				if (str.length()==1){
					str = "0" + str;
				}
				sb.append(str);
			}
			return sb.toString();
		} catch (Exception e) {
			return x;
		}
	}
	
	public static String md5(InputStream ins) {
        try {
            return DigestUtils.md5Hex(ins);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	public static String md5(File file) {
        try {
            return DigestUtils.md5Hex(new FileInputStream(file));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	public static void main(String[] args) {

	}
}
