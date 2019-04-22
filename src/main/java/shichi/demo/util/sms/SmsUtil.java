package shichi.demo.util.sms;

import shichi.demo.util.sms.client.AbsRestClient;
import shichi.demo.util.sms.client.JsonReqClient;

public class SmsUtil {
    private static AbsRestClient InstantiationRestAPI(){
        return new JsonReqClient();
    }

    public String sendSms(String phoneNumbers, String signName, String templateCode, String accessKeyId, String action,
                          String outId, String smsUpExtendCode, String templateParam){
        try {
            String result = InstantiationRestAPI().sendSms(phoneNumbers, signName, templateCode, accessKeyId, action, outId,
                    smsUpExtendCode, templateParam);
            System.out.println("Response content is: " + result);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return "系统异常";
        }
    }

    public String sendBatchSms(String phoneNumberJson, String signNameJson, String templateCode, String accessKeyId,
                               String action, String smsUpExtendCodeJson, String templateParamJson){
        try {
            String result = InstantiationRestAPI().sendBatchSms(phoneNumberJson, signNameJson, templateCode,
                    accessKeyId, action, smsUpExtendCodeJson, templateParamJson);
            System.out.println("Response content is: " + result);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            return "系统异常";
        }
    }

    public String querySendDetails(Long currentPage, Long pageSize, String phoneNumber, String sendDate,
                                   String accessKeyId, String action, String bizId) {
        try {
            String result = InstantiationRestAPI().querySendDetails(currentPage, pageSize, phoneNumber, sendDate,
                    accessKeyId, action, bizId);
            System.out.println("Response content is: " + result);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            return "系统异常";
        }
    }
}
