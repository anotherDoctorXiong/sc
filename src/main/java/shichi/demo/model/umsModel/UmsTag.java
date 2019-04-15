package shichi.demo.model.umsModel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * 标签实体
 */
@Data
@Setter
@Getter
public class UmsTag {
    //标签id
    @NotEmpty
    private String tagId;

    //标签名称
    @NotEmpty
    private String tagName;

    //创建时间
    @NotEmpty
    private Date createdTime;

    //数据状态
    @NotEmpty
    private Boolean dataState;


}