package shichi.demo.util.sms.client;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class JsonReqClient extends AbsRestClient{
    //accessKeyId
    private static final String ACCESSKRYID = "LTAIJR6lWr1f4zSY";

    //secret
    private static final String SECRET = "aGwP8CYa53kRf09Jcvopp1uIbl2Uak";

    //SendSms_Action
    private static final String SENDSMS_ACTION = "SendSms";

    //SendBatchSms_Action
    private static final String SENDBATCHSMS_ACTION = "SendBatchSms";

    //QuerySendDetails_Action
    private static final String QUERYSENDDETAILS_ACTION = "QuerySendDetails";

    /**
     * 短信发送接口
     * @param phoneNumbers 接收短信的手机号码, 支持对多个手机号码发送短信，手机号码之间以英文逗号（,）分隔
     * @param signName 短信签名名称
     * @param templateCode 短信模板ID
     * @param accessKeyId 主账号AccessKey的ID
     * @param action 系统规定参数。取值：SendSms
     * @param outId 外部流水扩展字段
     * @param smsUpExtendCode 上行短信扩展码
     * @param templateParam 短信模板变量对应的实际值
     * @return
     */
    @Override
    public String sendSms(String phoneNumbers, String signName, String templateCode, String accessKeyId, String action,
                          String outId, String smsUpExtendCode, String templateParam) {
        String result = "";

            DefaultProfile profile = DefaultProfile.getProfile("default", ACCESSKRYID, SECRET);
            IAcsClient client = new DefaultAcsClient(profile);

            CommonRequest request = new CommonRequest();
            request.setMethod(MethodType.POST);
            request.setDomain("dysmsapi.aliyuncs.com");
            request.setVersion("2017-05-25");
            request.setAction(SENDSMS_ACTION);
            request.putQueryParameter("PhoneNumbers", phoneNumbers);
            request.putQueryParameter("SignName", signName);
            request.putQueryParameter("TemplateCode", templateCode);
            request.putQueryParameter("TemplateParam", templateParam);
            request.putQueryParameter("SmsUpExtendCode", smsUpExtendCode);
            request.putQueryParameter("OutId", outId);
            try {
                CommonResponse response = client.getCommonResponse(request);
                System.out.println(response.getData());
                result = response.getData();
            }catch (ServerException e) {
                e.printStackTrace();
            }catch (ClientException e) {
                e.printStackTrace();
            }
        return result;
    }

    /**
     * 短信批量发送接口
     * @param phoneNumberJson 接收短信的手机号码，JSON数组格式
     * @param signNameJson  短信签名名称，JSON数组格式
     * @param templateCode  短信模板CODE
     * @param accessKeyId  主账号AccessKey的ID
     * @param action  系统规定参数。取值：SendBatchSms
     * @param smsUpExtendCodeJson 上行短信扩展码，JSON数组格式
     * @param templateParamJson 短信模板变量对应的实际值，JSON格式
     * @return
     */
    @Override
    public String sendBatchSms(String phoneNumberJson, String signNameJson, String templateCode, String accessKeyId,
                               String action, String smsUpExtendCodeJson, String templateParamJson) {
        String result = "";
        DefaultProfile profile = DefaultProfile.getProfile("default", ACCESSKRYID, SECRET);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction(SENDBATCHSMS_ACTION);
        request.putQueryParameter("PhoneNumberJson", phoneNumberJson);
        request.putQueryParameter("SignNameJson", signNameJson);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParamJson", templateParamJson);
        request.putQueryParameter("SmsUpExtendCodeJson", smsUpExtendCodeJson);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            result = response.getData();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查看短信发送记录和发送状态
     * @param currentPage  当前页
     * @param pageSize  每页记录数量
     * @param phoneNumber  接收短信的手机号码
     * @param sendDate  短信发送日期, 支持查询最近30天的记录
     * @param accessKeyId 主账号AccessKey的ID
     * @param action 系统规定参数。取值：QuerySendDetails
     * @param bizId 发送回执ID，即发送流水号
     * @return
     */
    @Override
    public String querySendDetails(String currentPage, String pageSize, String phoneNumber, String sendDate,
                                   String accessKeyId, String action, String bizId) {
        String result = "";
        DefaultProfile profile = DefaultProfile.getProfile("default", ACCESSKRYID, SECRET);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction(QUERYSENDDETAILS_ACTION);
        request.putQueryParameter("PhoneNumber", phoneNumber);
        request.putQueryParameter("SendDate", sendDate);
        request.putQueryParameter("PageSize", pageSize);
        request.putQueryParameter("CurrentPage", currentPage);
        request.putQueryParameter("BizId", bizId);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            result = response.getData();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return result;
    }
}
