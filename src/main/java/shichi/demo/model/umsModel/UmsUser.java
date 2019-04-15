package shichi.demo.model.umsModel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 用户实体
 */
@Data
@Setter
@Getter
public class UmsUser {
    //用户星球id
    private String userId;

    //用户昵称
    private String nickname;

    //手机号
    private String phone;

    //城市
    private String city;

    //性别
    private int sex;

    //星币
    private Integer integration;

    //订阅状态
    private Boolean subscriptionState;

    //微信openID
    private String openId;

    //注册时间
    private Date registerTime;

    //账户状态
    private Boolean state;

    //最后访问时间
    private Date lastVisitTime;
}