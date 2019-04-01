package shichi.demo.util;

import com.alibaba.fastjson.JSON;
import shichi.demo.model.pmsModel.PmsProduce;

import java.util.Date;

public class JSONTestUtil {

    public static void main(String[] args) {
        PmsProduce produce = new PmsProduce();
        produce.setBrandId("11121");
        produce.setBrandName("测试");
        produce.setCreatedTime(new Date());
        produce.setDataState(true);
        produce.setProduceName("测试产品");
        String s = JSON.toJSONString(produce);
        System.out.println(s);
    }
}
