package cn.com.mobilereal.common.web;

import java.beans.PropertyEditorSupport;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampPropertyEditor extends PropertyEditorSupport {

    private SimpleDateFormat sdfymd = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat sdfyhm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private SimpleDateFormat sdfhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat sdfapp = new SimpleDateFormat("yyyyMMddHHmmss");
    @Override
    public String getAsText() {
       Timestamp ts = (Timestamp) getValue();
       if (ts!=null){
         return sdfymd.format(ts);
       }else{
         return "";
       }
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            if (text==null || text.trim().length()==0){
               setValue(null);
            }else{
              int length = text.length();
              if (length<="yyyy-MM-dd".length()){
                  Date dd = sdfymd.parse(text);
                  setValue(new Timestamp(dd.getTime()));
              }else if (length<="yyyy-MM-dd HH:mm".length()){
                  Date dd = sdfyhm.parse(text);
                  setValue(new Timestamp(dd.getTime()));
              }else if (length<="yyyy-MM-dd HH:mm:ss".length()){
                  Date dd = sdfhms.parse(text);
                  setValue(new Timestamp(dd.getTime()));
              }else if (length=="yyyyMMddHHmmss".length()){
                  Date dd = sdfapp.parse(text);
                  setValue(new Timestamp(dd.getTime()));      
              }           
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
        
    }
}
