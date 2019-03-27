package shichi.demo.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Response {
    private int code;
    private String message;
    private int timestamp;
    private Object data;
    public final static Map<Integer, String> ErrorMessage = new HashMap<Integer, String>() {
        {
            put(0, "success");
            put(1, "error params");
        }
    };


    public Response() {
        this.code = 0;
        this.message = "success";
        this.timestamp=(int)(new Date().getTime()/1000);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
        this.message = ErrorMessage.get(this.code);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message =message;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
