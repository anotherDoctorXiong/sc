package shichi.demo.util;

import com.alibaba.fastjson.JSONArray;

public class JsonUtil {

    public static JSONArray StringToJSONArray (String str){
        JSONArray jsonArray = new JSONArray();
        jsonArray = JSONArray.parseArray(str);
        return jsonArray;
    }
}
