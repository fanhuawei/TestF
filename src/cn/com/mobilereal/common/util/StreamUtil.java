/**
 * StreamUtil.java
 * Created at 2014年7月23日
 * Created by Fanhuawei
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package cn.com.mobilereal.common.util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * <p>
 * ClassName: StreamUtil
 * </p>
 * <p>
 * Description: TODO
 * </p>
 * <p>
 * Author: Fanhuawei
 * </p>
 * <p>
 * Date: 2014年7月23日
 * </p>
 */
public class StreamUtil {

    public static void transform(InputStream ins, OutputStream out) {
        try {
            if (ins != null && out != null) {
                byte[] arr = new byte[10 * 1024];
                int len = ins.read(arr);
                while (len > 0) {
                    out.write(arr, 0, len);
                    len = ins.read(arr);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (ins != null) {
                try {
                    ins.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {

                }
            }
        }
    }
    
    public static byte[] transform(InputStream ins) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        transform(ins,out);
        return out.toByteArray();
    }
    
    public static void main(String[] args) throws Exception{
        byte[] xx = transform(new FileInputStream("c:/wireless.txt"));
        System.out.println(Arrays.toString(xx));
    }

}
