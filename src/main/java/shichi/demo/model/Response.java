package shichi.demo.model;

import com.github.pagehelper.PageInfo;

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

    /**
     * 普通成功返回
     *
     * @param data 获取的数据
     */
    public Response success(Object data) {
        this.code = 0;
        this.message = "操作成功";
        this.data = data;
        return this;
    }



    /**
     * 返回分页成功数据
     */
    public Response pageSuccess(List data) {
        PageInfo pageInfo = new PageInfo(data);
        Map<String, Object> result = new HashMap<>();
        result.put("pageSize", pageInfo.getPageSize());
        result.put("pageTotal", pageInfo.getPages());
        result.put("total", pageInfo.getTotal());
        result.put("pageNum", pageInfo.getPageNum());
        result.put("lists", pageInfo.getList());
        this.code = 0;
        this.message = "操作成功";
        this.data = result;
        return this;
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
