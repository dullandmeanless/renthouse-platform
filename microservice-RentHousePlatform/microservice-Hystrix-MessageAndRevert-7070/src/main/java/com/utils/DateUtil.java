package com.messageandrevert.utils;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class DateUtil {
    DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public  String format(Date date){
        return dateFormat.format(date);
    }
}
