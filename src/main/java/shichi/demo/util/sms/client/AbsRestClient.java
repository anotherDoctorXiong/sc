package shichi.demo.util.sms.client;

public abstract class AbsRestClient {


    /**
     * 短信发送接口, 支持在一次请求中向多个不同的手机号码发送同样内容的短信
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
    public abstract String sendSms(String phoneNumbers, String signName, String templateCode,
                                   String accessKeyId, String action, String outId,
                                   String smsUpExtendCode, String templateParam);


    /**
     * 短信批量发送接口, 支持在一次请求中分别向多个不同的手机号码发送不同签名的短信
     * @param phoneNumberJson 接收短信的手机号码，JSON数组格式
     * @param signNameJson  短信签名名称，JSON数组格式
     * @param templateCode  短信模板CODE
     * @param accessKeyId  主账号AccessKey的ID
     * @param action  系统规定参数。取值：SendBatchSms
     * @param smsUpExtendCodeJson 上行短信扩展码，JSON数组格式
     * @param templateParamJson 短信模板变量对应的实际值，JSON格式
     * @return
     */
    public abstract String sendBatchSms(String phoneNumberJson, String signNameJson, String templateCode,
                                        String accessKeyId, String action, String smsUpExtendCodeJson,
                                        String templateParamJson);

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
    public abstract String querySendDetails(String currentPage, String pageSize, String phoneNumber,
                                            String sendDate, String accessKeyId, String action,
                                            String bizId);



}
