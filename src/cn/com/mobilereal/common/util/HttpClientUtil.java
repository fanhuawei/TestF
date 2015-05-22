/**
 * HttpClientUtil.java
 * Created at 2014年8月19日
 * Created by Fanhuawei
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package cn.com.mobilereal.common.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 * <p>ClassName: HttpClientUtil</p>
 * <p>Description: HttpClint工具类</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014年8月19日</p>
 */
public class HttpClientUtil {
    /**
     * 
     * <p>Description: 发送URL请求,返回请求结果</p>
     * @param link URL地址
     * @return 请求结果
     */
    public static String post(String link) {
        StringBuffer sb = null;
        String line = null;
        String ret = null;
        InputStream ins = null;
        BufferedReader br = null;
        final HttpClient CLI = new HttpClient();
        final GetMethod MET = new GetMethod(link);
        try {
            final int RET = CLI.executeMethod(MET);
            if (RET == HttpStatus.SC_OK) {
                ins = MET.getResponseBodyAsStream();
                br = new BufferedReader(new InputStreamReader(ins, "GBK"));
                sb = new StringBuffer();
                line = br.readLine();
                while (line != null) {
                    sb.append(line).append("\n");
                    line = br.readLine();
                }
                ret = sb.toString();
            }
            return ret;
        } catch (Throwable e) {
            return ret;
        }
    }
}
