package shichi.demo.model.umsModel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 星币日志实体
 */
@Data
@Setter
@Getter
public class UmsIntegrationChangeHistory {
    //主键变动id
    private String changeId;

    //用户id
    private String userId;

    //创建时间
    private Date createdTime;

    //所属活动id
    private String activityId;

    //变更前积分
    private Integer beforeChangedCount;

    //变更数量
    private Integer changedCount;

    //操作人id
    private String adminId;

    //操作备注
    private String operateNote;

    //数据状态
    private Boolean dataState;

    //变动原因
    private String changedReason;

    //手动加减原因
    private String manualChangedReason;

}