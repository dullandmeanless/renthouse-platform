package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

//将后端的数据转成json字符串形式输出到前端
public class JsonUtils {
    public static String getJson(Object object){
        return getJson(object,"yyyy-MM-dd HH:mm:ss");
    }
    public static String getJson(Object object,String dateformat){
        ObjectMapper mapper=new ObjectMapper();
//        不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
//        自定义时间格式
        SimpleDateFormat sdf=new SimpleDateFormat(dateformat);
        mapper.setDateFormat(sdf);
        try{
            return mapper.writeValueAsString(object);
        }    catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }

}
