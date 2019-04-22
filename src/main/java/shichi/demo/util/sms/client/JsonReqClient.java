package shichi.demo.util.sms.client;

import com.alibaba.fastjson.JSONObject;
import shichi.demo.util.sms.HttpClientUtil;

public class JsonReqClient extends AbsRestClient{
    @Override
    public String sendSms(String phoneNumbers, String signName, String templateCode, String accessKeyId, String action,
                          String outId, String smsUpExtendCode, String templateParam) {
        String result = "";
        try {
            String url = getStringBuffer().toString();

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("phoneNumbers", phoneNumbers);
            jsonObject.put("signName", signName);
            jsonObject.put("templateCode", templateCode);
            jsonObject.put("accessKeyId", accessKeyId);
            jsonObject.put("action", action);
            jsonObject.put("outId", outId);
            jsonObject.put("smsUpExtendCode", smsUpExtendCode);
            jsonObject.put("templateParam", templateParam);

            String body = jsonObject.toJSONString();

            System.out.println("requestBody = " + body);

            result = HttpClientUtil.postJson(url, body, null);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String sendBatchSms(String phoneNumberJson, String signNameJson, String templateCode, String accessKeyId,
                               String action, String smsUpExtendCodeJson, String templateParamJson) {
        String result = "";
        try {
            String url = getStringBuffer().toString();

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("phoneNumberJson", phoneNumberJson);
            jsonObject.put("signNameJson", signNameJson);
            jsonObject.put("templateCode", templateCode);
            jsonObject.put("accessKeyId", accessKeyId);
            jsonObject.put("action", action);
            jsonObject.put("smsUpExtendCodeJson", smsUpExtendCodeJson);
            jsonObject.put("templateParamJson", templateParamJson);

            String body = jsonObject.toJSONString();

            System.out.println("requestBody = " + body);

            result = HttpClientUtil.postJson(url, body, null);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String querySendDetails(Long currentPage, Long pageSize, String phoneNumber, String sendDate,
                                   String accessKeyId, String action, String bizId) {
        String result = "";
        try {
            String url = getStringBuffer().toString();

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("currentPage", currentPage);
            jsonObject.put("signName", pageSize);
            jsonObject.put("phoneNumber", phoneNumber);
            jsonObject.put("sendDate", sendDate);
            jsonObject.put("accessKeyId", accessKeyId);
            jsonObject.put("action", action);
            jsonObject.put("bizId", bizId);

            String body = jsonObject.toJSONString();

            System.out.println("requestBody = " + body);

            result = HttpClientUtil.postJson(url, body, null);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
